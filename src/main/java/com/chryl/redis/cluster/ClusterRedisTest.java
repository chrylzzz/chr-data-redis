package com.chryl.redis.cluster;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 测试Redis5的高可用的集群
 * Created By Chr on 2019/2/23/0023.
 */
public class ClusterRedisTest {

    public static void main(String[] args) throws IOException {
        //cluster方式至少6个节点(3主3从，3主做sharding，3从用来保证主宕机后可以高可用)
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("192.168.92.130", 8001));
        jedisClusterNode.add(new HostAndPort("192.168.92.130", 8004));

        jedisClusterNode.add(new HostAndPort("192.168.92.129", 8002));
        jedisClusterNode.add(new HostAndPort("192.168.92.129", 8005));

        jedisClusterNode.add(new HostAndPort("192.168.92.128", 8003));
        jedisClusterNode.add(new HostAndPort("192.168.92.128", 8006));

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(10);
        config.setTestOnBorrow(true);
        //connectionTimeout：指的是连接一个url的连接等待时间
        //soTimeout：指的是连接上一个url，获取response的返回等待时间
        JedisCluster jedisCluster = new JedisCluster(jedisClusterNode, 6000, 5000, 10, null, config);
        System.out.println(jedisCluster.set("student:", "Chr"));
        System.out.println(jedisCluster.set("age", "20"));

        System.out.println(jedisCluster.get("student"));
        System.out.println(jedisCluster.get("age"));

        jedisCluster.close();
    }
}
