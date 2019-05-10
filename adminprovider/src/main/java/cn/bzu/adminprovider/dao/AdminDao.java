package cn.bzu.adminprovider.dao;

import cn.bzu.adminprovider.pojo.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 津少
 * @since 2019-04-28
 */
@Mapper
public interface AdminDao extends BaseMapper<Admin> {

    @Select("select * from admin where admin_name = #{adminName} and admin_pass = #{adminPass}")
    public Admin getAdmin(@Param("adminName") String name, @Param("adminPass") String pass);

    @Select("select * from admin where admin_name = #{adminName} and admin_email = #{adminEmail}")
    public Admin getAdminByEmail(@Param("adminName") String name, @Param("adminEmail") String email);

}
