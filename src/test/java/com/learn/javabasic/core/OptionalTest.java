package com.learn.javabasic.core;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void test001() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        girl = null;
        optionalGirl = Optional.of(girl); //java.lang.NullPointerException
    }

    @Test
    public void test002() {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        //girl = null;
        optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        Girl girl1 = optionalGirl.orElse(new Girl("hhhhh"));
        System.out.println(girl1);

    }

    private String getGirlName1(Boy boy) {
        return boy.getGirl().getName();
    }

    private String getGirlName2(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    private String getGirlName3(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("ddddddddddd")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("shabi"));
        return girl1.getName();
    }

    @Test
    public void test003() {
        System.out.println(getGirlName3(null));
        System.out.println(getGirlName3(new Boy(null)));
        System.out.println(getGirlName3(new Boy(new Girl("ni hao"))));
    }

}

class Girl {
    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Boy {
    private Girl girl;

    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
