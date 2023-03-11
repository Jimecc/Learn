package Annotation;

/**
 * @author Jim
 * @Description
 * @createTime 2022年11月24日
 */


public @interface MyAnno {

    int age() default 2; // 有默认值，所以不一定非要赋值

    int value();
    String str();
    Person per();
    MyAnno2 anno();
    String[] strArr();
}
