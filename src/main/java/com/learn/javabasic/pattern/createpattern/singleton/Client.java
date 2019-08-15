package com.learn.javabasic.pattern.createpattern.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Constructor;

/**
 * 单例模式
 * 核心作用：保证一个类只有一个实例，并且提供一个访问该实例的全局访问结点
 * @see javax.servlet.Servlet
 * @see Runtime
 * 读配置文件的类
 * 网站计数器
 * 数据库连接池，单例，数据库连接是一种数据库资源
 * Spring bean默认是单例的，优点是容器可以管理
 * web中控制器也是单例
 *
 *
 * 优点：
 * 	1 只生成一个实例，减少系统的性能开销，当一个对象的产生要比较多的资源时，如读取配置文件，产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后永久主流内存的方式来解决
 *
 * 2 单例模式可以在系统设置全局的访问点，优化共享资源 访问，可以设计一个单例类，负责数据表的映射处理
 */
public class Client {
    private static Logger LOGGER = LoggerFactory.getLogger(Client.class);

    public static void main(String[] args) throws Exception {
        SingletonDemo5 instance1 = SingletonDemo5.getInstance();
        SingletonDemo5 instance2 = SingletonDemo5.getInstance();
        LOGGER.info("instance1 = {}", instance1);
        LOGGER.info("instance2 = {}", instance2);

/*
        //Class<SingletonDemo5> clazz = (Class<SingletonDemo5>) Class.forName(SingletonDemo5.class.getName());
        SingletonDemo5 instance3 = getInstance(SingletonDemo5.class);
        SingletonDemo5 instance4 = getInstance(SingletonDemo5.class);
        LOGGER.info("instance3 = {}", instance3);
        LOGGER.info("instance4 = {}", instance4);*/



        //反序列化的方式构造多个对象
/*        FileOutputStream fos = new FileOutputStream("D:\\ubuntu\\learn\\JavaWeb\\" +
                "MavenProject\\maven03\\lear_servlet" +
                "\\src\\main\\resources\\test\\singleton.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance1);
        oos.close();
        fos.close();*/

        FileInputStream fis = new FileInputStream("D:\\ubuntu\\learn\\JavaWeb\\" +
                "MavenProject\\maven03\\lear_servlet" +
                "\\src\\main\\resources\\test\\singleton.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SingletonDemo5 result = (SingletonDemo5) ois.readObject();
        LOGGER.warn(result.toString());

    }

    /**
     * 反射破坏单例模式
     * @param tClass
     * @param <T>
     * @return
     */
    // 传入一个Class对象，然后生成一个对象
    private static <T> T getInstance(Class<T> tClass) {
        T target = null;
        try {
            LOGGER.info(tClass.getName());
            Class<T> clazz = (Class<T>) Class.forName(tClass.getName());
            Constructor<T> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            target = constructor.newInstance();

        } catch (Exception e) {
            LOGGER.error("create object occur with exception: ", e);

        }
        return target;
    }


    /**
     * 传入Object对象，都能通过反射创建对象
     * @param object
     * @param <T>
     * @return
     */
    private static <T> T getInstance(Object object) {
        T target = null;
        try {
            LOGGER.info(object.getClass().getName());
            Class<T> clazz = (Class<T>) Class.forName(object.getClass().getName());
            Constructor<T> constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            target = constructor.newInstance();

        } catch (Exception e) {
            LOGGER.error("create object occur with exception: {}", e);

        }
        return target;
    }
}
