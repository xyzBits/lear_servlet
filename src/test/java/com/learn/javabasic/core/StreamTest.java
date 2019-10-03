package com.learn.javabasic.core;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    public void test001() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\aop1.xml")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        System.out.println(count);
    }

    @Test
    public void test002() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\aop1.xml")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);

        count = words.parallelStream().filter(w -> w.length() > 4).count();
        System.out.println(count);
    }

    @Test
    public void test003() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\aop1.xml")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        long count = 0;

        Stream<String> stream = words.stream();
        Stream<String> parallelStream = words.parallelStream();
    }

    @Test
    public void test004() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        Stream<int[]> arrStream = Stream.of(arr);
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
/*
        Stream.generate()
*/
    }

    @Test
    public void test005() {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("beijing ni hao a ");

        Consumer<String> consumer1 = System.out::println;
        consumer1.accept("dongguan nihao a ");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public void test006() {
        StreamTest test = new StreamTest();
        test.setName("li dongfang");
        Supplier<String> stringSupplier = () -> test.getName();
        System.out.println(stringSupplier.get());

        test.setName("hahaha");
        Supplier<String> supplier = test::getName;
        System.out.println(supplier.get());
    }

    @Test
    public void test007() {
        Comparator<Integer> com = (o1, o2) -> Integer.compare(o1, o2);
        System.out.println(com.compare(3, 2));

        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(33, 33));

        Comparator<Integer> comparator1 = Integer::compareTo;
        System.out.println(comparator1.compare(22, 33));
    }

    @Test
    public void test008() {
        Function<Double, Long> fun = d -> Math.round(d);
        System.out.println(fun.apply(4.5));

        Function<Double, Long> fun1 = Math::round;
        System.out.println(fun1.apply(1.2));
    }

    @Test
    public void test009() {
        Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
        System.out.println(comparator.compare("hello", "world"));

        Comparator<String> comparator1 = String::compareTo;
        System.out.println(comparator1.compare("world", "hello"));
    }

    @Test
    public void test010() {
        BiPredicate<String, String> pre1 = (s1, s2) -> s1.equals(s2);
        System.out.println(pre1.test("hello", "world"));

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("ni hao", "ni hao"));
    }

    @Test
    public void test011() {
        StreamTest test = new StreamTest();
        test.setName("li dongfang");

        Function<StreamTest, String> fun = e -> e.getName();
        System.out.println(fun.apply(test));

        Function<StreamTest, String> func = StreamTest::getName;
        System.out.println(func.apply(test));
    }

/*    public StreamTest(String name) {
        this.name = name;
        System.out.println("jjjjj0");
    }*/

    public StreamTest() {
    }

    @Test
    public void test012() {
        Supplier<StreamTest> supplier = () -> new StreamTest();
        System.out.println(supplier.get());

        Supplier<StreamTest> supplier1 = StreamTest::new;
        System.out.println(supplier1);
    }

    @Test
    public void test013() {
        class Hello {
            private String name;
            private Integer id;

            public Hello(String name, Integer id) {
                this.name = name;
                this.id = id;
            }

            public Hello(String name) {
                System.out.println("hhhhh");
                this.name = name;
            }

            @Override
            public String toString() {
                return "Hello{" +
                        "name='" + name + '\'' +
                        ", id=" + id +
                        '}';
            }
        }

        BiFunction<String, Integer, Hello> biFun = (name, id) -> new Hello(name, id);
        System.out.println(biFun.apply("dongfang", 123));
        biFun = Hello::new;
        System.out.println(biFun.apply("li dongfang", 456));


        Function<String, Hello> func = name -> new Hello(name);
        System.out.println(func.apply("lidong"));

        func = Hello::new;
        System.out.println(func.apply("dfada"));
    }

    @Test
    public void test014() {
        Function<Integer, String[]> func = len -> new String[len];
        System.out.println(Arrays.toString(func.apply(10)));

        func = String[]::new;
        System.out.println(Arrays.toString(func.apply(3)));
    }

    @Test
    public void test015() {
        List<Object> list = new ArrayList<>();
        Stream<Object> stream = list.stream();
        Stream<Object> parallelStream = list.parallelStream();

        int[] arr = {1, 2, 3, 4, 5};
        IntStream stream1 = Arrays.stream(arr);
        Object[] arr1 = new Object[3];
        Stream<Object> stream2 = Arrays.stream(arr1);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    @Test
    public void test016() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach((arg) -> System.out.println(arg));
        Stream.iterate(0, t -> t + 2).limit(30).forEach(System.out::println);

        System.out.println("============");

        Stream.generate(() -> Math.random()).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void test017() {
        Stream.generate(Math::random).limit(10).forEach(s -> System.out.print(s + ", "));
        //Double[] arr = (Double[]) Stream.generate(Math::random).limit(30).toArray();
        //Arrays.stream(arr).filter(d -> d < 0.5).forEach(System.out::println);
        double[] arr = {0.7996906005726447, 0.670823051604833, 0.18310674886118183, 0.6382054744881418, 0.11118196863551655, 0.7086268770568478, 0.9953146614412427, 0.5038848027307418, 0.8988962563315477, 0.9652731891030628,
        };
        Arrays.stream(arr).filter(d -> d > 0.5).forEach(System.out::println);
        Arrays.stream(arr).filter(d -> d < 0.5).skip(20).forEach(System.out::println);
        System.out.println("========");
        Arrays.stream(arr).distinct().forEach(System.out::println);
    }


    @Test
    public void test019() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\aop2.xml")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        words.stream().map(s -> s.length() > 3 && s.length() < 6).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test018() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //list.stream().map(String::toUpperCase).forEach(System.out::println);
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::fromStringToStream);
        streamStream.forEach(s -> s.forEach(System.out::println));
        System.out.println("=====================");

        list.stream().flatMap(StreamTest::fromStringToStream).forEach(System.out::println);
    }

    @Test
    public void test020() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(StreamTest::fromStringToStream).forEach(System.out::println);
    }

    @Test
    public void test021() {
        int[] arr = {343, 54, 3, 4, 65, 231, 4, 55, 90};
        //Arrays.stream(arr).sorted().forEach(System.out::println);

        //Arrays.stream(arr).sorted((o1, o2) -> {return Integer.compare(o1, o2)}).forEach(System.out::println);
        System.out.println(Arrays.stream(arr).allMatch(e -> e > 22));
        System.out.println(Arrays.stream(arr).anyMatch(e -> e > 22));
        System.out.println(Arrays.stream(arr).noneMatch(e -> e == 2));
        System.out.println(Arrays.stream(arr).findFirst());
        System.out.println(Arrays.stream(arr).findAny());
        System.out.println(Arrays.stream(arr).max());
        System.out.println(Arrays.stream(arr).min());
        System.out.println(Arrays.stream(arr).count());
        Arrays.stream(arr).forEach(System.out::println);

        Arrays.asList(arr).forEach(System.out::println);
    }

    @Test
    public void  test022() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.stream(arr).reduce(0, Integer::sum));
        System.out.println(Arrays.stream(arr).reduce(0, (x, y) -> x + y));
    }

    @Test
    public void test023() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(arr).filter(e -> e > 4).collect(Collectors.toList()).forEach(System.out::println);

        Arrays.stream(arr).filter(e -> e < 9).collect(Collectors.toSet()).forEach(System.out::println);
    }
}
