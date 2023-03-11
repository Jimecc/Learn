import java.awt.*;

/**
 * @author Jim
 * @Description OpenClosedPrinciple 开闭原则
 * @createTime 2022年08月12日
 */
public class Ocp {

    public static void main(String[] args) {
        GraphicEditer g = new GraphicEditer();
        g.deawShape(new Rectangle() );
        g.deawShape(new Circle() );
    }
}

class GraphicEditer{
    public void deawShape(Shape s){
        if(s.m_type == 1){
            drawRectangle(s);
        }
        else if(s.m_type == 2){
            drawCircle(s);
        }
    }

    public void drawRectangle(Shape r){
        System.out.println("矩形");
    }

    public void drawCircle(Shape r){
        System.out.println("圆形");
    }
}

class Shape{
    int m_type;
}

class Rectangle extends Shape{
    Rectangle(){
        super.m_type = 1;
    }
}

class Circle extends Shape{
    Circle(){
        super.m_type = 2;
    }
}

/**
 * 新增画三角形的一个类
 */

class Triangle extends Shape{
    Triangle(){
        super.m_type = 3;
    }
}

/**
 * 改进方法 将Shape 做成一个抽象类，然后让三种形状去继承这个抽象类
 */