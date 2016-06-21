package com.hexin.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Created by Administrator on 2016/1/20.
 */
public class FileDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        int len = 31115680;
        if (in.readableBytes() < len) {
            return;
        }
        byte[] bytes = new byte[len];
        in.readBytes(bytes);
        out.add(bytes);
    }
}
