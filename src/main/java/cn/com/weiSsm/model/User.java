package cn.com.weiSsm.model;

import cn.com.weiSsm.base.DataEntity;

public class User extends DataEntity<User> {

    private String id;

    private String userName;

    private String userPwd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }
}