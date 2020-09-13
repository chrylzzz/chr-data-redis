package com.chryl.redisson.controller;

import com.chryl.redisson.anno.RedisLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Chr.yl on 2020/6/5.
 *
 * @author Chr.yl
 */
@RequestMapping("/redisson")
@RestController
public class RedissonController {


//    @Autowired
//    private RedissonClient redissonClient;


    int anInt = 1;

    @GetMapping("/get1")//appConnect.id ,appConnect.bizUserId 都是实体类的属性
    @RedisLock(lockName = "insertUser", key = "#appConnect.appId + ':' + #appConnect.bizUserId")
    public Object show1() {
        System.out.println(anInt++);

        return "success";
    }


}