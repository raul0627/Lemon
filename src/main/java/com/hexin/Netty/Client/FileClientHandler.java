package com.hexin.Netty.Client;

import com.hexin.Dto.Proto.TransFileInfo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public class FileClientHandler  extends SimpleChannelInboundHandler<String>{
    private String path = "D:\\file\\1.0";
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
       /* File filePath = new File(path);
        if (msg.equals("recieve start")) {
            for (File file : filePath.listFiles()) {
                RandomAccessFile rf = new RandomAccessFile(file, "r");
                ctx.write(new DefaultFileRegion(rf.getChannel(), 0, rf.length()));
                ctx.write("\n");
            }
            ctx.flush();
        }
        if (msg.equals("recieve all")) {
            ctx.channel().close();
        }*/
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        createFiles(ctx);
        File filePath = new File(path);
        if (filePath.exists() && filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            RandomAccessFile rf = new RandomAccessFile(files[0], "r");
            String len = String.valueOf(rf.length());
            byte[] rfByte = new byte[Integer.valueOf(len)];
            System.out.println(len);
            rf.read(rfByte, 0, Integer.valueOf(len));
            ctx.write(Unpooled.wrappedBuffer(rfByte));
            ctx.flush();
//            ctx.write("\n");
        }
    }

    private void createFiles(ChannelHandlerContext ctx) {
        File filePath = new File(path);
        if (filePath.exists() && filePath.isDirectory()) {
            File[] files = filePath.listFiles();
            TransFileInfo.FileInfo.Builder fileInfoBuilder = TransFileInfo.FileInfo.newBuilder();
            fileInfoBuilder.setFileCount(files.length);
            List<TransFileInfo.FileInfo.FileCell> cells = new ArrayList<>();
            for (File cell : files) {
                TransFileInfo.FileInfo.FileCell.Builder cellBuilder = TransFileInfo.FileInfo.FileCell.newBuilder();
                cellBuilder.setName(cell.getName());
                cellBuilder.setLength(cell.length());
                TransFileInfo.FileInfo.FileCell fileCell = cellBuilder.build();
                cells.add(fileCell);
            }
            fileInfoBuilder.addAllCell(cells);
            TransFileInfo.FileInfo fileInfo = fileInfoBuilder.build();
            ctx.writeAndFlush(fileInfo);
        }
    }
}
