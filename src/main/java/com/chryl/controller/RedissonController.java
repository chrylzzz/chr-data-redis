package com.chryl.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Chr.yl on 2020/6/5.
 *
 * @author Chr.yl
 */
public class RedissonController {


    @Autowired
    private RedissonClient redissonClient;

}