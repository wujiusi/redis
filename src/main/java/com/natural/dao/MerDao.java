package com.natural.dao;

import com.natural.entity.Mer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerDao {
    public Mer getMerById(String merId);
    public void addMer(Mer mer);
    public void updateMer(Mer mer);
    public void deleteMer(Mer mer);
}
