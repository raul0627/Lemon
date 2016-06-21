package com.hexin.Netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by Administrator on 2015/12/30.
 */
public class FileServerInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
//        pipeline.addLast(new StringEncoder());
//        pipeline.addLast(new CustomDecoder());
//        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
//        pipeline.addLast(new CustomEncoder());
//        pipeline.addLast(new LineBasedFrameDecoder(8192));
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
//        pipeline.addLast(new ProtobufDecoder(TransFileInfo.FileInfo.getDefaultInstance()));
//        pipeline.addLast(new LineBasedFrameDecoder(8912));
        pipeline.addLast(new FileDecoder());
        pipeline.addLast(new FileServerHandler());
    }
}
