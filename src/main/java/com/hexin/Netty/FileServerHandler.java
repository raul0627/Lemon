package com.hexin.Netty;

import com.hexin.Dto.Proto.TestProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.List;

/**
 * Created by Administrator on 2016/1/4.
 */
public class FileServerHandler extends SimpleChannelInboundHandler<TestProto.AddressBook> {
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.err.println("FileServerHandler occurred error!");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    /*@Override
    protected void channelRead0(ChannelHandlerContext ctx, TransFileHead msg) throws Exception {
        *//*String res = "name: " + msg.getFileName() + " path: " + msg.getFilePath();
        System.out.println(res);
        ctx.writeAndFlush(Unpooled.wrappedBuffer(res.getBytes("UTF-8")));*//*
        ctx.write(msg);
//        ctx.fireChannelRead(msg);
    }*/

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("server active------");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TestProto.AddressBook msg) throws Exception {
        List<TestProto.Person> personList = msg.getPersonList();
        for (TestProto.Person personCell : personList) {
            String name = personCell.getName();
            System.out.println("name : " + name);
            int id = personCell.getId();
            System.out.println("id : " + id);
            if (personCell.getEmail() != null) {
                System.out.println("Email : " + personCell.getEmail());
            }
            if (personCell.getPhoneList() != null) {
                for (TestProto.Person.PhoneNumber number : personCell.getPhoneList()) {
                    String num = number.getNumber();
                    System.out.println("number : " + num);
                    String type = number.getType().name();
                    System.out.println("numberType : " + type);
                    int value = number.getType().getNumber();
                    System.out.println("value : " + value);
                }
            }
        }
    }
}
