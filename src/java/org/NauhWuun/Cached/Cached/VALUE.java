package org.NauhWuun.Cached.Cached;

import org.NauhWuun.Cached.Bytes;
import org.NauhWuun.Cached.HashAlgorithm;
import org.NauhWuun.Cached.Unchecked;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class VALUE
{
    byte[] param;

    public VALUE() {
        this("0");
    }

    public VALUE(final String params) {
        param = Bytes.convertToByteArray(params);
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
        return Bytes.ConvertBytesToString(param);
    }

    public final long hashKey(final long key) {
        return HashAlgorithm.FNV1A_64_HASH(String.valueOf(key));
    }
}