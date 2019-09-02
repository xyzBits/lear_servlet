package com.learn.spring.ioc.impl;

import com.learn.spring.ioc.bean.AirPlane;

public class AirPlaneStaticFactory {
    public static AirPlane getAirPlane(String jzName) {
        System.out.println("静态工厂正在造飞机。。。。。。");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setJsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(400);
        airPlane.setYc("198.9m");
        return airPlane;
    }
}
