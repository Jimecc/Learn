package improve; /**
 * @author Jim
 * @Description
 * @createTime 2022年08月12日
 */


public class DependencyInversion {

    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new WeChat());
    }
}


/**
 * 定义一个接口 IReceiver
 */
interface IReceiver{
    public String getInfo();
}

/**
 * 消息类型 Email 与 WeChat
 */
class Email implements IReceiver{
    @Override
    public String getInfo(){
        return "电子邮件信息：hello worldddd";
    }
}

class WeChat implements IReceiver{

    @Override
    public String getInfo() {
        return "From wechat:Hello";
    }
}

// 完成Person的消息接受功能


class Person{
    public void receive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}