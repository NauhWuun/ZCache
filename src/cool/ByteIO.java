package cool;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;

public final class ByteIO 
{
    public static final String DEFAULT_CHARSET_NAME = "utf-8";
    public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);

    public static byte readByte(byte[] buf, int pos) {
        checkBoundary(buf, pos, 1);
        return (byte) (buf[pos] & 0xff);
    }

    public static final byte[] getBytes(String k) {
        if (k == null || k.length() == 0) {
            throw new IllegalArgumentException("Key must not be blank");
        }

        try {
            return k.getBytes(DEFAULT_CHARSET_NAME);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static int compare(byte[] left, byte[] right) {
        for (int i = 0, j = 0; i < left.length && j < right.length; i++, j++) {
            int a = (left[i] & 0xff);
            int b = (right[j] & 0xff);

            if (a != b) {
                return a - b;
            }
        }

        return left.length - right.length;
    }

    public static byte readByte(ByteBuffer buf, int pos) {
        return (byte) (buf.get(pos) & 0xff);
    }

    public static short readShort(byte[] buf, int pos) {
        checkBoundary(buf, pos, 2);
        return (short) (((short) (buf[pos] & 0xff) << 8) | ((short) (buf[pos + 1] & 0xff)));
    }

    public static int readInt(byte[] buf, int pos) {
        checkBoundary(buf, pos, 4);
        return (((buf[pos++] & 0xff) << 24)
                | ((buf[pos++] & 0xff) << 16)
                | ((buf[pos++] & 0xff) << 8)
                | (buf[pos] & 0xff))
                ;
    }

    public static int readInt(ByteBuffer buf, int pos) {
        return (((buf.get(pos) & 0xff) << 24)
                | ((buf.get(pos + 1) & 0xff) << 16)
                | ((buf.get(pos + 2) & 0xff) << 8)
                | (buf.get(pos + 3) & 0xff))
                ;
    }

    public static long readLong(byte[] buf, int pos) {
        checkBoundary(buf, pos, 8);
        return (((long) (buf[pos++] & 0xff) << 56) | ((long) (buf[pos++] & 0xff) << 48)
                | ((long) (buf[pos++] & 0xff) << 40) | ((long) (buf[pos++] & 0xff) << 32)
                | ((long) (buf[pos++] & 0xff) << 24) | ((long) (buf[pos++] & 0xff) << 16)
                | ((long) (buf[pos++] & 0xff) << 8) | ((long) (buf[pos] & 0xff)))
                ;
    }

    public static void writeByte(byte[] buf, int pos, byte v) {
        checkBoundary(buf, pos, 1);
        buf[pos] = v;
    }

    public static void writeByte(ByteBuffer buf, int pos, byte v) {
        buf.put(pos, v);
    }

    public static void writeByte(OutputStream out, byte v) throws IOException {
        out.write(v);
    }

    public static void writeShort(byte[] buf, int pos, short v) {
        checkBoundary(buf, pos, 2);

        buf[pos++] = (byte) (0xff & (v >> 8));
        buf[pos] = (byte) (0xff & v);
    }

    public static void writeShort(OutputStream out, short v) throws IOException {
        out.write((byte) (0xff & (v >> 8)));
        out.write((byte) (0xff & v));
    }

    public static void writeInt(byte[] buf, int pos, int v) {
        checkBoundary(buf, pos, 4);
        buf[pos++] = (byte) (0xff & (v >> 24));
        buf[pos++] = (byte) (0xff & (v >> 16));
        buf[pos++] = (byte) (0xff & (v >> 8));
        buf[pos] = (byte) (0xff & v);
    }

    public static void writeInt(ByteBuffer buf, int pos, int v) {
        buf.put(pos++, (byte) (0xff & (v >> 24)));
        buf.put(pos++, (byte) (0xff & (v >> 16)));
        buf.put(pos++, (byte) (0xff & (v >> 8)));
        buf.put(pos, (byte) (0xff & v));
    }

    public static void writeInt(OutputStream out, int v) throws IOException {
        out.write((byte) (0xff & (v >> 24)));
        out.write((byte) (0xff & (v >> 16)));
        out.write((byte) (0xff & (v >> 8)));
        out.write((byte) (0xff & v));
    }

    public static void writeLong(byte[] buf, int pos, long v) {
        checkBoundary(buf, pos, 8);

        buf[pos++] = (byte) (0xff & (v >> 56));
        buf[pos++] = (byte) (0xff & (v >> 48));
        buf[pos++] = (byte) (0xff & (v >> 40));
        buf[pos++] = (byte) (0xff & (v >> 32));
        buf[pos++] = (byte) (0xff & (v >> 24));
        buf[pos++] = (byte) (0xff & (v >> 16));
        buf[pos++] = (byte) (0xff & (v >> 8));
        buf[pos] = (byte) (0xff & v);
    }

    public static void writeLong(OutputStream out, long v) throws IOException {
        out.write((byte) (0xff & (v >> 56)));
        out.write((byte) (0xff & (v >> 48)));
        out.write((byte) (0xff & (v >> 40)));
        out.write((byte) (0xff & (v >> 32)));
        out.write((byte) (0xff & (v >> 24)));
        out.write((byte) (0xff & (v >> 16)));
        out.write((byte) (0xff & (v >> 8)));
        out.write((byte) (0xff & v));
    }

    private static void checkBoundary(byte[] buf, int pos, int len) {
        if (pos + len > buf.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static byte[] convertBitToByteArray(BitSet bitSet) {
        byte[] bytes = new byte[bitSet.size() / 8];

        for (int i = 0; i < bitSet.size(); i++) {
            int index = i / 8;
            int offset = 7 - i % 8;

            bytes[index] |= (bitSet.get(i) ? 1 : 0) << offset;
        }

        return bytes;
    }

    public static BitSet convertByteArrayToBit(byte[] bytes) {
        BitSet bitSet = new BitSet(bytes.length * 8);
        int index = 0;

        for (int i = 0; i < bytes.length; i++) {
            for (int j = 7; j >= 0; j--) {
                bitSet.set(index++, (bytes[i] & (1 << j)) >> j == 1);
            }
        }

        return bitSet;
    }

    public static byte[] convertToByteArray(String s) {
        byte[] b = new byte[s.length()];

        for (int i = 0; i < s.length(); i++) {
            b[i] = (byte) s.charAt(i);
        }

        return b;
    }

    public static byte[] convertToByteArray(byte n) {
        n = (byte) (n ^ ((byte) 0x80));
        return new byte[]{n};
    }

    public static byte[] convertToByteArray(short n) {
        n = (short) (n ^ ((short) 0x8000));
        byte[] key = new byte[2];

        pack2(key, 0, n);
        return key;
    }

    public static byte[] convertToByteArray(int n) {
        n = (n ^ 0x80000000);
        byte[] key = new byte[4];

        pack4(key, 0, n);
        return key;
    }

    public static byte[] convertToByteArray(long n) {
        n = (n ^ 0x8000000000000000L);
        byte[] key = new byte[8];

        pack8(key, 0, n);
        return key;
    }

    public static String convertToString(byte[] buf) {
        String str = null;
        str = new String(buf, StandardCharsets.UTF_8);
        return str;
    }

    public static int convertToInt(byte[] buf) {
        int value = unpack4(buf, 0);
        value = (value ^ 0x80000000);
        return value;
    }

    public static long convertToLong(byte[] buf) {
        long value = ((long) unpack4(buf, 0) << 32) + (unpack4(buf, 4) & 0xFFFFFFFFL);
        value = (value ^ 0x8000000000000000L);
        return value;
    }

    static int unpack4(byte[] buf, int offset) {
        int value = (buf[offset] << 24)                     |
                    ((buf[offset + 1] << 16) & 0x00FF0000)  |
                    ((buf[offset + 2] << 8) & 0x0000FF00)   |
                    ((buf[offset + 3] << 0) & 0x000000FF)   ;
        return value;
    }

    static final void pack2(byte[] data, int offs, int val) {
        data[offs++] = (byte) (val >> 8);
        data[offs++] = (byte) val;
    }

    static final void pack4(byte[] data, int offs, int val) {
        data[offs++] = (byte) (val >> 24);
        data[offs++] = (byte) (val >> 16);
        data[offs++] = (byte) (val >> 8);
        data[offs++] = (byte) val;
    }

    static final void pack8(byte[] data, int offs, long val) {
        pack4(data, 0, (int) (val >> 32));
        pack4(data, 4, (int) val);
    }
}
