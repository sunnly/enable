package wang.sunnly.enable.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import wang.sunnly.enable.chat.handler.WebSocketHandler;
import wang.sunnly.enable.chat.interceptor.WebSocketInterceptor;

/**
 * WebSocketAutoConfig
 *
 * @author Sunnly
 * @create 2019/8/11 0011 22:12
 */
@Configuration
@EnableWebSocket
public class WebSocketAutoConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // webSocket通道
        // 指定处理器和路径
        registry.addHandler(new WebSocketHandler(), "/websocket")
                // 指定自定义拦截器
                .addInterceptors(new WebSocketInterceptor())
                // 允许跨域
                .setAllowedOrigins("*");
        // sockJs通道
        registry.addHandler(new WebSocketHandler(), "/sock-js")
                .addInterceptors(new WebSocketInterceptor())
                .setAllowedOrigins("*")
                // 开启sockJs支持
                .withSockJS();
    }
}
