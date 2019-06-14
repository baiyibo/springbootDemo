package com.springbootdemo.byb;

import com.springbootdemo.byb.person.model.Person;
import com.springbootdemo.byb.person.service.PersonService;
import com.springbootdemo.utils.Log4jUtils;
import com.springbootdemo.utils.RedisUtils;
import com.springbootdemo.utils.SoftRefCache.SoftRefCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shejimoshi.proxy.staticProxy.Singer;
import shejimoshi.proxy.staticProxy.SingerMan;
import shejimoshi.proxy.staticProxy.SingerManProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
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
		Log4jUtils.getLogger().error("asdasdasdsaddsa");
	}


	/**
	 *
	 *查询数据
	 *并将数据数据存在redis里
	 */
	@Test
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

	@Test
	public  void test(){
		Singer singerMan = new SingerMan();
		Singer singerManproxy= new SingerManProxy(singerMan);
		singerManproxy.sing("byb");
	}

	@Test
	public  void tes1t(){
		ArrayList<String> list=new ArrayList<>();
		list.add("11");
		list.add("22");
		String a=list.set(0,"333");
		System.out.println(a);
	}



	/**
	 *
	 *测试软引用缓存
	 */
	@Test
	public void testsoftCache() {
		//最大可用内存，对应-Xmx
		System.out.println(	"总可用内存:"+((Runtime.getRuntime().maxMemory() / (1024 * 1024)))+"M");
		System.out.println(	"当前占用内存:"+(Runtime.getRuntime().totalMemory() / (1024 * 1024))+"M");
		TestCache testCache = new TestCache();

		testCache.set("key1",new byte[1024*1024*600]);
		testCache.set("key2",new byte[1024*1024*600]);
		testCache.set("key3",new byte[1024*1024*600]);
		testCache.set("key4",new byte[1024*1024*600]);
		System.out.println(	"当前占用内存:"+(Runtime.getRuntime().totalMemory() / (1024 * 1024))+"M");
		testCache.get("key1");
		testCache.set("key5",new byte[1024*1024*600]);
		System.out.println(	"当前占用内存:"+(Runtime.getRuntime().totalMemory() / (1024 * 1024))+"M");
		testCache.get("key1");
		//当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和
		System.out.println(	"当前占用内存:"+(Runtime.getRuntime().totalMemory() / (1024 * 1024))+"M");


//		 Runtime.getRuntime().freeMemory();  //当前JVM空闲内存


	}

	@Test
	public void testClassMethod() throws Exception {
		Class c = Class.forName("com.springbootdemo.byb.TestCache");
		Method ac=c.getMethod("createValue",Object.class);
			System.out.println(ac);

	}
}

//test111111
class TestCache extends SoftRefCache{

	@Override
	protected Object createValue(Object key) {
		System.out.println("内存被回收，创建新对象加入缓存");
		byte[] bytes = new byte[1024*1024*300];  //100M
		return bytes;
	}
}
