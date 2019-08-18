package com.java8.chapter16;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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

    private void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test009() {
        happyTime(300, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {

            }
        });

        happyTime(400, (aDouble) -> {
            System.out.println("consumer " + aDouble);
        });
    }

    @Test
    public void test010() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStr = filterString(list, s -> s.contains("京"));
        System.out.println(filterStr);
    }

    private List<String> filterString(List<String> list, Predicate<String> pre) {
        List<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }

    @Test
    public void test011() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("beijing");
        System.out.println("=================");

        Consumer<String> con2 = System.out::println;
        con2.accept("shenzhen");
    }

    @Test
    public void test012() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world");
            }
        };
        runnable.run();


        Runnable runnable1 = () -> {
            System.out.println("hello lambda");
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("hello simple lambda");
    }

    @Test
    public void test013() {
        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        TreeSet<String> treeSet = new TreeSet<>((o1, o2) -> {
            return Integer.compare(o1.length(), o2.length());
        });

        TreeSet<String> treeSet1 = new TreeSet<>((o1, o2) -> Integer.compare(o1.length(), o2.length()));
        //TreeSet<String> treeSet2 = new TreeSet<>(Comparator::compareI)

        Runnable runnable = () -> {
            System.out.println("hello world");
        };

        Consumer<String> consumer = (String str) -> {
            System.out.println(str);
        };
        Consumer<String> consumer1 = (str) -> {
            System.out.println(str);
        };
        Consumer<String> consumer2 = str -> System.out.println(str);

        Comparator<Integer> comparator = (x, y) -> {
            System.out.println(x);
            return Integer.compare(x, y);
        };

        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);

        String newStr = toUpperString((str) -> str.toUpperCase(), "abc");
        String newStr1 = toUpperString(String::toUpperCase, "abc");

    }

    private String toUpperString(MyFun<String> mf, String str) {
        return mf.getValue(str);
    }

    @Test
    public void test014() {
        Consumer<String> consumer = x -> System.out.println(x);
        consumer = System.out::println;  //传递给lambda体的操作，已经在实现方法了
        consumer.accept("hello");

        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        comparator = Integer::compare;
        comparator.compare(1, 2);

        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);
        biPredicate = String::equals;
        biPredicate.test("hello", "wo ");

        Function<Integer, MyClass> fun = n -> new MyClass(n);
        fun = MyClass::new;
        Function<Integer, Integer[]> function = (n) -> new Integer[n];
        function = Integer[]::new;

        Consumer consumer1 = str -> System.out.println(str);
        consumer1.accept("hello");

        consumer1 = System.out::println;
        consumer1.accept("dfa");

        Employee emp = new Employee(1001,"Tom",23,5600);
        Supplier<String> supplier = () -> emp.getName();
        System.out.println(supplier.get());

        supplier = emp::getName;
        supplier.get();

        Comparator<Integer> comparator1 = (o1, o2) -> Integer.compare(o1, o2);
        comparator1.compare(1, 2);
        comparator1 = Integer::compare;
        comparator1.compare(4, 5);




    }

    private void test() {
        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        function = (aDouble) -> Math.round(aDouble);

        function = Math::round;
        function.apply(3.);

        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        comparator = String::compareTo;
        comparator.compare("hello", "haha");

        BiPredicate<String, String> predicate = (s1, s2) -> s1.equals(s2);
        predicate = String::equals;

    }

    @Test
    public void test015() throws IOException {
        Girl girl = new Girl();
        Optional<Girl> optionalGirl = Optional.of(girl);
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        file.createNewFile();
    }

    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        file.createNewFile();
        file.delete();
    }
}

class MyClass {
    private Integer n;

    public MyClass(Integer n) {
        this.n = n;
    }
}

@FunctionalInterface
interface MyNumber {
    double getValue();
}

@FunctionalInterface
interface MyFun<T> {
    T getValue(T t);

    default void print() {
    }
}