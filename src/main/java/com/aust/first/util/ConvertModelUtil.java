package com.aust.first.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public class ConvertModelUtil {

	private ConvertModelUtil() {
	}

	private static final Logger log = LoggerFactory
			.getLogger(ConvertModelUtil.class);

	public static <T> T convertMerge(Map<String, Object> map, T t) {
		StringBuilder errorName = new StringBuilder("");
		try {
			Object isNull = null;
			// 获取javaBean属性
			BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			Map<String, Method> parmsMap = new HashMap<>();
			if (propertyDescriptors != null && propertyDescriptors.length > 0) {
				for (PropertyDescriptor pd : propertyDescriptors) {
					String propertyName = pd.getName().toLowerCase();
					Method setMethod = pd.getWriteMethod();
					parmsMap.put(propertyName.toLowerCase(), setMethod);
				}
			}
			for (Entry<String, Object> entry : map.entrySet()) {
				String name = entry.getKey();
				Object value = entry.getValue();
				Method method = parmsMap.get(name.toLowerCase());
				if (method == null) {
					continue;
				}
				errorName.delete(0, errorName.length());
				errorName.append(name);
				Type[] types = method.getGenericParameterTypes();
				String tpye = types[0].getTypeName();
				if (tpye.equals("java.lang.Integer")) {
					if(!StringUtil.isNullStr(value)){
						method.invoke(t, Integer.valueOf(value.toString()));
					}else{
						method.invoke(t, isNull);
					}
				}else if (tpye.equals("java.lang.Long")) {
					if(!StringUtil.isNullStr(value)){
						method.invoke(t, Long.valueOf(value.toString()));
					}else{
						method.invoke(t, isNull);
					}
				}else if(tpye.equals("java.time.LocalDateTime")){
					if(value instanceof LocalDateTime){
						method.invoke(t, value);
					}else if(!StringUtil.isNullStr(value)){
						method.invoke(t, LocalDateTime.parse(value.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
					}else{
						method.invoke(t, isNull);
					}
				}else if(tpye.equals("java.time.LocalDate")){
					if(value instanceof LocalDate){
						method.invoke(t, value);
					}else if(!StringUtil.isNullStr(value)){
						method.invoke(t, LocalDate.parse(value.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
					}else{
						method.invoke(t, isNull);
					}
				}else if(tpye.equals("java.math.BigInteger")){
					if(value instanceof BigInteger){
						method.invoke(t, value);
					}else if(!StringUtil.isNullStr(value)){
						method.invoke(t, new BigInteger(value.toString()));
					}else{
						method.invoke(t, isNull);
					}
				}
				else {
					method.invoke(t, value);
				}
			}
			return t;
		} catch (Exception e) {
			log.error("--------convertMerge error! ---->{}|{}", errorName.toString() , e.getMessage());
		}
		return null;
	}
	
	/**
	 * 目标类的属性类性只能存在 Long Integer String LocalDateTime LocalDate 五种
	 */
	public static <T> T convert(Map<String, Object> map, Class<T> clazz) {
		// 创建 JavaBean 对象
		try {
			T obj = clazz.newInstance();
			return convertMerge(map, obj);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public static <T> T convert(Object obj, Class<T> clazz) {
		if (obj != null) {
			try {
				T dist = clazz.newInstance();
				BeanUtils.copyProperties(obj, dist);
				return dist;
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return null;
	}

	/**
	 * 	将源复制进目标类，但值为null或""的字段不填充进入目标类
	 * @param source
	 * @param target
	 * @return
	 */
	public static <T> T convert(Object source, T target) {
		if (source != null && target != null) {
			try {
				return convertMerge(objectConvert2Map(source), target);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return null;
	}
	
	public static Map<String, Object> objectConvert2Map(Object obj) {
		// 获取javaBean属性
		PropertyDescriptor[] propertyDescriptors = null;
		Map<String, Object> map = new HashMap<>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			if (propertyDescriptors != null && propertyDescriptors.length > 0) {
				for (PropertyDescriptor pd : propertyDescriptors) {
					String propertyName = pd.getName();
					if("class".equals(propertyName)){
						continue;
					}
					Method getMethod = pd.getReadMethod();
					if(getMethod != null){
						Object value = getMethod.invoke(obj, null);
						if(!StringUtil.isNullStr(String.valueOf(value))){
							map.put(propertyName, value);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error("objectConvert2Map error! ---{}", e);
		}
		return map;
	}

	public static <T> Optional<T> convertOptional(Object obj, Class<T> clazz) {
		if (obj != null) {
			try {
				T dist = clazz.newInstance();
				BeanUtils.copyProperties(obj, dist);
				return Optional.of(dist);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return Optional.empty();
	}

	public static <T> List<T> convertList(List<?> objs, Class<T> clazz) {
		if (objs == null) {
			return new ArrayList<>();
		}

		return objs.stream().filter(Objects::nonNull)
				.map(obj -> ConvertModelUtil.convert(obj, clazz))
				.collect(Collectors.toList());
	}

	public static <T> Set<T> convertSet(Set<?> objs, Class<T> clazz) {
		if (objs == null) {
			return new HashSet<>();
		}

		return objs.stream().filter(Objects::nonNull)
				.map(obj -> ConvertModelUtil.convert(obj, clazz))
				.collect(Collectors.toSet());
	}

}
