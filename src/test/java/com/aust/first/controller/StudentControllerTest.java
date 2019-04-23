package com.aust.first.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

/**
 * @author long.chen  2019/4/8
 * @desc
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@ContextConfiguration
public class StudentControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    
    /**
     * 根据id查询单元测试通过，样例
     * */
    @Test
    public void f1() throws Exception{
        //路径
        RequestBuilder request = get("/student/f1-id")
                //参数
                .param("id", "1")
                //接受的数据类型
                .accept(MediaType.ALL_VALUE);
        String responseString = mvc.perform(request)
                //状态吗是否相等
                .andExpect(status().isOk())
                //输出信息
                .andDo(print())
                //将相应的数据转换为字符串
                .andReturn().getResponse().getContentAsString();

        log.info("响应{}", responseString);
    }


    /**
     * 修改电视频道接口
     * TODO 缺省图片
     * */
   /* @Test
    public void update() throws Exception {
        ConTelevision television = new ConTelevision();
        television.setTelevisionId(5L);
        television.setTelevisionName("测试频道_update");
        television.setAlias("test_chanel_update");
        television.setTelevisionType("01_update");
        television.setTelevisionStatus("1_update");
        television.setPublishStatus("01_update");
        television.setCountry("中国_update");
        television.setLiveStream(Integer.valueOf(1));
        television.setIntroduction("更新id8的测试对象");
        television.setProvince("0001_update");
        television.setRevision(0);
        String json = com.alibaba.fastjson.JSONObject.toJSONString(television);
        log.info("数据 : {}",json);
        RequestBuilder requestBuilder = put("/oes-content/television/update-television")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);
        String responseString = mvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        log.info("响应 ： {}"+responseString);
    }

    *//**
     * 电视频道高级搜索接口
     * *//*
    @Test
    public void queryTelevisions() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
//        multiValueMap.set("televisionId","1");
        multiValueMap.set("televisionName","test");
        multiValueMap.set("page","1");
        multiValueMap.set("rows","5");
        multiValueMap.set("sidx","televisionId");
        multiValueMap.set("sord","desc");

        RequestBuilder requestBuilder = get("/oes-content/television/query-televisions").params(multiValueMap).accept(MediaType.APPLICATION_JSON);
        String content = mvc.perform(requestBuilder).
                            andExpect(status().isOk()).
                                andDo(print()).andReturn().
                                    getResponse().
                                        getContentAsString();
        log.info("响应: {}",content);
    }

    *//**
     * 删除电视频道
     * *//*
    @Test
    public void deleteTelevision() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("televisionId","1");
        RequestBuilder requestBuilder = delete("/oes-content/television/delete-television").params(multiValueMap).accept(MediaType.APPLICATION_JSON);
        String content = mvc.perform(requestBuilder).
                andExpect(status().isOk()).
                andDo(print()).andReturn().
                getResponse().
                getContentAsString();
        log.info("响应: {}",content);
    }

    *//**
     * 查询电视频道图片
     * *//*
//    @Test
    public void queryImage() throws Exception {
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.set("televisionId","1");
        multiValueMap.set("useType","01");
        multiValueMap.set("type","00");
        RequestBuilder requestBuilder = get("/oes-content/television/get-images").params(multiValueMap).accept(MediaType.APPLICATION_JSON);
        String content = mvc.perform(requestBuilder).
                andExpect(status().isOk()).
                andDo(print()).andReturn().
                getResponse().
                getContentAsString();
        log.info("响应后: {}",content);
    }

    *//**
     * 删除电视频道
     * *//*
    @Test
    public void deletImage() throws Exception {
        queryImage();

        ConTelevisionImageRequestVo vo = new ConTelevisionImageRequestVo();
        vo.setId(1L);
        vo.setType("01");
        String json = JSON.toJSONString(vo);
        RequestBuilder requestBuilder = delete("/oes-content/television/delete-image").content(json).contentType(MediaType.APPLICATION_JSON);
        String content = mvc.perform(requestBuilder).
                andExpect(status().isOk()).
                andDo(print()).andReturn().
                getResponse().
                getContentAsString();
        log.info("响应: {}",content);

        queryImage();
    }

    public void insert() throws Exception {
        ConTelevision television = new ConTelevision();
        television.setTelevisionId(1L);
        television.setTelevisionName("测试频道");
        television.setAlias("test_chanel");
        television.setTelevisionType("01");
        television.setTelevisionStatus("1");
        television.setPublishStatus("01");
        television.setCountry("中国");
        television.setLiveStream(Integer.valueOf(1));
        television.setIntroduction("测试频道节目");
        television.setProvince("0001");
        String json = com.alibaba.fastjson.JSONObject.toJSONString(television);
        log.info("数据 : {}",json);
        RequestBuilder request =post("/oes-content/television/save-television").contentType(MediaType.APPLICATION_JSON).content(json);
        String responseString = mvc.perform(request).andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        log.info("响应 ： {}"+responseString);
    }*/
}
