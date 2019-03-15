package com.natural.service.iface;

import com.natural.entity.Mer;

public interface MerService {
    public Mer getMerById(String merId);
    public void addMer(Mer mer);
    public void updateMer(Mer mer);
    public void deleteMer(Mer mer);
}
