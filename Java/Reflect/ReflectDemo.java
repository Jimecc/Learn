package Reflect;

import java.lang.reflect.Field;

/**
 * Class.getFields(); // 获取所有public修饰的成员变量
 * Class.getDeclaredFields() // 暴力获取所有对象（不管修饰符）
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception{
        Class personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }


        Field f = personClass.getField("");
        Field[] fs = personClass.getDeclaredFields();

        Person p = new Person();

        Object value = f.get(p);

        System.out.println(value);
        f.set(p,18);
        System.out.println(p);


        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true); // 暴力反射
    }
}
