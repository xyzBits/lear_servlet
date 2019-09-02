package com.learn.spring.ioc.impl;

import com.learn.spring.ioc.bean.AirPlane;

public class AirPlaneInstanceFactory {
    public AirPlane getAirPlane(String jzName) {
        System.out.println("实例工厂正在造飞机。。。。。。");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("太行");
        airPlane.setJsName("lfy");
        airPlane.setJzName(jzName);
        airPlane.setPersonNum(3000);
        airPlane.setYc("198.9m");
        return airPlane;
    }
}
