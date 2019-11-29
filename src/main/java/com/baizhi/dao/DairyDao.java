package com.baizhi.dao;

import com.baizhi.entity.Dairy;

import java.util.List;

public interface DairyDao {
    public List<Dairy> findAll();

    public void save(Dairy dairy);
}
