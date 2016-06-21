package com.hexin.Netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2016/1/4.
 */
public class FileServerHandler extends SimpleChannelInboundHandler {
//    private int fileCount = 0;
//    private List<FileObject> fileObjects = new ArrayList<>();
//    private int currentFileCount = 0;
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.err.println("FileServerHandler occurred error!");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        /*if (msg != null && msg instanceof TransFileInfo.FileInfo) {
            TransFileInfo.FileInfo fileInfo = (TransFileInfo.FileInfo) msg;
            fileCount = fileInfo.getFileCount();
            for (TransFileInfo.FileInfo.FileCell cell : fileInfo.getCellList()) {
                FileObject fo = new FileObject();
                fo.setName(cell.getName());
                fo.setLength(cell.getLength());
                fileObjects.add(fo);
            }
            ctx.writeAndFlush("recieve start" + "\n");
        } else {
            if (currentFileCount < fileCount) {
                FileObject fileObject = fileObjects.get(currentFileCount);
                currentFileCount++;
                File upFile = new File("E:\\down" + fileObject.getName());
                FileOutputStream fos = new FileOutputStream(upFile);
                HttpContent chunk = (HttpContent) msg;
                byte[] fileByte = chunk.content().array();
                fos.write(fileByte);
                fos.close();
            }
        }*/
        File upFile = new File("E:\\down" + "\\first.rar");
        FileOutputStream fos = new FileOutputStream(upFile);
        byte[] fileInByte = (byte[]) msg;
        fos.write(fileInByte);
        fos.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }

    private class FileObject {
        private String name;
        private long length;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getLength() {
            return length;
        }

        public void setLength(long length) {
            this.length = length;
        }
    }
}
