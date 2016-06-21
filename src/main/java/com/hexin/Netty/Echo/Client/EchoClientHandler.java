package com.hexin.Netty.Echo.Client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


public class EchoClientHandler extends ChannelInboundHandlerAdapter {

    private final String firstMessage = "test string------\n";

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ByteBuf bf = Unpooled.wrappedBuffer(firstMessage.getBytes());
        ctx.writeAndFlush(bf);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println(ctx.channel().remoteAddress() + "->Server :" + msg.toString() + "------client");
        ctx.channel().close();
//        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {         // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}
