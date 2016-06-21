package com.hexin.Util;

import java.nio.ByteBuffer;

/**
 * Created by Administrator on 2015/12/30.
 */
public class HXBytesConvers {
    /**
     * 读取两个输入字节并返回一个 short 值。设 a 为第一个读取字节，b 为第二个读取字节。返回的值是： (short)(a + (b << 8))
     * @return 读取的 16 位值
     */
    public static final short readShort(byte[] buff) {
        // 解析出short值
        int b1 = buff[0] & 0xff;
        int b2 = buff[1] & 0xff;
        return (short) (b1 + (b2 << 8));
    }

    /**
     * 读取四个输入字节并返回一个 int 值
     * @return 读取的 int 值
     */
    public static final int readInt(byte[] buff) {
        // 解析出int值
        int b1 = buff[0] & 0xff;
        int b2 = buff[1] & 0xff;
        int b3 = buff[2] & 0xff;
        int b4 = buff[3] & 0xff;
        int nResult = b4;
        nResult = (nResult << 8) + b3;
        nResult = (nResult << 8) + b2;
        nResult = (nResult << 8) + b1;
        return nResult;
    }

    /**
     * 读取两个输入字节，并返回 0 到 65535 范围内的一个 int 值
     * @return 读取的无符号 16 位值
     */
    public static final int readUnsignedShort(byte[] buff) {
        return (buff[0] + (buff[1] << 8));
    }

    /**
     * 读取四个输入字节并返回一个 无符号int 值
     * @return 读取的 无符号int 值(是个long值)
     */
    public static final long readUnsignedInt(byte[] buff) {
        // 解析出int值
        int b1 = buff[0] & 0xff;
        int b2 = buff[1] & 0xff;
        int b3 = buff[2] & 0xff;
        int b4 = buff[3] & 0xff;
        long nResult = b4;
        nResult = (nResult << 8) + b3;
        nResult = (nResult << 8) + b2;
        nResult = (nResult << 8) + b1;
        return nResult;
    }

    /**
     * Writes a 32-bit float to the target stream. The resulting output is the four bytes resulting from calling
     * Float.floatToIntBits().
     * @param val the float to write to the target stream.
     * @see HXDataInputStream#readFloat()
     */
    public static final byte[] writeFloat(float val) {
        return writeInt(Float.floatToIntBits(val));
    }

    /**
     * Writes a 32-bit int to the target stream. The resulting output is the four bytes, highest order first, of
     * {@code val}.
     * @param val the int to write to the target stream.
     * @see HXDataInputStream#readInt()
     */
    public static final byte[] writeInt(int val){
        byte[] array = new byte[4];
        int index = 0;
        array[index  ] = (byte) (val >>> 0);
        array[index+1] = (byte) (val >>> 8);
        array[index+2] = (byte) (val >>> 16);
        array[index+3] = (byte) (val >>> 24);
        return array;
    }

    public static final byte[] writeLong(long val){
        ByteBuffer bf = ByteBuffer.allocate(8);
        bf.put(writeInt((int) val));
        bf.put(writeInt((int) (val >> 32)));
        return bf.array();
    }

    /**
     * Writes the specified 16-bit short to the target stream. Only the lower two bytes of the integer {@code val} are
     * written, with the higher one written first.
     * @param val the short to write to the target stream.
     * @see HXDataInputStream#readShort()
     * @see HXDataInputStream#readUnsignedShort()
     */
    public static final byte[] writeShort(int val) {
        return writeChar(val);
    }

    /**
     * Writes a 16-bit character to the target stream. Only the two lower bytes of the integer {@code val} are written,
     * with the higher one written first. This corresponds to the Unicode value of {@code val}.
     *
     * @param val the character to write to the target stream
     * @see HXDataInputStream#readChar()
     */
    public static final byte[] writeChar(int val) {
        byte[] array = new byte[2];
        int index = 0;
        array[index  ] = (byte) (val >>> 0);
        array[index+1] = (byte) (val >>> 8);
        return array;
    }

    public static byte[] int2byte(int res) {
        byte[] targets = new byte[4];

        targets[3] = (byte) (res & 0xff);// 最低位
        targets[2] = (byte) ((res >> 8 & 0xff));// 次低位
        targets[1] = (byte) ((res >> 16 & 0xff));// 次高位
        targets[0] = (byte) (res >> 24 & 0xff);// 最高位,无符号右移。
        return targets;
    }
}
