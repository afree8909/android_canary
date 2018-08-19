package com.afree.canary.sample.patterns;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * Created by afree on 03/02/2018.
 * yanwenyi@meituan.com
 */

public class Singleton implements Serializable, Cloneable {

    private static volatile Singleton sSingleton; // volatile防止指令重排
    private static boolean sFlag = true;

    private Singleton() {
        if (sFlag) { // 防反射
            sFlag = false;
        } else {
            throw new RuntimeException("对象已经存在");
        }
    }

    public static Singleton getSingleton() {
        if (sSingleton == null) {
            synchronized (Singleton.class) {
                if (sSingleton == null) {
                    // 1.分配对象的内存空间，2.初始化对象，3.设置sSingleton指向刚分配的地址
                    sSingleton = new Singleton();
                }
            }
        }
        return sSingleton;
    }

    private Object readResolve() {
        return getSingleton(); // 防序列化
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return getSingleton(); // 防克隆
    }

    public static void main(String args[]) {

        try {
            Singleton singleton = Singleton.getSingleton();
            testCloneSingleton(singleton);
            testReflectSingleton(singleton);
            testSerializableSingleton(singleton);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testCloneSingleton(Singleton singleton) throws CloneNotSupportedException {

        boolean equals = singleton.equals(Singleton.getSingleton().clone());

        System.out.print(equals);
    }

    private static void testReflectSingleton(Singleton singleton) throws Exception {
        Constructor constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        constructor.newInstance();

        boolean equals = singleton.equals(constructor.newInstance());

        System.out.print(equals);

    }

    private static void testSerializableSingleton(Singleton singleton) throws Exception {
        String tempFile = "tempFile";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tempFile));
        oos.writeObject(getSingleton());
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File(tempFile)));

        boolean equals = singleton.equals(objectInputStream.readObject());

        System.out.print(equals);

    }


}
