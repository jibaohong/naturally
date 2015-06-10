package com.naturally.dao;

import java.util.List;

public interface BaseDao<T, P> {

	Boolean save(T record);

	Boolean update(T record);

	Boolean delete(Object id);

	T findById(Object id);

	List<T> findAll();

}
