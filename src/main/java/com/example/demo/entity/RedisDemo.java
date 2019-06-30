package com.example.demo.entity;


import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;

public class RedisDemo {
    public static void main(String[] args) {
        JedisPoolConfig poolConfig=new JedisPoolConfig();
        poolConfig.setMaxIdle(1);//最大空闲书
        poolConfig.setMaxTotal(5);//最大连接数

        String ip="47.105.163.46";
        Integer port=6380;
        JedisPool jedisPool=new JedisPool(poolConfig,ip,port);
//        Jedis jedis=new Jedis(ip,port);
        Jedis jedis = jedisPool.getResource();
        jedis.auth("123456");
        System.out.println(jedis.ping());

    }
    @Test
    public void t1(){
        String ip="47.105.163.46";
        Integer port=6380;
        Jedis jedis=new Jedis(ip,port);
        jedis.auth("123456");
        jedis.set("yyf","一个伟大的人");
        String yyf = jedis.get("yyf");
        System.out.println(yyf);
    }
    @Test
    public void t2(){
        String ip="47.105.163.46";
        Integer port=6380;
        Jedis jedis=RedisPoolUtil.getJedis();
        String key="zcf";
        if(jedis.exists(key)){
            String zcf = jedis.get("zcf");
            System.out.println("从redis数据库读取"+zcf);
        }else{
            String value="shagua";
            jedis.set(key ,value);
            System.out.println(jedis.get(key));
        }
        RedisPoolUtil.closedJedis(jedis);
    }
    @Test
    public void t3(){
        Jedis jedis = RedisPoolUtil.getJedis();
        String key="user";
        Student student=new Student();
        if(jedis.exists(key)){
            Map<String, String> stringStringMap = jedis.hgetAll(key);
            student.setName(stringStringMap.get("name"));
            student.setAge(Integer.parseInt( stringStringMap.get("age")));
            System.out.println(student);
        }else{
            jedis.hset(key,"name","lhf");
            jedis.hset(key,"age","29");
        }
    }

}
