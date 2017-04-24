package cn.com.weiSsm.dao;

import cn.com.weiSsm.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weihh on 2017/4/20.
 */
@Repository
public interface UserDao {
    List<User> selectAllUser();
    User get(String userName);
}
