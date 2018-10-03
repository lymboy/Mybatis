package bean;

import java.util.Date;

/**
 * @author sairo
 * @since 2018/10/3 17:42
 */
public class Order {
    // 订单id
    private int     id;
    // 用户id
    private Integer userId;
    // 订单号
    private String  number;
    // 创建日期
    private Date    createtime;
    // 备注
    private String  note;
    // 关联用户
    private User    user;

}
