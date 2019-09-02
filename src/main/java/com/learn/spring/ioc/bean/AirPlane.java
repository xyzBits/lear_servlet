package com.learn.spring.ioc.bean;

public class AirPlane {
    private String fdj;
    private String jsName;
    private String jzName;
    private int personNum;
    private String yc;

    public AirPlane() {
    }

    public String getFdj() {
        return fdj;
    }

    public void setFdj(String fdj) {
        this.fdj = fdj;
    }

    public String getJsName() {
        return jsName;
    }

    public void setJsName(String jsName) {
        this.jsName = jsName;
    }

    public String getJzName() {
        return jzName;
    }

    public void setJzName(String jzName) {
        this.jzName = jzName;
    }

    public int getPersonNum() {
        return personNum;
    }

    public void setPersonNum(int personNum) {
        this.personNum = personNum;
    }

    public String getYc() {
        return yc;
    }

    public void setYc(String yc) {
        this.yc = yc;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "fdj='" + fdj + '\'' +
                ", jsName='" + jsName + '\'' +
                ", jzName='" + jzName + '\'' +
                ", personNum=" + personNum +
                ", yc='" + yc + '\'' +
                '}';
    }
}
