package com.chryl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

public class TestOtherData {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * Rigorous Test :-)
     */
    public void shouldAnswerWithTrue() {
//        assertTrue(true);
        getAccountByName("80808");
    }

    //    @CachePut(value="11111",key="#telPhone")
    public String getAccountByName(String telPhone) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("real query account." + telPhone);
//        String s = stringRedisTemplate.opsForValue().get(telPhone);
//        System.err.println(s);
        stringRedisTemplate.opsForValue().set("32100", "3210000", 6000, TimeUnit.SECONDS);
        return "80808";

    }

    public void show2() {
        //HASH
//        stringRedisTemplate.opsForHash().put("Chr2", "23456780", "张三");
//        Object chr = stringRedisTemplate.opsForHash().get("Chr2", "23456780");
//        System.out.println(chr);


        //LIST
        //stringRedisTemplate.opsForList().rightPush("Chr3—list","111111");
        // stringRedisTemplate.opsForList().leftPush("Chr3—list","11111123");
        //pop左边最前一个，并且删除，类似于mq
//        String leftPop = stringRedisTemplate.opsForList().rightPop("Chr3—list");
//        stringRedisTemplate.opsForList().leftPush("Chr3—list","asd3r");
//        System.out.println(leftPop);
        //stringRedisTemplate.opsForList().leftPush("Chr3—list","82323997");


//SET
//        stringRedisTemplate.opsForSet().add("Chr4","abc435");
//        stringRedisTemplate.opsForSet().add("Chr4","abc4");


        //ZSET
        //stringRedisTemplate.opsForZSet().add("Chr-Zset", "小明", 352);
        //  stringRedisTemplate.opsForZSet().add("Chr-Zset", "小张", 32);
        //stringRedisTemplate.opsForZSet().add("Chr-Zset", "小马", 31);
        // stringRedisTemplate.opsForZSet().add("Chr-Zset", "小孙", 32);
        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小迟", 32.556);
    }

}
