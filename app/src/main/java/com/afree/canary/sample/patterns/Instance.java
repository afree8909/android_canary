package com.afree.canary.sample.patterns;

/**
 * Created by afree on 03/02/2018.
 * yanwenyi@meituan.com
 */

public class Instance {
    private Instance() {
    }

    private static class Holder {
        // 类加载机制保证懒加载，static&final确保线程安全
        private static final Instance INSTANCE = new Instance();
    }

    public static Instance getInstance() {
        return Holder.INSTANCE;
    }

}
