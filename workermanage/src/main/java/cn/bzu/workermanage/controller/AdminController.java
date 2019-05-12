package cn.bzu.workermanage.controller;

import cn.bzu.adminprovider.service.AdminService;
import cn.bzu.workermanage.pojo.Admin;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class AdminController {

    @Reference
    AdminService adminService;

    @GetMapping("/test")
    public String testLink(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("Admin");
        return admin != null ? "ok" : "no";
    }

    @PostMapping("/admin")
    public String adminLogin(@RequestBody Admin admin, HttpServletRequest request) {
        System.out.println(admin.getAdminName());
        if (adminService.adminLogin(admin.getAdminName(), admin.getAdminPass())){
            HttpSession session = request.getSession();
            session.setAttribute("Admin",admin);
            return "ok";
        }
        else
            return "no";
    }

    @PostMapping("/email")
    public String getPass(@RequestBody Admin admin) {
        System.out.println(admin.getAdminName());
        if (adminService.getPass(admin.getAdminName(), admin.getAdminEmail()))
            return "ok";
        else
            return "no";
    }


}
