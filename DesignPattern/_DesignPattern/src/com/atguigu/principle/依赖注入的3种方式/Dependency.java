/**
 * @author Jim
 * @Description
 * @createTime 2022年08月12日
 */
public class Dependency {


}

/**
 * 方式一：通过接口传递实现依赖
 */
/*
interface IOpenAndClose{
    public void open(ITV tv);
}

interface ITV{
    public void play();
}
class OpenAndClose implements IOpenAndClose{

    @Override
    public void open(ITV tv) {
        tv.play();
    }
}
*/
/**
 * 方式二，通过构造器方法传递依赖
 */
/*
interface IOpenAndClose{
    public void open();
}

interface ITV{
    public void play();
}

class OpenAndClose implements IOpenAndClose{
    public ITV tv;

    public OpenAndClose(ITV tv){ // 构造器
        this.tv = tv;
    }
    @Override
    public void open() {
        this.tv.play();
    }
}
*/

/**
 * 方式三：通过setter方法传递
 */

interface IOpenAndClose{
    public void open();

    public void setTV(ITV tv);
}

interface ITV{
    public void play();
}

class OpenAndClose implements IOpenAndClose{

    private ITV tv;
    @Override
    public void open() {
        this.tv.play();
    }

    @Override
    public void setTV(ITV tv) {
        this.tv = tv;
    }
}