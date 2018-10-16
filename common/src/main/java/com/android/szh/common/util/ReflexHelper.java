package com.android.szh.common.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author sunzhonghao
 * @date 2018/5/17
 * desc: 反射辅助类
 */
public class ReflexHelper {

    public static <T> T getTypeInstance(Object object, int index) {
        return getTypeInstance(object.getClass(), index);
    }

    public static <T> T getTypeInstance(Class<?> clazz, int index) {
        try {
            Type genericSuperclass = clazz.getGenericSuperclass();
            if (genericSuperclass instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                Type actualTypeArgument = actualTypeArguments[index];
                if (actualTypeArgument instanceof Class) {
                    return ((Class<T>) actualTypeArgument).newInstance();
                }
            }
        } catch (InstantiationException | IllegalAccessException | ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }
}
