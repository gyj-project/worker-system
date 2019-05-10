package cn.bzu.adminprovider.service;

import cn.bzu.workermanage.pojo.Admin;
import cn.bzu.workermanage.pojo.User;

public interface AdminService {
    public boolean adminLogin(String name, String pass);

    public String testLink();

    public String testUser(User user);

    public boolean getPass(String name, String email);
}
