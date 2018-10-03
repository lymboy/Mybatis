import bean.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @author sairo
 * @since 2018/10/2 20:30
 */
public class Demo02 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object user = sqlSession.selectOne("queryUserById", 1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
    public void test02() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Object one = sqlSession.selectList("queryUserByUserName", "%T%");
        System.out.println(one);

        sqlSession.close();
    }

    @Test
    public void test03() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("Leon");
        user.setBirthday(new Date());
        user.setSex("woman");
        sqlSession.insert("saveUser", user);

        System.out.println(user);

        sqlSession.commit();
        sqlSession.close();
    }
}
