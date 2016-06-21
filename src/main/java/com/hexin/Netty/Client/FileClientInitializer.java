package com.hexin.Netty.Client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * Created by Administrator on 2016/1/6.
 */
public class FileClientInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        /*channelPipeline.addLast(new LineBasedFrameDecoder(8192));
        channelPipeline.addLast(new StringDecoder());
        channelPipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        channelPipeline.addLast(new ProtobufEncoder());*/
//        channelPipeline.addLast(new ChunkedWriteHandler());
        channelPipeline.addLast(new FileClientHandler());
    }
}
