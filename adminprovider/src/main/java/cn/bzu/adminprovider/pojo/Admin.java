package cn.bzu.adminprovider.pojo;


import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 津少
 * @since 2019-04-28
 */
public class Admin implements Serializable {


    private Integer adminId;
    private String adminName;
    private String adminPass;
    private String adminEmail;


    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public void setAdminPass(String adminPass) {
        this.adminPass = adminPass;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }


//    protected Serializable pkVal() {
//        return this.adminId;
//    }


    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminPass, String adminEmail) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPass = adminPass;
        this.adminEmail = adminEmail;
    }
}
