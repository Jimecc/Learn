/**
 * @author Jim
 * @Description 单一职责模块3
 * 1。没有对原来的类做大的修改，只是增加了方法
 * 2。违反了单一职责原则，但是方法级别上符合单一职责原则
 * @createTime 2022年08月12日
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        AVehicle aVehicle = new AVehicle();
        aVehicle.roadRun("汽车");
        aVehicle.waterRun("轮船");
        aVehicle.airRun("飞机");
    }
}


class AVehicle{
    public void roadRun(String vehicle){
        System.out.println(vehicle+" 在路上跑的飞快");
    }
    public void waterRun(String vehicle){
        System.out.println(vehicle+" 在水里游的飞快");
    }
    public void airRun(String vehicle){
        System.out.println(vehicle+" 在天上飞的飞快");
    }
}