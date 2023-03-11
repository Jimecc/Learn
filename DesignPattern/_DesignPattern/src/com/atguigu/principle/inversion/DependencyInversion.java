/**
 * @author Jim
 * @Description
 * @createTime 2022年08月12日
 */




/**
 * 优点：比较简单，容易想到
 * 缺点：如果要接收微信、短信则要增加新的类
 * 优化：引入一个新的接口IReceiver，表示接受者，这样与Person类发生依赖
 * 因为Email与微信都属于接收的范畴，他们各自实现IReceiver就可以
 */


public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email{
    public String getInfo(){
        return "电子邮件信息：hello world";
    }
}

// 完成Person的消息接受功能


class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}