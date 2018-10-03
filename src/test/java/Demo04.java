import bean.QueryVo;
import bean.User;
import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author sairo
 * @since 2018/10/3 15:49
 */
public class Demo04 {
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

        User user = new User();
        user.setUsername("t");
        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> userList = mapper.queryUserByQueryVo(queryVo);

        for (User u : userList) {
            System.out.println(u);
        }
        sqlSession.close();
    }

}
