package cn.bzu.jobprovider.dao;


import cn.bzu.jobprovider.pojo.JobUpdate;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 津少
 * @since 2019-05-06
 */
@Mapper
public interface JobUpdateMapper extends BaseMapper<JobUpdate> {
   public List<JobUpdate> selectJobUpdate();

}
