package com.hexin.Nio;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HaloServer implements Runnable{
    private static Logger log = Logger.getLogger(HaloServer.class);
    private static final int port = 7788;
    private EventLoopGroup boosGroup = new NioEventLoopGroup();
    private EventLoopGroup workerGroup = new NioEventLoopGroup();

    @Override
    public void run() {
        try {
            log.info("halo server run");
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.childHandler(new HaloServerInitializer());

            // 服务器绑定端口监听
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            // 监听服务器关闭监听
            channelFuture.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }

    public void stop() {
        if (workerGroup != null) {
            workerGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }
}
