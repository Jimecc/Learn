# Java 泛型

当不确定数据类型的时候，可以使用泛型

> 常用例子
> 
> `ArrayList<String>`
> 
> `Collection<String>`

集合不使用泛型，默认的类型就是`Object` 类型，可以存储任意类型的数据

弊端：不安全，会引发异常

使用泛型的优点：

1. 避免了类型转换的麻烦，存储是什么类型，取出就是什么类型。
2. 把运行期异常（代码运行后会抛出的异常）提升到了编译期（写代码的时候会报错）

弊端：
1. 泛型是什么类型，就只能存储什么类型的数据


