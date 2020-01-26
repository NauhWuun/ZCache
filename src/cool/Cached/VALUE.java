package cool.Cached;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cool.ByteIO;
import cool.HashAlgorithm;
import cool.Unchecked;

public class VALUE {
    byte[] param;

    public VALUE() {
        this("0");
    }

    public VALUE(final String params) {
        param = ByteIO.convertToByteArray(params);
    }

    @Unchecked
    @Deprecated
    public static <T> T getMultiTypeHandler(T obj, final String params) throws NoSuchMethodException,
            SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method InstanceMethod = SupportClass.SupportList.get(obj).getClass().getDeclaredMethod("call", String.class);
        InstanceMethod.setAccessible(true);
        return (T) InstanceMethod.invoke(null, (Object) "123234");
    }

    public final String getValue() {
        return ByteIO.convertToString(param);
    }

    public final long hashKey(final long key) {
        return HashAlgorithm.FNV1A_64_HASH(String.valueOf(key));
    }
}
