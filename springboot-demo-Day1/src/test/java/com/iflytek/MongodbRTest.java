package com.iflytek;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.iflytek.bean.RoncooUser;
import com.iflytek.compnent.RoncooMongodbComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class MongodbRTest {
	@Autowired
	private RoncooMongodbComponent component;

	@Test
	public void insert() {
		RoncooUser entity = new RoncooUser();
		entity.setId(3);
		entity.setName("无境");
		entity.setCreateTime(new Date());
		component.insert(entity);
	}

//	@Test
//	public void delete() {
//		roncooUserLogMongoDao.delete(1);
//	}
//
//	@Test
//	public void update() {
//		RoncooUserLog entity = new RoncooUserLog();
//		entity.setId(1);
//		entity.setUserName("无境2");
//		entity.setUserIp("192.168.0.1");
//		entity.setCreateTime(new Date());
//		roncooUserLogMongoDao.save(entity);
//	}

	// @Test
	// public void select() {
	// RoncooUserLog result = roncooUserLogMongoDao.findOne(1);
	// System.out.println(result);
	// }
	//
	// @Test
	// public void select2() {
	// RoncooUserLog result = roncooUserLogMongoDao.findByUserName("无境2");
	// System.out.println(result);
	// }
	//
	// // 分页
	// @Test
	// public void queryForPage() {
	// Pageable pageable = new PageRequest(0, 20, new Sort(new
	// Order(Direction.DESC, "id")));
	// // Page<RoncooUserLog> result =
	// roncooUserLogDao.findByUserName("无境2", pageable);
	// Page<RoncooUserLog> result = roncooUserLogMongoDao.findAll(pageable);
	// System.out.println(result.getContent());
	// }
}
