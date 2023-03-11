package improve;

/**
 * @author Jim
 * @Description OpenClosedPrinciple 开闭原则
 * @createTime 2022年08月12日
 */

/**
 * 改进方法 将Shape 做成一个抽象类，然后让三种形状去继承这个抽象类
 */
public class Ocp {

    public static void main(String[] args) {
        GraphicEditer g = new GraphicEditer();
        g.drawShape(new Rectangle() );
        g.drawShape(new Circle() );
    }
}

class GraphicEditer{
    public void drawShape(Shape s){
        s.draw();
    }

}

abstract class Shape{

    public abstract void draw(); // 抽象方法
}

class Rectangle extends Shape{

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape{

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

