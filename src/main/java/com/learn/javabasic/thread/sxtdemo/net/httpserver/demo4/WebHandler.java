package com.learn.javabasic.thread.sxtdemo.net.httpserver.demo4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WebHandler extends DefaultHandler {
    private List<Entity> entities;
    private List<Mapping> mappings;
    private Entity entity;
    private Mapping mapping;
    private String beginTag;
    private boolean isMapping;


    @Override
    public void startDocument() throws SAXException {
        // 文档解析开始
        entities = new ArrayList<>();
        mappings = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // 开始元素

        if (qName != null) {
            beginTag = qName;

            if (qName.equals("servlet")) {
                isMapping = false;
                entity = new Entity();
            } else if (qName.equals("servlet-mapping")) {
                isMapping = true;
                mapping = new Mapping();
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // 处理内容
        if (beginTag != null) {
            String str = new String(ch, start, length);
            if (isMapping) {
                if (beginTag.equals("servlet-name")) {
                    mapping.setServletName(str);
                } else if (beginTag.equals("url-pattern")) {
                    mapping.getUrlPatterns().add(str);
                }
            } else {
                if (beginTag.equals("servlet-name")) {
                    entity.setServletName(str);
                } else if (beginTag.equals("servlet-class")) {
                    entity.setServletClass(str);
                }
            }
        }
    }


    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // 结束元素
        if (qName != null) {
            if (qName.equals("servlet")) {
                entities.add(entity);
            } else if (qName.equals("servlet-mapping")) {
                mappings.add(mapping);
            }
        }
        beginTag = null;
    }


    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Mapping> getMappings() {
        return mappings;
    }

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        // 获取解析工厂
        SAXParserFactory factory = SAXParserFactory.newInstance();

        // 获取解析器
        SAXParser sax = factory.newSAXParser();

        // 指定xml + 处理器
        WebHandler webHandler = new WebHandler();
        String xmlFilePath = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\java\\com\\google\\learn\\javabasic\\thread\\sxtdemo\\net\\httpserver\\demo4\\web.xml";

        sax.parse(new FileInputStream(xmlFilePath),
                webHandler);

        for (Entity entity: webHandler.getEntities()) {
            System.out.println(entity.getServletName());
            System.out.println(entity.getServletClass());
        }
    }
}
