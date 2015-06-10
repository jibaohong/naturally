package com.naturally.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.naturally.dao.BaseDao;

@Component
public class BaseDaoImpl<T, P> implements BaseDao<T, P> {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	protected int countByExample(P example) {
		int count = sqlSessionTemplate.selectOne("countByExample", example);
		return count;
	}

	protected int deleteByExample(P example) {
		int count = sqlSessionTemplate.delete("deleteByExample", example);
		return count;
	}

	protected int deleteByPrimaryKey(Object id) {
		int count = sqlSessionTemplate.delete("deleteByPrimaryKey", id);
		return count;
	}

	protected int insert(T record) {
		int count = sqlSessionTemplate.delete("insert", record);
		return count;
	}

	protected int insertSelective(T record) {
		int count = sqlSessionTemplate.delete("insertSelective", record);
		return count;
	}

	protected List<T> selectByExample(P example) {
		List<T> list = sqlSessionTemplate.selectList("selectByExample", example);
		return list;
	}

	protected T selectByPrimaryKey(Object id) {
		T item = sqlSessionTemplate.selectOne("selectByPrimaryKey", id);
		return item;
	}

	protected int updateByExampleSelective(T record, P example) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		int count = sqlSessionTemplate.update("updateByExampleSelective", map);
		return count;
	}

	protected int updateByExample(T record, P example) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		int count = sqlSessionTemplate.update("updateByExample", map);
		return count;
	}

	protected int updateByPrimaryKeySelective(T record) {
		int count = sqlSessionTemplate.update("updateByPrimaryKeySelective", record);
		return count;
	}

	protected int updateByPrimaryKey(T record) {
		int count = sqlSessionTemplate.update("updateByPrimaryKey", record);
		return count;
	}

	@Override
	public Boolean save(T record) {
		int count = insert(record);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean update(T record) {
		int count = updateByPrimaryKeySelective(record);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Boolean delete(Object id) {
		int count = deleteByPrimaryKey(id);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public T findById(Object id) {
		T recrod = selectByPrimaryKey(id);
		return recrod;
	}

	@Override
	public List<T> findAll() {
		List<T> list = selectByExample(null);
		return list;
	}

}
