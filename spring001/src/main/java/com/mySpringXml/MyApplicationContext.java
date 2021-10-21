package com.mySpringXml;

import com.entity.User;
import com.mySpringXml.dto.UserDto;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class MyApplicationContext {

    Map<String,Object> ioc=new HashMap<>();

    public MyApplicationContext(String path) {
        //1 xml解析 读取对象信息
        UserDto userDto=praseXml("src\\main\\resources\\"+path);
        //2 通过反射创建对象 并存储到类的成员中
        createObj(userDto);
    }

    //获取实例
    public Object getBean(String id){
        return ioc.get(id);
    }

    //调用set完成赋值
    public void callSetter(Map<String,String> map,Object object,Class aClass){
        try {
            String fieldName = map.get("name");//属性名称
            String fieldValue = map.get("value");//属性值
            Field declaredField = aClass.getDeclaredField(fieldName);//属性类型
            String methodName ="set"+ fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);//set方法名
            Method method = aClass.getMethod(methodName,declaredField.getType());//获取set方法
            //类型转换
            Object val=null;
            switch (declaredField.getType().getName()){
                case "java.lang.String":
                    val=fieldValue;
                    break;
                case "java.lang.Integer":
                    val=Integer.parseInt(fieldValue);
                    break;
                case "java.lang.Double":
                    val=Double.parseDouble(fieldValue);
                    break;
            }
            method.invoke(object,val);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    //创建对象
    public void createObj(UserDto userDto){

        try {
            //创建实例
            String clazz = userDto.getClazz();
            Class aClass = Class.forName(clazz);
            Object obj = aClass.getConstructor(null).newInstance();
            List<Map<String, String>> properties = userDto.getProperties();
            for (Map<String, String> property : properties) {
                //给实例属性赋值
                callSetter(property,obj,aClass);
            }
            //存储实例
            ioc.put(userDto.getId(),obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //解析xml
    public UserDto  praseXml(String path)  {
        UserDto userDto=null;
        //dom4j解析
        SAXReader saxReader=new SAXReader();
        try {
            userDto=new UserDto();
            Document document = saxReader.read(path);
            //获取根节点beans
            Element rootElement = document.getRootElement();
            //遍历根节点
            Iterator<Element> iterator = rootElement.elementIterator();
            while (iterator.hasNext()) {

                //获取bean节点
                Element node = iterator.next();
                userDto.setId(node.attributeValue("id"));
                userDto.setClazz(node.attributeValue("class"));
                //获取property节点
                Iterator<Element>  property= node.elementIterator();
                List<Map<String,String>> mapList=new ArrayList<>();
                while (property.hasNext()) {
                    Map<String,String> map=new HashMap<>();
                    Element pro = property.next();
                    map.put("name",pro.attributeValue("name"));
                    map.put("value",pro.attributeValue("value"));
                    mapList.add(map);
                }
                userDto.setProperties(mapList);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return userDto ;
    }


}
