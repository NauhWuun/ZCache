package cool.Cached;

import cool.ByteIO;
import cool.HashAlgorithm;

public class VALUE 
{
    byte[] param;

    public VALUE() {
        this("\0");
    }

    public VALUE(final String params) {
        param = ByteIO.convertToByteArray(params);
    }

    public final <T> T getMultiTypeHandler(final String obj, final String params) {
        return (T) SupportClass.SupportList.get((obj).getClass().getSimpleName()).call(params);
    }

    public final String getValue() {
        return ByteIO.convertToString(param);
    }

    public final long hashKey(final long key) {
        return HashAlgorithm.FNV1A_64_HASH(String.valueOf(key));
    }
}
