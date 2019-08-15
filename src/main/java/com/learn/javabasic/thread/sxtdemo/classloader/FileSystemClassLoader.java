package com.learn.javabasic.thread.sxtdemo.classloader;


import com.learn.javabasic.thread.sxtdemo.net.tcp.weichat.version2.CloseUtil;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileSystemClassLoader extends ClassLoader {

    // com.bjsxt.test.User --> d:/myjava/com/bjsxt/test/User 从这个路径加载

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        // 应该要先查询有没有加载这个类，如果已经加载，则返回，如果没有，则加载
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            // 委派给付给加载
            try {
                c = parent.loadClass(name);
            } catch (ClassNotFoundException e) {
                //e.printStackTrace();
            }

            if (c != null) {
                return c;
            } else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                } else {
                    c = defineClass(name, classData, 0, classData.length);
                    return c;
                }
            }
        }
        //return super.findClass(name);
    }

    private byte[] getClassData(String className) {// com.bjsxt.test.User
        String path = rootDir + "/" + className.replace('.', '/') + ".class";

        // 可以使用IoUtils，将流转成字节数组
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            is = new FileInputStream(path);
            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }

            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            CloseUtil.closeAll(is, baos);
        }

    }
}
