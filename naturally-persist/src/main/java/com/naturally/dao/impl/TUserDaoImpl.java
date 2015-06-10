package com.naturally.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.naturally.dao.TUserDao;
import com.naturally.entity.table.TUser;
import com.naturally.example.TUserExample;

@Component("tUserDao")
public class TUserDaoImpl extends BaseDaoImpl<TUser, TUserExample> implements TUserDao {

	@Override
	public TUser findByLoginAccount(String loginAccount) {
		TUserExample example = new TUserExample();
		example.createCriteria().andLoginaccountEqualTo(loginAccount);
		List<TUser> list = selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
