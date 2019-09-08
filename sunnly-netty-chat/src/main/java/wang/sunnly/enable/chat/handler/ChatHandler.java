package wang.sunnly.enable.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

/**
 * ChatHandler
 *
 * @author Sunnly
 * @create 2019/8/11 0011 19:38
 */
@Component
@ChannelHandler.Sharable
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 广播
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        String content = msg.text();
        Channel iChannel = ctx.channel();

        for (Channel channel : channels) {
            if (channel != iChannel){
//                AttributeKey<Map<String ,String>> info = AttributeKey.newInstance("info");
//                ctx.channel().attr(info);
                channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress()+":"+content));
            }else {
                channel.writeAndFlush(new TextWebSocketFrame("我自己:"+content));
            }
        }
    }

    /**
     * 进入
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress()+"进入聊天室"));
        }
        channels.add(ctx.channel());
    }

    /**
     * 退出
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        channels.remove(ctx.channel());
        for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame(ctx.channel().remoteAddress()+"退出聊天室"));
        }
    }
}
