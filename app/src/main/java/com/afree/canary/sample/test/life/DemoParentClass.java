package com.afree.canary.sample.test.life;

/**
 * Created by afree on 10/02/2018.
 * yanwenyi@meituan.com
 */

public class DemoParentClass {
    public static StaticFiledClass1 f1 = new StaticFiledClass1();
    static{
        System.out.println("DemoParentClass:运行静态代码");
    }
    public static StaticFiledClass2 f2;

}
