package cn.com.weiSsm.dao;

import cn.com.weiSsm.base.CrudDao;
import cn.com.weiSsm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weihh on 2017/4/20.
 */
@Repository
public interface UserDao extends CrudDao<User> {
    List<User> selectAllUser();
    User get(String userName);
    int insert(User user);
}
