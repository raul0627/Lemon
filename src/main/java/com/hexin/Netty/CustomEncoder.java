package com.hexin.Netty;

import com.hexin.Dto.TransFileHead;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by Administrator on 2016/1/15.
 */
public class CustomEncoder extends MessageToByteEncoder<TransFileHead> {
    @Override
    protected void encode(ChannelHandlerContext ctx, TransFileHead msg, ByteBuf out) throws Exception {
        String res = "name: " + msg.getFileName() + " path: " + msg.getFilePath();
        System.out.println(res);
        out.writeBytes(res.getBytes("UTF-8"));
    }
}
