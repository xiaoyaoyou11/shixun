import com.guimei.zxj.dao.UserDao;
import com.guimei.zxj.dao.impl.UserDaoImpl;
import com.guimei.zxj.pojo.User;
import org.junit.jupiter.api.Test;


public class UserDaoTest {
    private UserDao userDao=new UserDaoImpl();
    @Test
    public void insertUser(){
        User user=new User();
        user.setUsername("李达");
        user.setMima("2435345");
        userDao.insertUser(user);

    }
    @Test
    public void getUser(){
        String userName="李达";
        User user=userDao.getUser(userName);
        System.out.println(user);

    }
}
