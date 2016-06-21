package com.hexin.Netty;

import com.hexin.Dto.TransFileHead;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;


/**
 * Created by Administrator on 2015/12/30.
 */

public class CustomDecoder extends ReplayingDecoder<CustomDecoder.CustomFlag>{

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        TransFileHead fileHead = new TransFileHead();
        switch (state()) {
            case HEAD:
                int nameLength = in.readInt();
                fileHead.setFileNameLength(nameLength);
                int pathLength = in.readInt();
                fileHead.setFilePathLength(pathLength);
                checkpoint(CustomFlag.CONTENT);
            case CONTENT:
                // fileName
                byte[] nameByte = new byte[fileHead.getFileNameLength()];
                ByteBuf tempBuf = in.readBytes(nameByte);
                fileHead.setFileName(new String(nameByte, "UTF-8"));
                // filePath
                byte[] pathByte = new byte[fileHead.getFilePathLength()];
                tempBuf = in.readBytes(pathByte);
                fileHead.setFilePath(new String(pathByte, "UTF-8"));
                checkpoint(CustomFlag.HEAD);
                out.add(fileHead);
                break;
            default:
                System.err.println("Shouldn't reach here");
        }
    }

    public CustomDecoder() {
        super(CustomFlag.HEAD);
    }

    public enum CustomFlag {
        HEAD,
        CONTENT
    }
}
