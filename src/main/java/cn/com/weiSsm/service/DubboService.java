package cn.com.weiSsm.service;

import cn.com.weiSsm.dao.DubboDao;
import org.springframework.stereotype.Service;


/**
 * Created by t420 on 2017/5/10.
 */

@Service("DubboDao")
public class DubboService implements DubboDao {
    public String dubbos() {
        return "hello";
    }
}
