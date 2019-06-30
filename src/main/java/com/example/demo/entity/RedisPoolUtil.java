package com.example.demo.entity;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPoolUtil {
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxTotal(5);
        poolConfig.setMaxIdle(1);
        String ip="47.105.163.46";
        Integer port=6380;
         jedisPool=new JedisPool(poolConfig,ip,port);
    }
    public static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");
        return jedis;
    }
    //关闭jedis
    public static void closedJedis(Jedis jedis){
        jedis.close();
    }
}
