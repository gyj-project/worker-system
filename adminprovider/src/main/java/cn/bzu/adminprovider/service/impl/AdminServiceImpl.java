package cn.bzu.adminprovider.service.impl;


import cn.bzu.adminprovider.dao.AdminDao;
import cn.bzu.adminprovider.pojo.Admin;
import cn.bzu.adminprovider.pojo.User;
import cn.bzu.adminprovider.service.AdminService;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 津少
 * @since 2019-04-28
 */
@Component
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AdminDao adminDao;

    @Override
    public boolean getPass(String name, String email) {

        Admin admin = adminDao.getAdminByEmail(name, email);
        if (admin != null) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        MimeMessage mimeMessage = mailSender.createMimeMessage();
                        MimeMessageHelper helper = null;

                        helper = new MimeMessageHelper(mimeMessage, true);

                        helper.setSubject("密码找回");
                        helper.setText("尊敬的"+admin.getAdminName()+",你的密码是：<b style='color:red'>" + admin.getAdminPass() + "</b>", true);

                        helper.setTo(email);
                        helper.setFrom("1807069286@qq.com");

                        helper.addAttachment("qq邮箱密码", new File("C:\\Users\\Shinelon\\Desktop\\乱七八糟\\qq邮箱.txt"));
                        mailSender.send(mimeMessage);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        return admin != null;

    }

    @Override
    public boolean adminLogin( String name, String pass) {

        Admin admin = adminDao.getAdmin(name, pass);

        return admin != null;
    }


    public String testUser(@RequestBody User user) {
        System.out.println(user.getName());
        return "good";
    }

    @Override
    public String testLink() {

        new Thread(new Runnable() {
            public void run() {
                try {
                    MimeMessage mimeMessage = mailSender.createMimeMessage();
                    MimeMessageHelper helper = null;

                    helper = new MimeMessageHelper(mimeMessage, true);

                    helper.setSubject("紧急通知");
                    helper.setText("<b style='color:red'> 今晚小树林集合~</b>", true);

                    helper.setTo("1605522570@qq.com");
                    helper.setFrom("1807069286@qq.com");

                    helper.addAttachment("qq邮箱密码", new File("C:\\Users\\Shinelon\\Desktop\\乱七八糟\\qq邮箱.txt"));
                    mailSender.send(mimeMessage);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        return "hello world";
    }
}
