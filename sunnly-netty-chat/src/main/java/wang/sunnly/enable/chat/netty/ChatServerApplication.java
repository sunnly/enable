package wang.sunnly.enable.chat.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;


/**
 * ChatServerApplication
 *
 * @author Sunnly
 * @create 2019/8/11 0011 18:45
 */

@Component
@ChannelHandler.Sharable
public class ChatServerApplication {

    @Autowired
    @Qualifier("bootstrap")
    private ServerBootstrap serverBootstrap;

    private Channel channel;

    public void start() throws InterruptedException {
        System.out.println("netty启动");
        channel = serverBootstrap.bind(8888).sync().channel().closeFuture().sync().channel();
    }

    @PreDestroy
    public void close(){
        channel.close();
        channel.parent().close();
    }
}
