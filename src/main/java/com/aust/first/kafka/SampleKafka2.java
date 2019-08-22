package com.aust.first.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aust.first.entity.Student;
import com.aust.first.repository.StudentRepository;
import com.aust.first.util.ResultBeanUtil;
import com.aust.first.util.StringUtil;

@RestController
@RequestMapping("/k2")
public class SampleKafka2 {

	public static Logger logger = LoggerFactory.getLogger(Samplekafka.class);

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	@Autowired
	private StudentRepository stuRepository;

	@Autowired
	private RedisTemplate<String,String> redisTemplate;


//	话题一
	@KafkaListener(id = "t5", topics = "one")
	public void listenT1(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
		logger.info("话题一打印日志...");
		String sid = (String) cr.value();
		System.out.println(cr.value());
		redisTemplate.opsForValue().set("sid", sid);
		}

//	话题二
	@KafkaListener(id = "t6", topics = "two")
	public void listenT2(ConsumerRecord<?, ?> cr) throws Exception {
		logger.info("{} - {} : {}", cr.topic(), cr.key(), cr.value());
		logger.info("话题二打印日志...");
		}


		@GetMapping("/s1")
		void send1(String topic,String key,String data){
			kafkaTemplate.send(topic,key,data);
			System.out.println("s1测试开始，消息");
		}

		//localhost:8080/k2/s1/1016
		@GetMapping("/s2/{sid}")
		ResultBeanUtil finds2(@PathVariable Long sid){
			System.out.println(sid);
			Student student = stuRepository.findBySid(sid);
			if (StringUtil.isNullStr(student)) {
				return ResultBeanUtil.ok("无记录");
			}else{
				String topic = "one";
				String key = "0";
				String data = String.valueOf(sid);
				kafkaTemplate.send(topic,data);

				//返回页面
				return ResultBeanUtil.ok(student);
			}
		}

		//localhost:8080/k2/s1/1016
		@GetMapping("/s3/{sid}")
		ResultBeanUtil finds3(@PathVariable Long sid){
			System.out.println(sid);
			Student student = stuRepository.findBySid(sid);
			if (StringUtil.isNullStr(student)) {
				return ResultBeanUtil.ok("无记录");
			}else{
				kafkaTemplate.send(new ProducerRecord<String, String>("one",sid+""));
				//返回页面
				return ResultBeanUtil.ok(student);
			}
		}


}
