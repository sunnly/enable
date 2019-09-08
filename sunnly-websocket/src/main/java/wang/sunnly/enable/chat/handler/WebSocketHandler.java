package wang.sunnly.enable.chat.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import javax.websocket.PongMessage;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketHandler
 *
 * @author Sunnly
 * @create 2019/8/11 0011 22:12
 */
public class WebSocketHandler extends AbstractWebSocketHandler {

    /**
     * 存储sessionId和webSocketSession
     * 需要注意的是，webSocketSession没有提供无参构造，不能进行序列化，也就不能通过redis存储
     * 在分布式系统中，要想别的办法实现webSocketSession共享
     */
    private static Map<String, WebSocketSession> sessionMap = new ConcurrentHashMap<>();
    private static Map<String, String> userMap = new ConcurrentHashMap<>();
    private static Map<String, String> sessionUserMap = new ConcurrentHashMap<>();
    DateFormat df = new SimpleDateFormat("YYYYMMddhhmmss");

    /**
     * webSocket连接创建后调用
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // 获取参数
        String user = String.valueOf(session.getAttributes().get("user"));
        userMap.put(user, session.getId());
        sessionMap.put(session.getId(), session);
        sessionUserMap.put(session.getId(), user);
        //通知大家我来啦
        sends("System",String.format("%s进入聊天室", user));
    }

    /**
     * 接收到消息会调用
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        if (message instanceof TextMessage) {
            sends(sessionUserMap.get(session.getId()), ((TextMessage)message).getPayload());
        } else if (message instanceof BinaryMessage) {

        } else if (message instanceof PongMessage) {

        } else {
            System.out.println("Unexpected WebSocket message type: " + message);
        }
    }

    /**
     * 连接出错会调用
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        sessionMap.remove(session.getId());
    }

    /**
     * 连接关闭会调用
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        //我先撤了
        String user = sessionUserMap.get(session.getId());
        sessionMap.remove(session.getId());
        sessionUserMap.remove(session.getId());
        sends("System",String.format("%s退出聊天室", user));
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    /**
     * 后端发送消息
     */
    public void sendMessage(String user, String message){
        String sessionId = userMap.get(user);
        WebSocketSession session = sessionMap.get(sessionId);
        try {
            session.sendMessage(new TextMessage(message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sends(String user, String message){
        WebSocketSession userSession = null;
        int type = 2;
        if (!StringUtils.equals("System", user)){
            String sessionId = userMap.get(user);
            userSession = sessionMap.get(sessionId);
        }
        for (String key : sessionMap.keySet()){
            WebSocketSession session = sessionMap.get(key);
            if (session == userSession){
                //自己的消息
                type = 1;
            }else if (StringUtils.equals("System", user)){
                type = 0;
            }else {
                type = 2;
            }
            try {
                session.sendMessage(new TextMessage(warpMessage(type, user, message)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String warpMessage(int type, String user, String message){

        JSONObject msg = new JSONObject();
        msg.put("type", type);
        msg.put("user", user);
        if (StringUtils.equals(user, "Sunnly")){
            msg.put("avatar", "dist/images/2.png");
        }else if (StringUtils.equals(user, "Fangr2")){
            msg.put("avatar", "dist/images/1.jpg");
        }else {
            msg.put("avatar", "dist/images/3.jpg");
        }

        msg.put("content", message);
        msg.put("sendtime", df.format(new Date()));
        return msg.toJSONString();
    }

}
