package com.natural.redisdemo;

import com.natural.entity.Mer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDemoApplicationTests {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private ValueOperations<String,Object> valueOperations;

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ListOperations<String, Object> listOperations;

    @Autowired
    private SetOperations<String, Object> setOperations;

    @Autowired
    private ZSetOperations<String, Object> zSetOperations;


    @Test
    public void redisTest(){
        Mer mer = new Mer();
        mer.setMerId("421000000001");
        mer.setMerName("测试商户zz1");

        valueOperations.set(mer.getMerId(),mer);

        /*redisTemplate.delete("mer");
        redisTemplate.delete("name");
        redisTemplate.delete("nameList");*/

    }
}
