package questionaire_core;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaque.wwq.mapper.UserMapper;
import com.adaque.wwq.po.User;

public class TestUserMapper {
	
	private ApplicationContext applicationContext;
	
	@Before
	public void setUp() {
		applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext-dao.xml");
	}
	
	@Test
	public void testFindUserById() {
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.getUserById(4);
		System.out.println(user);
	}
	
}
