package com.naturally.dao;

import com.naturally.entity.table.TUser;
import com.naturally.example.TUserExample;

public interface TUserDao extends BaseDao<TUser, TUserExample> {

	TUser findByLoginAccount(String loginAccount);

}
