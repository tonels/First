package com.aust.first.redis;

import com.aust.first.entity.Person;
import com.aust.first.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/ls")
public class RedisResource {

	@Autowired
	private StringRedisTemplate str;
	
	@Autowired PersonRepository repo;
	
	/*@Autowired
	private RedisTemplate<String,RedisUser> redisStr;*/
	
	@GetMapping("/set")
	public void set(){
		for (int i = 0; i < 3; i++) {
			str.opsForValue().set("ls"+i,"学生"+i,10,TimeUnit.SECONDS);
		}
	}
	
	@GetMapping("/get")
	public String get(){
		return str.opsForValue().get("ls1");
	}
	
	@GetMapping("/person")
	public void person(){
		Person person = new Person().setId("1").setFirstname("张三").setLastname("四").setAge("12").setBobbies("fight");
		repo.save(person);
	}
	
	/*下面不能测试*/
	
	/*@GetMapping("/redis")
	public void test2(){
		RedisUser users = new RedisUser();
		users.setId(1);
		users.setAge(20);
		users.setName("张三");
		this.redisStr.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisUser.class));
		this.redisStr.opsForValue().set("users",users);
	}
	@GetMapping("/jdkredis")
	public void test1(){
		RedisUser users = new RedisUser();
		users.setId(1);
		users.setAge(20);
		users.setName("张三");
		this.redisStr.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisUser.class));
		this.redisStr.opsForValue().set("users",users);
	}*/
	
	//@GetMapping("/jedis")
	/*public String jedis1(){
		Jedis jedis = new JedisConnection(jedis, "118.25.104.54","6379");
		for (int i = 0; i < 3; i++) {
			jedis.setPool("118.25.104.54","6379");
		}
		
	}*/
	
}
