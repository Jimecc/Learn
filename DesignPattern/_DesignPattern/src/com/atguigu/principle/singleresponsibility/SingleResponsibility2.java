/**
 * @author Jim
 * @Description 方案二
 * 遵守了单一职责原则，但是改动很大
 * @createTime 2022年08月12日
 */
public class SingleResponsibility2 {

    public static void main(String[] args) {

        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("火车");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");
    }
}

class RoadVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+" 在路上跑的飞快");
    }
}
class AirVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+" 在天上飞的飞快");
    }
}
class WaterVehicle{
    public void run(String vehicle){
        System.out.println(vehicle+" 在水里游的飞快");
    }
}