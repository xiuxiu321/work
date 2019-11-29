package com.baizhi.service;

import com.baizhi.entity.Dairy;

import java.util.List;

public interface DairyService {
    public void save(Dairy dairy);

    public List<Dairy> findAll();
}
