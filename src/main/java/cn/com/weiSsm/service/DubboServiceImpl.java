package cn.com.weiSsm.service;

import org.springframework.stereotype.Service;

/**
 * Created by t420 on 2017/5/10.
 */
@Service("dubboService")
public class DubboServiceImpl implements DubboService {

    @Override
    public String dubbos(String user) {
        return "hello world:"+user;
    }
}
