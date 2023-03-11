/**
 * @author Jim
 * @Description 单一职责原则1
 * 因为Vehicle 要执行天上、地上、水里的三种不同的方法
 * 所一他违背了单一职责原则
 * @createTime 2022年08月12日
 */
public class SingleResponsibility1 {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("轮船");
        vehicle.run("飞机");

    }
}

class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " 在路上跑的飞快");
    }
}
