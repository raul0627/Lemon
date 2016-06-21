package com.hexin.Nio;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by Administrator on 2015/12/8.
 */
public class HaloServerInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline channelPipeline = socketChannel.pipeline();
        channelPipeline.addLast("frame", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

//        channelPipeline.addLast(new ObjectDecoder(1024, ClassResolvers.weakCachingResolver(this.getClass().getClassLoader())));
        channelPipeline.addLast("decoder", new StringDecoder());
        channelPipeline.addLast("encoder", new StringEncoder());
//        channelPipeline.addLast("decoder", new StringDecoder());
        Object c = new Object();
        HttpContent s = (HttpContent) c;

        channelPipeline.addLast("handler", new HaloServerHandler());
    }
}
