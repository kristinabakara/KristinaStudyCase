import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.kristina.web.dao.UserDao;
import com.kristina.web.model.User;
import com.kristina.web.util.DatabaseUtil;

import junit.framework.Assert;

public class Test {
	
	private static Connection connection;

    public Test() {
        connection = DatabaseUtil.getConnection();
    }
  
	
	static UserDao dao = new UserDao();
	

	@org.junit.Test
	public void test() {
		User user = new User();
		user.setFirstname("Edward");
		user.setLastname("Cullen");
		user.setUsername("edward");
		user.setPassword("vampire");
		dao.addUser(user);
		
		
	}
	
	@After
	public void update() {
		String username = "edward";
		User lala = dao.getUserByUsername(username);
		System.out.println("LALA ID update : " +lala.getUserid());
		User user = new User();
		user.setFirstname("Edward");
		user.setLastname("Cullen");
		user.setUsername("edward");
		user.setPassword("vampire1234");
		user.setUserid(lala.getUserid());
		dao.updateUser(user);
		
	}
	
	@AfterClass
	public static void delete() {
		String username = "edward";
		User lala = dao.getUserByUsername(username);
		System.out.println("LALA ID : " +lala.getUserid());
		dao.deleteUser(lala.getUserid());
	}

}
