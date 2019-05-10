package cn.bzu.adminprovider.service;


import cn.bzu.adminprovider.pojo.Admin;
import cn.bzu.adminprovider.pojo.User;
import com.baomidou.mybatisplus.service.IService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 津少
 * @since 2019-04-28
 */
public interface AdminService {

    public String testLink();

    public boolean adminLogin(String name, String pass);

    public String testUser(User user);

    public boolean getPass(String name, String email);


}
