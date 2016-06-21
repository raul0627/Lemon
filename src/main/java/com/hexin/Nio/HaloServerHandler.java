package com.hexin.Nio;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HaloServerHandler extends SimpleChannelInboundHandler<String>{

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");
        ctx.writeAndFlush("Welcome to " + InetAddress.getLocalHost().getHostName() + " service!\n");
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        // 收到消息直接打印输出
        System.out.println(channelHandlerContext.channel().remoteAddress() + " Say : " + s);
        // 返回客户端消息 - 我已经接收到了你的消息
        channelHandlerContext.writeAndFlush("Received your message !\n");
    }
}
