package com.hexin.Netty;

import com.hexin.Dto.Proto.TestProto;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;

/**
 * Created by Administrator on 2015/12/30.
 */
public class FileServerInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast(new CustomDecoder());
//        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
//        pipeline.addLast(new CustomEncoder());
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(TestProto.AddressBook.getDefaultInstance()));
        pipeline.addLast(new FileServerHandler());
//        pipeline.addLast(new StringEncoder());
    }
}
