package com.iac.util.mapper;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springside.modules.utils.Exceptions;
import org.springside.modules.utils.Reflections;

public class BeanUtil {

	private static BeanUtilsBean bub = BeanUtilsBean.getInstance();
	
	/**
	 * Introspector 方式 map->bean 不支持MapBeanProperty注解
	 * @param src
	 * @param beanClazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToBeanByIntrospector(Map<String, Object> src, Class<T> beanClazz) throws Exception {
		if (src == null)
			return null;
		T t = beanClazz.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(beanClazz);
		
		PropertyDescriptor[] desces = beanInfo.getPropertyDescriptors();
		for(PropertyDescriptor desc : desces) {
			Method setter = desc.getWriteMethod();
			
			if(setter != null) 
				setter.invoke(t, src.get(desc.getName()));
		}
		
		return t;
	}
	
	/**
	 * 反射映射map-> bean
	 * 支持MapBeanProperty注解
	 * 嵌套MAP 需要测试
	 * @param src
	 * @param beanClazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T mapToBeanByReflect(Map<String, Object> src, Class<T> beanClazz) throws Exception {
		if (src == null)
			return null;
		T t = beanClazz.newInstance();
		Field[] fields = beanClazz.getDeclaredFields();
		for(Field field : fields) {
			int mod = field.getModifiers();
			if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
                continue;    
            }    
			Reflections.makeAccessible(field);	// 禁止jdk反射时对class的类型安全检查 提升反射效率
			MapBeanProperty annotation = field.getAnnotation(MapBeanProperty.class);
			if(annotation == null) {
				Method m = beanClazz.getMethod("get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				if(m != null) {
					annotation = m.getAnnotation(MapBeanProperty.class);
				}
			}
			
			String key = annotation == null || StringUtils.isBlank(annotation.value()) 
					? field.getName() : annotation.value();
			Object value = src.get(key);
			if(value == null)
				continue;
			
			//1 同时需要检测 field 是否是简单的类型 否则set的时候会抛出类型cast exception
			if(value instanceof Map) {
				value = mapToBeanByReflect((Map)value, field.getDeclaringClass());
			}
			//resolve 1: 类型转换在 BeanUtilsBean.setProperty方法中
			// date 日期类型的需要在页面上手动转 或者在 MapBeanProperty 中增加DateFormat 再进行日期解析
			bub.setProperty(t, field.getName(), value);
		}
		
		return t;
	}
	
	/**
	 * list map mapping to beans
	 * @param src
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> mapListBeans(List<Map<String, Object>> src, Class<T> clazz) {
		List<T> result = new ArrayList<T>(src.size());
		for(Map<String, Object> map : src) {
			try {
				T obj = mapToBeanByReflect(map, clazz);
				result.add(obj);
			} catch (Exception e) {
				e.printStackTrace();
				throw Exceptions.unchecked(e);
			}
		}
		return result;
	}
	
	/**
	 * 将list中根据属性提取作为key 拥有相同属性的作为list 
	 * 
	 * 返回Map 对象
	 * 主要用在图形报表中 按属性画多条线时使用 example:
	 * 
	 * <pre>
	 * 	List&lt;Bean[area]> -> Map&lt;area, List&lt;Bean>> 
	 * 	to display area1 list and area2 list Etc...
	 * </pre>
	 * @return
	 */
	public static <T> Map<Object, List<T>> convertListToMap(final List<T> collection, 
			final String keyPropertyName) {
		Map<Object, List<T>> map = new HashMap<Object, List<T>>(collection.size());

		try {
			for (T obj : collection) {
				Object key = PropertyUtils.getProperty(obj, keyPropertyName);
				List<T> tmp = map.get(key);
				if(tmp == null) {
					tmp = new ArrayList<T>();
					map.put(key, tmp);
				}
				tmp.add(obj);
			}
		} catch (Exception e) {
			throw Reflections.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}
}
