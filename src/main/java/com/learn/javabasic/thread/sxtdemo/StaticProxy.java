package com.learn.javabasic.thread.sxtdemo;

import java.util.Map;

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();
        WeddingCompany weddingCompany = new WeddingCompany(you);
        weddingCompany.marry();
    }
}


interface Marry {
    void marry();
}

class You implements Marry {

    @Override
    public void marry() {
        System.out.println("你和嫦娥结婚");
    }
}

class WeddingCompany implements Marry {
    private Marry you;

    public WeddingCompany() {
    }

    public WeddingCompany(Marry you) {
        this.you = you;
    }

    @Override
    public void marry() {
      /*  before();
        you.marry();
        after();*/

      before();
      if (you != null) {
          you.marry();
      }
      after();
    }

    private void before() {
        System.out.println("布置猪窝。。。。。。");
    }

    private void after() {
        System.out.println("闹玉兔。。。。。。。。。。。");
    }
}