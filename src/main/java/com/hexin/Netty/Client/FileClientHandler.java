package com.hexin.Netty.Client;

import com.hexin.Dto.Proto.TestProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public class FileClientHandler  extends SimpleChannelInboundHandler<String>{

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        System.out.println("client stop!");
        ctx.channel().close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*String path = "C:\\Users\\Administrator\\Desktop\\doc";
        String name = "document";
        int nameLg = name.getBytes().length;
        System.out.println("nameLg: " + nameLg);
        int pathLg = path.getBytes().length;
        System.out.println("pathLg: " + pathLg);
        ctx.write(Unpooled.wrappedBuffer(HXBytesConvers.int2byte(nameLg)));
        ctx.write(Unpooled.wrappedBuffer(HXBytesConvers.int2byte(pathLg)));
        ctx.write(Unpooled.wrappedBuffer(name.getBytes("UTF-8")));
        ctx.write(Unpooled.wrappedBuffer(path.getBytes("UTF-8")));
        ctx.flush();*/

        // 通讯录
        TestProto.AddressBook.Builder bookBuilder = TestProto.AddressBook.newBuilder();
        List<TestProto.Person> persons = new ArrayList<TestProto.Person>();
        for(int i=0;i<5;i++) {
            // 联系人
            TestProto.Person.Builder personBuilder = TestProto.Person.newBuilder();
            // 名字
            personBuilder.setName("xuj" + i);
            // id
            personBuilder.setId(i);
            // Email
            if (i % 2 == 0) {
                personBuilder.setEmail("xujin" + i + "@myhexin.com");
            }
            for (int j=0;j<2;j++) {
                // 电话
                TestProto.Person.PhoneNumber.Builder phoneBuilder = TestProto.Person.PhoneNumber.newBuilder();
                // 号码
                phoneBuilder.setNumber(String.valueOf(j));
                // 类型
                phoneBuilder.setType(TestProto.Person.PhoneType.WORK);
                TestProto.Person.PhoneNumber phoneNumber = phoneBuilder.build();
                personBuilder.addPhone(phoneNumber);
            }
            TestProto.Person person = personBuilder.build();
            persons.add(person);
        }
        bookBuilder.addAllPerson(persons);
        TestProto.AddressBook book = bookBuilder.build();
//        byte[] bookbuf = book.toByteArray();
//        ByteBuf bf = Unpooled.wrappedBuffer(bookbuf);
        ctx.writeAndFlush(book);
    }
}
