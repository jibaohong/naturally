package com.naturally.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.naturally.dao.TUserDao;
import com.naturally.entity.table.TUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring.xml")
public class UserDaoTest {

	@Autowired
	private TUserDao tUserDao;

	@Test
	public void test1() {

		// TUser user = new TUser();
		// user.setId(UUID.randomUUID().toString());
		// user.setLoginaccount("user4");
		// user.setPassword("123456");
		// user.setUsername("用户4");
		// tUserDao.save(user);

		// tUserDao.delete("9c50464e-7447-4d1d-980c-6cdc4eeb7aea");
		// TUser user = new TUser();
		// user.setId("67daf200-9a01-443b-b499-91dfd7c4c797");
		// user.setUsername("用户1");
		// user.setLoginaccount("user1");
		// tUserDao.update(user);

		TUser item = tUserDao.findByLoginAccount("user2");
		System.out.println(JSON.toJSONString(item));

	}

}
