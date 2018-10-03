import bean.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sairo
 * @since 2018/10/3 15:28
 */
public class Demo03 {

    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void init() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test01() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);

        System.out.println(user);

        sqlSession.close();
    }

}
