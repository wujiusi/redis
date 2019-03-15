package com.natural.service.impl;

import com.natural.dao.MerDao;
import com.natural.entity.Mer;
import com.natural.service.iface.MerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("merService")
public class MerServiceImpl implements MerService {

    @Autowired
    private MerDao merDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    @Cacheable(value = "mer", key = "#merId")
    public Mer getMerById(String merId) {
        Mer mer = null;
        /*if(redisTemplate.hasKey(merId)){
            System.out.println("过期时间："+redisTemplate.getExpire(merId));
            mer = (Mer)redisTemplate.opsForValue().get(merId);
            System.out.println("查询redis");
        }else {*/
            mer = merDao.getMerById(merId);
            System.out.println("查询数据库");
        /*}*/
        return mer;
    }

    /**
     * 此处不使用CachePut，是因为放置缓存需要方法返回结果。由于此处方法不返回，所以使用CacheEvict清除缓存，当第一次查询时，结果便会缓存。
     * @param mer
     */
    @Override
    @CacheEvict(value = "mer", key ="#mer.getMerId()")
    public void addMer(Mer mer) {
        merDao.addMer(mer);
        //redisTemplate.opsForValue().set(mer.getMerId(),mer);
    }

    @Override
    @CacheEvict(value = "mer", key ="#mer.getMerId()")
    public void updateMer(Mer mer) {
        merDao.updateMer(mer);
        //redisTemplate.opsForValue().set(mer.getMerId(),mer);
    }

    @Override
    @CacheEvict(value = "mer", key ="#mer.getMerId()")
    public void deleteMer(Mer mer) {
        merDao.deleteMer(mer);
        //redisTemplate.delete(mer.getMerId());
    }
}
