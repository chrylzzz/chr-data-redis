package com.chryl;

import com.chryl.redis.redis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOtherData {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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

    //stringRedisTemplate
    @Test
    public void show2() {

        //HASH
        stringRedisTemplate.opsForHash().put("chr22", "1234", "zzzzz");
        Object chr = stringRedisTemplate.opsForHash().get("chr22", "1234");
        System.out.println(chr);


        //LIST
//        stringRedisTemplate.opsForList().rightPush("Chr3—list", "111111");
//        stringRedisTemplate.opsForList().leftPush("Chr3—list", "11111123");
        //pop左边最前一个，并且删除，类似于mq
//        String leftPop = stringRedisTemplate.opsForList().rightPop("Chr3—list");
//        stringRedisTemplate.opsForList().leftPush("Chr3—list", "asd3r");
//        System.out.println(leftPop);
//        stringRedisTemplate.opsForList().leftPush("Chr3—list", "82323997");


//SET
//        stringRedisTemplate.opsForSet().add("Chr4", "abc435");
//        stringRedisTemplate.opsForSet().add("Chr4", "abc4");


        //ZSET
//        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小明", 352);
//        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小张", 32);
//        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小马", 31);
//        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小孙", 32);
//        stringRedisTemplate.opsForZSet().add("Chr-Zset", "小迟", 32.556);
    }


    //redisTemplate
    @Test//set
    public void show() {
//        User user = new User(10001, "chryyl", "airjjcz2324", "can", "admin", "true");
//        redisTemplate.opsForValue().set(user.getId().toString(), user, 360, TimeUnit.SECONDS);

        User user2 = new User(10002, "cmcc", "吃鱼了", "can", "admin", "true");
        User user3 = new User(10003, "zmcc", "孙笑嘻", "can", "admin", "true");

        //hash
        redisTemplate.opsForHash().put(user2.getId().toString(), user2.getId().toString(), user2);
        redisTemplate.opsForHash().put(user3.getId().toString(), user2.getId().toString(), user3);


        //key相同,在同一个key下,但是hashKay不同,hash结构
        User user4 = new User(10004, "oppa", "啊是的呢", "can", "admin", "true");
        User user5 = new User(10005, "llms", "奥拉夫", "can", "admin", "true");
        redisTemplate.opsForHash().put(user4.getId().toString(), user4.getId().toString(), user4);
        redisTemplate.opsForHash().put(user4.getId().toString(), user5.getId().toString(), user5);

    }

    @Test//get
    public void show23() {
        //
//        User o = (User) redisTemplate.opsForValue().get("10001");
//        System.out.println(o);
        User user = (User) redisTemplate.opsForHash().get("10002", "10002");
        User user2 = (User) redisTemplate.opsForHash().get("10003", "10002");
        System.out.println(user);
        System.out.println(user2);

    }

}
