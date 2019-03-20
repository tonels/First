package com.aust.first.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ReflectUtil {
    /**
     * 功能： 将ResultSet 转成list 
     * 步骤： 将ResultSet中的数据赋值给实体对象并将其保存到list集合中,一行数据对应一个对象
     * 
     * @param rs
     *            数据库返回结果集
     * @param xmlPath
     *            数据库表和实体类映射文件路径
     * @return list
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List convert(ResultSet rs, String xmlPath) throws Exception {
        // 1.将映射文件加载到内存中
        InputStream in = new FileInputStream(xmlPath);
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        // 2.将实体类加载到内存中
        String xPath = "//@classPath";
        Attribute classAttr = (Attribute) doc.selectSingleNode(xPath);
        String className = classAttr.getValue();
        Class clazz = Class.forName(className);
        // 3.读取ResultSet中表结构
        ResultSetMetaData rsmd = rs.getMetaData();
        // 获得表的列数
        int colCount = rsmd.getColumnCount();
        // list 用来保存被赋值对象
        List list = new ArrayList();
        while (rs.next()) {
            // 每次循环一行数据,创建一个对象
            Object obj = clazz.newInstance();
            for (int i = 1; i <= colCount; i++) {
                // 获得表的列名
                String colName = rsmd.getColumnName(i);
                xPath = "//property[@colName='" + colName + "']";
                Element colElet = (Element) doc.selectSingleNode(xPath);
                // 获得对应实体类的属性名称
                String nameValue = colElet.attributeValue("name");
                // 使用反射获得实体类中对应的属性对象
                Field nameField = clazz.getDeclaredField(nameValue);
                nameField.setAccessible(true);
                // 实体类属性对应数据类型
                String type = colElet.attributeValue("type");
                // 获得临时表中对应的值
                String value = rs.getString(i);
                Object data = null;
                if ("int".equals(type)) {
                    data = Integer.parseInt(value);
                } else if ("java.lang.String".equals(type)) {
                    data = value;
                } else if ("double".equals(type)) {
                    data = Double.parseDouble(value);
                }
                // 赋值给指定对象
                nameField.set(obj, data);
            }
            list.add(obj);
        }
        return list;
    }
}