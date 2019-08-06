package com.revanwang.employee.util.result.impl;

import com.revanwang.employee.util.result.IResultHandle;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: 01_EmployeeDAOStrutsJSP
 * @description: 结果集处理器
 * @author: Revan.Wang
 * @create: 2019-08-05 14:16
 **/
public class ResultHandle<T> implements IResultHandle<List<T>> {
    private Class<T> clazz = null;

    /**
     * 构成处理结果对象时，把需要转换的目标对象Class传入
     * @param clazz 目标对象的class
     */
    public ResultHandle(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> handler(ResultSet rs) {
        List<T> tList = new ArrayList<>();
        try {
            //1、内省机制
            BeanInfo beanInfo = Introspector.getBeanInfo(this.clazz, Object.class);
            //2、获取对象属性
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            //3、遍历结果集
            while (rs.next()) {
                //4、创建对象
                T obj = this.clazz.newInstance();
                //5、遍历属性给对象属性赋值
                for (PropertyDescriptor pd : pds) {
                    //6、获取对象的属性值
                    String key = pd.getName();
                    //7、通过属性值来获取结果对象的值
                    Object value = rs.getObject(key);
                    //8、给对象中的属性赋值
                    pd.getWriteMethod().invoke(obj, value);
                }
                tList.add(obj);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return tList;
    }
}
