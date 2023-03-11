package Annotation;

import java.lang.annotation.*;

/**
 * @author Jim
 * @Description 元注解
 * @createTime 2022年11月24日
 */

@Inherited
@Documented
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD}) // 一个可以用在 类、成员方法、成员变量 上的注解
@Retention(RetentionPolicy.RUNTIME) // 描述注解保留
public @interface MyAnno3 {
}
