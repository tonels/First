package com.aust.first.kafka;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aust.first.entity.Student;
import com.aust.first.repository.StudentRepository;
import com.aust.first.util.ResultBeanUtil;
import com.aust.first.util.StringUtil;

@RestController
@RequestMapping("/kafka")
public class Samplekafka {

	public static Logger logger = LoggerFactory.getLogger(Samplekafka.class);
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private StudentRepository stuRepository;
	
	/*话题一*/
	@KafkaListener(id = "t1", topics = "here") 
	public void listenT1(ConsumerRecord<?, ?> cr) throws Exception { 
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value()); 
		logger.info("here is logging.....",cr.getClass()+ "/l/n"+cr.topic());
		
		System.out.println("cr.partition() :"+cr.partition());
		System.out.println("cr.hashCode(): "+cr.hashCode());
		System.out.println("cr.serializedKeySize(): "+cr.serializedKeySize());
		System.out.println("cr.serializedValueSize(): "+cr.serializedValueSize());
		System.out.println("cr.topic(): "+cr.topic());
		System.out.println("cr.getClass(): "+cr.getClass());
		System.out.println("cr.key()"+cr.key());
		System.out.println("cr.value()"+cr.value());
		} 
	
	/*话题二*/
	@KafkaListener(id = "t2", topics = "there") 
	public void listenT2(ConsumerRecord<?, ?> cr) throws Exception { 
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
		logger.info("there is logging.....",cr.getClass()+ "/l/n"+cr.topic());
		}
	
	/*话题三*/
	@KafkaListener(id="t3",topics="student")
	public void listenT3(ConsumerRecord<?, ?> cr,String id) throws Exception{
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
		System.out.println("通过ID查询所有，已查询完毕，显示所有如下");
		System.out.println("cr.key()"+cr.key());
		System.out.println("cr.value()"+cr.value());
		System.out.println("cr.partition() :"+cr.partition());
		System.out.println("cr.topic(): "+cr.topic());
		System.out.println("订阅端打印 id =" + id);
		//stuRepository.findById(cr.)
		
	}
	
	//kafka测试   
	// http://localhost:8080/kafka/send3?topic=here&key=here&data=is%20here
	//http://localhost:8080/kafka/send3?topic=here&key=here&data=is%20here
	@GetMapping("/send1")
	void send1(String topic,String key,String data){
		kafkaTemplate.send(topic,key,data);
		System.out.println("控制台打印"+topic+"--"+key+"--"+data);
	}
	
	@GetMapping("/send2")
	Map<String,String> send2(String topic,String key,String data){
		kafkaTemplate.send(topic,key,data);
		Map<String,String> map = new HashMap<String, String>();
		map.put("topic",topic);
		map.put("key",key);
		map.put("data",data);
		return map;
	}
	
	@GetMapping("/send3")
	Map<String,String> send3(String topic,String key,String data,@RequestParam(defaultValue="2")Integer i){
		kafkaTemplate.send(topic,key,data);
		Map<String,String> map = new HashMap<String, String>();
		map.put("topic",topic);
		map.put("key",key);
		map.put("data",data);
		
		/*以下是Map的集中遍历方式*/
		//i = 1，方法1时.先遍历key,取出对应的V
		switch(i){
		case 1:
			Set<String> keySet = map.keySet();
			for (String k : keySet) {
				System.out.println(k + " : " + map.get(k));
				}
			break;
			//break;
		//第二种：通过Map.entrySet使用iterator遍历key和value：,一行一行的取
		case 2:
			Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
			         while (it.hasNext()) {
			             Entry<String, String> entry = it.next();
			               System.out.println( entry.getKey() + " : " +  entry.getValue());
			       }
			break;
		//第三种：通过Map.entrySet遍历key和value
		case 3:
			for (Map.Entry<String, String> entry : map.entrySet()) {
				//Map.entry<Integer,String> 映射项（键-值对）  有几个方法：用上面的名字entry
		        //entry.getKey() ;entry.getValue(); entry.setValue();
				//map.entrySet()  返回此映射中包含的映射关系的 Set视图。
				System.out.println( entry.getKey() + " : "+ entry.getValue());
			 }
			break;
			//第四种：通过Map.values()遍历所有的value，但不能遍历key
		case 4:
			for (String v : map.values()) {
				System.out.println("value= " + v);
	       }
			break;
		}
		return map;
		}	
	
	@GetMapping("/findsid")
	private ResultBeanUtil findStudent(Long sid){
			Student s = stuRepository.findBySid(sid);
			if (StringUtil.isNullStr(s)) {
				return ResultBeanUtil.ok("未查到匹配当前信息的记录");
			}else{
				kafkaTemplate.send("t3",String.valueOf(sid));
				return ResultBeanUtil.ok(s);
			}
			
			
		}
		
		
		
		
	}
	
	
	

