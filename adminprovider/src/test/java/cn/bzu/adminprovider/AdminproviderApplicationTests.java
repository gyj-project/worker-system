package cn.bzu.adminprovider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminproviderApplicationTests {
    @Autowired
    JavaMailSender mailSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMail() throws MessagingException {
       /*SimpleMailMessage message = new SimpleMailMessage();
       message.setSubject("通知-今晚行动");
       message.setText("今晚小树林集合~");

       message.setTo("1605522570@qq.com");
       message.setFrom("1807069286@qq.com");

       mailSender.send(message);*/

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setSubject("紧急通知");
        helper.setText("<b style='color:red'> 今晚小树林集合~</b>", true);

        helper.setTo("1605522570@qq.com");
        helper.setFrom("1807069286@qq.com");

        helper.addAttachment("qq邮箱密码", new File("C:\\Users\\Shinelon\\Desktop\\乱七八糟\\qq邮箱.txt"));
        mailSender.send(mimeMessage);


    }
}
