package com.revenue.revenueCollection.GenericDao;


import com.revenue.revenueCollection.Models.Agent;

import java.io.Serializable;
import java.util.List;

/**
 * Created by faima on 4/19/17.
 */
public interface GenericDaoI<T, PK extends Serializable>{
    T save(T t);
    T findById(PK id);
    T merge(T t);
    List<Agent> findAll();
    boolean remove(T t);
}
