package com.learn.javabasic.thread.sxtdemo.scriptengine;

import javax.annotation.processing.Filer;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.net.URL;
import java.util.List;

/**
 * 通过脚本引擎执行javascript代码
 */
public class Demo1 {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
        // 获取脚本引擎对象
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");

        // 定义变量 存储到引擎上下文
        engine.put("msg", "dongfang is a good main!");
        String str = "var user = {name: 'dongfang', age: 18, schools: ['MIT', 'UCB']};";
        str += "print(user.name);";


        // 执行脚本
        engine.eval(str);
        engine.eval("msg = 'sxt is a good school';");
        System.out.println(engine.get("msg"));
        System.out.println("#####################33");

        // 定义函数
        engine.eval("function add(a, b) { var sum = a + b; return sum;}");

        // 取得调用接口
        Invocable jsInvoke = (Invocable) engine;

        // 执行脚本中定义的方法
        Object result1 = jsInvoke.invokeFunction("add", new Object[] {12, 30});
        System.out.println(result1);


        // 导入其他java包，使用其他包中的java类
        String jsCode = "var list = java.util.Arrays.asList(\"MIT\", \"HIT\");";
        engine.eval(jsCode);

        List<String> list = (List<String>) engine.get("list");
        System.out.println(list);


        // 执行一个js文件，
        URL url = Demo1.class.getClassLoader().getResource("test.js");
        FileReader fr = new FileReader(url.getPath());
        engine.eval(fr);
        fr.close(); // 由于只是测试，不规范
    }
}
