package com.springbootdemo.byb;

import com.springbootdemo.byb.person.model.Person;
import com.springbootdemo.byb.person.service.PersonService;
import com.springbootdemo.utils.Log4jUtils;
import com.springbootdemo.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


	@Autowired
	private PersonService personService;
	@Autowired
	private RedisUtils redisUtils;

	@Test
	public void contextLoads() {
		Log4jUtils.getLogger().info("asdasdasdsaddsa");
	}


	/**
	 *
	 *查询数据
	 *并将数据数据存在redis里
	 */
//	@Test
	public void testfind() {
		//如果缓存存在
		boolean hasKey = redisUtils.exists("testkey".concat("1"));
		if(hasKey){
			//获取缓存
			Person object = (Person) redisUtils.get("testkey".concat("1"));
			Log4jUtils.getLogger().info("从缓存获取的数据--"+ object.getName());
		}else{
			//从DB中获取信息
			Log4jUtils.getLogger().info("从数据库中获取数据");
			Person user = personService.selectByPrimaryKey(1);//根据ID查询，因为是测试，就直接写了id为1011
			//数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
			redisUtils.set("testkey".concat(user.getId().toString()),user,10L, TimeUnit.MINUTES);
			Log4jUtils.getLogger().info("数据插入缓存"+user.getName());
		}

	}


}
