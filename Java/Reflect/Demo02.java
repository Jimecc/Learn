package Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Jim
 * @Description getDeclaredFields
 * @createTime 2022年11月24日
 */
public class Demo02 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class personClass = Person.class;

        Method[] methods1 = personClass.getMethods(); // 普通获取
        Method[] methods2 = personClass.getDeclaredMethods();  // 暴力获取
        for (Method method : methods2) {
            System.out.println(method.getName());
        }

        Method method1 = personClass.getMethod("eat"); // 获取无参数方法
        Method method2 = personClass.getMethod("eat",String.class); // 获取有参数有参数
        Person p = new Person();
        method1.invoke(p); // 传递对象 + 参数列表
        method2.invoke(p,"饭");

        Method eat3 = personClass.getMethod("eat2", String.class);
        String str = (String) eat3.invoke(p,"饭");
        System.out.println(str);

    }
}
