package com.afree.canary.sample.test.life;

/**
 * Created by afree on 10/02/2018.
 * yanwenyi@meituan.com
 */

public class DemoClass extends DemoParentClass{

    public static final StaticFiledClass2 test = new StaticFiledClass2();
    static{
        System.out.println("DemoClass:运行静态代码");
    }

    public static StaticFiledClass2 f2 = new StaticFiledClass2();
}
