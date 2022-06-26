package com.cg.service;

import java.util.List;
import java.util.Map;

public interface IGeneralService<T> {
    List<T> findAll();
    boolean create(T t);
    boolean update(T t);
    boolean remove(int id);

//    Map<String, String> update(T t);
//    Map<String, String> doCreate(T t);

}
