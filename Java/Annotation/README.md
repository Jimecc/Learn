# 注解

@since 1.5
1. 编写文档：通过代码里标识的元数据生成文档【生成文档doc文档】
2. 代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
3. 自编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查 【override】

# JDK 内置注解
> @Override  : 用来检测被该注解标注的方法是否继承自父接口
> @Deprecated：将该注解标注的内容已过时
> @SuppressWarnings("all") : 压制警告


# 自定义注解

## 自定义格式

1. 元注解
2. 接口属性

```java
@元注解
public @interface Name{
    //属性列表
}
```
比如：
```java
public @interface MyAnno {

}
```

其本质是继承了`java.lang.annotation.Annotation`的一个接口

```java
public interface Annotation.MyAnno extends java.lang.annotation.Annotation 
```

## 属性定义
属性就是接口中的方法

### 属性返回值类型：

- 基本数据类型
- String
- 枚举
- 注解
- （void等直接报错）

### 定义了属性之后，使用的时候要给属性赋值：

- 多个属性用逗号分隔
- 可以在属性后面加`default + 值`，那么使用的时候可以不赋值
- 如果仅有一个属性要赋值，且这个属性名字叫`value`，那么这个属性的`value=`可以省略不写。
- 数组进行赋值要使用大括号`{}`进行包裹，如果大括号中只有一个值的话，那么可以省略`{}`

```java
@MyAnno(1) // 有且仅有一个value属性
@MyAnno(value=1,str="123",per=Person.p1,anno=@MyAnno2,strArr="abc") // 集合中仅有一个元素
@MyAnno(value=1,str="123",per=Person.p1,anno=@MyAnno2,strArr={"abc","123"}) // 集合中有多个元素
public class Demo2 {

}
```

```java
public @interface MyAnno {

    int age() default 2; // 有默认值，所以不一定非要赋值

    int value(); // 基本数据类型
    String str(); // String类型
    Person per(); // 枚举类型
    MyAnno2 anno(); // 注解类型
    String[] strArr(); // 集合类型
}
```


## 元注解
> @Target：描述注解能够作用的位置
> 
> ElementType的取值：
> > TYPE ：作用于类上
> > MMETHOD : 作用于方法上
> > FIELD : 作用于成员变量上       
>   
> @Retention: 描述注解被保留的阶段
> RetentionPolicy取值：
> > SOURCE
> > CLASS : 当前被描述的注解会被保留到CLASS字节码文件中
> > RUNTIME : 当前被描述的注解会被保留到CLASS字节码文件中，并被JVM读取
> 
> @Documented : 将来这个注解描述的信息会被抽取到JavaDoc文档中
> 
> @Inherited : 该注解是否会被子类继承（当该注解描述的类被继承之后，子类会同时继承该类的注解）
> 
