package com.natural.redisdemo;

import com.natural.entity.Mer;
import com.natural.service.iface.MerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MerTest {

    @Autowired
    private MerService merService;

    @Test
    public void insert(){
        for(int i = 0; i < 10; i++){
            Mer mer = new Mer();
            mer.setMerId("31300000000"+i);
            mer.setMerName("商户"+i);
            merService.addMer(mer);
        }
    }

    @Test
    public void query(){
        Mer mer = merService.getMerById("313000000000");
        System.out.println(mer.getMerName());
    }
}
