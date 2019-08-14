package com.demo.servlet.day1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

public class ServletDemo01 extends HttpServlet {
    int i = 0;


    public ServletDemo01() {
        System.out.println("tomcat new ServletDemo01");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());

    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        test019(req, resp);
    }

    private void test(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void test019(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            out.write("您上次访问的时间是： ");
            for (int i = 0; i < cookies.length; i++) {
                Cookie cookie = cookies[i];
                if (cookie.getName().equals("lastAccessTime")) {
                    Long lastAccesTime = Long.parseLong(cookie.getValue());
                    Date date = new Date(lastAccesTime);
                    out.write(date.toLocaleString());
                }
            }
        } else {
            out.write("这是你第一次访问本站");
        }

        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis() + "");
        response.addCookie(cookie);
    }

    private void test018(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(this.getServletContext().getRealPath("/download/IMG_1659.JPG"));
        this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
    }


    private String makeNum() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
        }

        num = sb.toString() + num;
        return num;
    }

    private void test017(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("refresh", "5");//设置refresh响应头控制浏览器每隔5秒钟刷新一次
        //1.在内存中创建一张图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);
        //2.得到图片
        //Graphics g = image.getGraphics();
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setColor(Color.WHITE);//设置图片的背景色
        g.fillRect(0, 0, 80, 20);//填充背景色
        //3.向图片上写数据
        g.setColor(Color.BLUE);//设置图片上字体的颜色
        g.setFont(new Font(null, Font.BOLD, 20));
        g.drawString(makeNum(), 0, 20);
        //4.设置响应头控制浏览器浏览器以图片的方式打开
        response.setContentType("image/jpeg");//等同于response.setHeader("Content-Type", "image/jpeg");
        //5.设置响应头控制浏览器不缓存图片数据
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //6.将图片写给浏览器
        ImageIO.write(image, "jpg", response.getOutputStream());
    }


    /**
     * 文件下载时，推荐使用OutputStream流，不要使用PrintWrite流，因为OutputStream是字节流，可以处理任意的数据 类型
     * 而PrintWriter流是字节流，只能处理字符数据 ，如果 用字符流处理字节数据，会导致数据丢失
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void test016(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream in = this.getServletContext().getResourceAsStream("/download/IMG_1659.JPG");
        OutputStream out = response.getOutputStream();

        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode("李慧.jpg", "UTF-8"));
        byte[] buffer = new byte[1024];
        int len = 0;

        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }


    }


    /**
     * 在开发过程中，如果希望服务器输出什么浏览器就能看到什么，那么在服务器端都要以字符串的形式进行输出。
     */
    private void test015(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        OutputStream out = response.getOutputStream();

        out.write("使用OutputStream流输出数字 1 ====".getBytes("UTF-8"));
        out.write((1 + "").getBytes("UTF-8"));
    }


    /**
     * 使用PrintWriter流输出中文注意问题：
     * <p>
     * 在获取PrintWriter输出流之前首先使用"response.setCharacterEncoding(charset)"
     * 设置字符以什么样的编码输出到浏览器，如：response.setCharacterEncoding("UTF-8");
     * 设置将字符以"UTF-8"编码输出到客户端浏览器，然后再使用response.getWriter();
     * 获取PrintWriter输出流，这两个步骤不能颠倒，如下：
     */
    private void test014(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "中国";

        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        response.setHeader("content-type", "text/html;charset-UTF-8");
        out.write(data);

    }


    /**
     * 在服务器端，数据是以哪个码表输出的，那么就要控制客户端浏览器以相应的码表打开，
     * 比如：outputStream.write("中国".getBytes("UTF-8"));
     * 使用OutputStream流向客户端浏览器输出中文，以UTF-8的编码进行输出
     * 此时就要控制客户端浏览器以UTF-8的编码打开，否则显示的时候就会出现中文乱码，
     * 那么在服务器端如何控制客户端浏览器以以UTF-8的编码显示数据呢？
     * <p>
     * response.setHeader("content-type", "text/html;charset=UTF-8");
     * 通过设置响应头控制浏览器以UTF-8的编码显示数据
     * <p>
     * data.getBytes()是一个将字符转换成字节数组的过程，这个过程中一定会去查码表，
     */
    private void test013(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "中国";
        OutputStream outputStream = response.getOutputStream();
        response.setHeader("content-type", "text/html;charset=UTF-8");

        byte[] dataByteArr = data.getBytes("UTF-8");
        outputStream.write(dataByteArr);
    }


    /**
     * 在客户端缓存Servlet的输出
     * 对于不经常变化的数据，在servlet中可以为其设置合理的缓存时间值，以避免浏览器频繁向服务器发送请求，提升服务器的性能
     */
    private void test012(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String data = "dfaaffffffffffffffffffffff";
        response.setDateHeader("expires", System.currentTimeMillis() + 24 * 3600 * 1000);
        response.getWriter().println(data);

    }


    private void test011(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 这个stream的根目录就是web
        InputStream is = this.getServletContext().getResourceAsStream("/download/db.properties");
        Properties properties = new Properties();
        properties.load(is);

        PrintWriter out = response.getWriter();
        out.println("mysqlDriver = " + properties.get("mysqlDriver"));
        out.println("mysqlURL = " + properties.get("mysqlURL"));
        out.println("mysqlUser = " + properties.get("mysqlUser"));
        out.println("mysqlPwd = " + properties.get("mysqlPwd"));


    }

    private void test010(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("start Spring");
        ApplicationContext context = new FileSystemXmlApplicationContext("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\bean-demo.xml");
        out.println("start Spring succeed");


    }

    private void test009(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        String sharedData = "你是傻逼";
        context.setAttribute("shared data", sharedData);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/servlet/ServletDemo6");
        dispatcher.forward(request, response);
    }

    private void test008(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config = this.getServletConfig();
        PrintWriter out = response.getWriter();

        Enumeration<String> enumeration = config.getInitParameterNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = config.getInitParameter(name);
            out.println("name = " + name);
            out.println("value = " + value);
        }
    }

    private void test007(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        synchronized (this) {
            i++;
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.getWriter().write(" i = " + i);
        }

    }

    private void test006(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY>");
        out.print("    This is ");
        out.println(this.getClass());
        Thread thread = Thread.currentThread();
        out.println(thread.getContextClassLoader());
        out.println(thread.getContextClassLoader().getParent());
        out.println(thread.getThreadGroup());
        out.println(", using the GET method");
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();

    }

    /**
     * 设置content-disposition响应头，让浏览器下载文
     */
    private void test005(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("content-dispositon", "attachment;filename=xxx.jpg");
        InputStream is = new FileInputStream("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\web\\download\\IMG_1659.JPG");

        byte[] buffer = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = is.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }

    }

    /**
     * 设置refresh 响应头，让浏览器定时刷新
     *
     * @param request
     * @param response
     */
    private void test004(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setHeader("refresh", "3");
        System.out.println("refresh "); // 也就是每隔3秒，浏览器就会请求一次， 这个日志就会打出来
        //设置refresh响应头，让浏览器3秒后跳转到http://www.baidu.com
        //response.setHeader("refresh", "3,url='http://www.baodu.com'");
        //response.getWriter().write("dongfang");
    }


    /**
     * 设置content-type响应头，指定回头数据类型
     *
     * @param request
     * @param response
     */
    private void test003(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // content-type响应头指定发送给浏览器的数据类型为image/jpeg
        response.setHeader("content-type", "image/jpg");

        InputStream is = new FileInputStream("D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\web\\download\\IMG_1659.JPG");

        byte[] buffer = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream(); //得到输出 流
        while ((len = is.read(buffer)) != -1) { //读取输入流里面的内容到缓冲匀
            out.write(buffer, 0, len); // 将缓冲中的内容输出 到浏览器
        }

    }

    /**
     * 1 使用GZIPOutputStream流来压缩数据
     * 2 响应头Content-Encoding 来告诉浏览器，服务器发送回来的数据后的压缩格式
     *
     * @param request
     * @param response
     */
    private void test002(HttpServletRequest request, HttpServletResponse response) {

        String data = "";
        for (int i = 0; i < 500; i++) {
            data += "qqqqqqqqqqqqqqqqqqqqqq";
        }

        System.out.println("原始数据 大小为 " + data.getBytes().length);
        try {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            GZIPOutputStream gout = new GZIPOutputStream(bout);
            gout.write(data.getBytes());
            gout.close();
            byte[] g = bout.toByteArray();
            response.setHeader("Content-Encoding", "gzip");
            response.setHeader("Content-Length", g.length + "");
            response.getOutputStream().write(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 设置响应头，服务器通过Location这个头，来告诉浏览器跳到哪里，就这是所谓的请求重定向
     * 服务器返回一个302状态码告诉浏览器，你要的资源我没有，但是我通过Location响应头告诉你哪里有，
     * 而浏览器解析响应头后知道要跳转到新的页面，就会自动跳转
     *
     * @param request
     * @param response
     */
    private void test001(HttpServletRequest request, HttpServletResponse response) {
        // //设置服务器的响应状态码
        response.setStatus(302);

        response.setHeader("Location", "/JspProject/index.jsp");
    }


}
