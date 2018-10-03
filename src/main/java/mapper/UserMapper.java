package mapper;

import bean.QueryVo;
import bean.User;

import java.util.List;

/**
 * @author sairo
 * @since 2018/10/3 15:19
 */
public interface UserMapper {
    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    List<User> queryUserByUserName(String username);

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 通过包装类查询用户
     * @param queryVo
     * @return
     */
    List<User> queryUserByQueryVo(QueryVo queryVo);

}
