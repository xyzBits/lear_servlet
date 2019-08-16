package com.java8.chapter16;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * lanbda表达式使用举例
 * 1、举例 (o1, o2) -> Integer.compare(o1, o2);
 * 2、格式：
 * -> lambda操作符， 或者 箭头操作符
 * -> 左边 lambda 形参列表 其实就是接口中的抽象方法的形参列表
 * -> 右边 lambda体 其实就是重写抽象方法的方法体
 * 3、lambda表达式的使用 共6种格式
 * <p>
 *
 * @see FunctionalInterface
 * 4、lambda表达式的本质：作为操作的一个实例，接口的具体实现
 * <p>
 * <p>
 * 5 总结 -> 左边，lambda参数列表的类型可以省略，只有一个参数，括号省，无参数或者两个及以上参数，不可省
 * -> 右边 lambda体用大括号包裹，只有一条执行语句，可省略{} return，要省就一起省
 */
public class LambdaDemoTest {
    // 语法格式1 无参，无值
    @Test
    public void test001() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱北京开安门");
            }
        };
        r1.run();


        System.out.println("************************");

        // = 号右边整个是lambda表达式
        Runnable r2 = () -> {
            System.out.println("我爱北京开安门");
        };
        r2.run();
    }

    // 语法格式二 lambda要一个参数，但是没有返回值
    @Test
    public void test02() {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer.accept("lambda要一个参数，但是没有返回值");

        System.out.println("===============");

        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("lambda要一个参数，但是没有返回值========");
    }

    // 语法格式三 数据类型可以省略，因为可由编译器推断得出，称为类型推断
    @Test
    public void test03() {


        Consumer<String> consumer1 = (String s) -> {
            System.out.println(s);
        };
        consumer1.accept("语法格式三 数据类型可以省略，因为可由编译器推断得出，称为类型推断========");


        Consumer<String> consumer2 = (s) -> {
            System.out.println(s);
        };
        consumer2.accept("语法格式三 数据类型可以省略，因为可由编译器推断得出，称为类型推断========类型推断");

        List<String> list = new ArrayList<>(); //<>后面的<>中的类型就是推断出来 的
        String[] arr = new String[]{"hello", "world"};
        String[] arr1 = {"hello", "world"}; //你只能new String，也不能new别的
    }

    // 语法格式四：lambda表达式只有一个参数时，参数的小括号可以省略
    @Test
    public void test04() {
        Consumer<String> consumer1 = (s) -> {
            System.out.println(s);
        };
        consumer1.accept("语法格式四：lambda表达式只有一个参数时，参数的小括号可以省略========类型推断");


        System.out.println("===============");

        Consumer<String> consumer2 = s -> {
            System.out.println(s);
        };
        consumer2.accept("语法格式四：lambda表达式只有一个参数时，参数的小括号可以省略========省略参数");
    }

    // 语法格式五 lambda 需要两个以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test05() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(21, 33);
        System.out.println(compare1);

        System.out.println("___________________");

        Comparator<Integer> comparator = (o1, o2) -> {
            System.out.println("o1 = " + o1);
            System.out.println("o2 = " + o2);
            return o1.compareTo(o2);
        };
        System.out.println(comparator.compare(1, 2));
    }

    // 语法格式六 当lambda体只有一条执行语句时，return语句与大括号若有，都可以省略

    @Test
    public void test06() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        int compare1 = com1.compare(21, 33);
        System.out.println(compare1);
        System.out.println("===================");

        // return语句与大括号若有，都可以省略
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32, 22);
        System.out.println(compare2);

        System.out.println("----------------------");

        Comparator<Integer> com3 = Integer::compare;
        // 方法引用
        int compare3 = com3.compare(3, 4);
        System.out.println(compare3);
    }

    @Test
    public void test008() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
    }

}