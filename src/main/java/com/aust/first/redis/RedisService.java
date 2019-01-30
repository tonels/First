package com.aust.first.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;
import com.aust.first.util.StringUtil;


public class RedisService {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	/*设置redis的key和value*/
	
	public void setRedisValue(String key,String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}
	
	/*设置redis的key和value*/
	public void setRedisOblect(String key,Object value) {
		stringRedisTemplate.opsForValue().set(key,JSON.toJSONString(value));
	}
	
	/*根据key，获取value*/
	public String getRedisValue(String key) {
		return stringRedisTemplate.opsForValue().get(key);
	}
	
	/*根据key，获取对应的<T>值*/
	public <T> T getRedisObject(String key,Class<T> cls) {
		String value = getRedisValue(key);
		if (StringUtil.isNullStr(value)) {
			return null;
		}
		return JSON.parseObject(value,cls);
	}
	
	/*根据key以及分页参数获取对应页面的<T>T值*/
	public <T> List<T> getRedisList(String keys,Class<T> cls,Integer page,Integer rows){
		List<T> list = new ArrayList<>();
		Set<String> keySey = stringRedisTemplate.keys(keys);
		List<String> keyList = new ArrayList<>();
		int size = keyList.size();
		/*如果集合数大于查询数就可以直接按页截取，如果集合数处于页数中间，说明只需要截取到集合数即可，否则为空（翻页说超过最大页了）*/
		if (size > page*rows) {
			keyList.subList((page-1)*rows,size);
		}else if (size > (page-1)*rows) {
			keyList.subList((page-1)*rows,size);
		}else {
			return list;
		}
		for (String key : keyList) {
			String value = stringRedisTemplate.opsForValue().get(key);
			list.add(JSON.parseObject(value,cls));
		}
		return list;
		}
	
		/*根据key获取对应的<T> T值*/
		public int getKeysCount(String keys) {
		Set<String> keySet = stringRedisTemplate.keys(keys);	
		return keySet.size();
		}
		
		/*根据key删除对应的value*/
		public void remove(String key) {
			stringRedisTemplate.delete(key);
		}
		public void remove(List<String> key) {
			stringRedisTemplate.delete(key);
		}
		
		/*根据key删除对应的value*/
		public void removeLike(String keys) {
			
			Set<String> keySet = stringRedisTemplate.keys(keys);
			stringRedisTemplate.delete(keySet);
		}
}
