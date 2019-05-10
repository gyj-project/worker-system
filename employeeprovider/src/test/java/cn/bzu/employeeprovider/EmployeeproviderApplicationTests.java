package cn.bzu.employeeprovider;

import cn.bzu.employeeprovider.dao.EmployeeMapper;
import cn.bzu.employeeprovider.dao.JobMapper;
import cn.bzu.employeeprovider.pojo.Employee;
import cn.bzu.employeeprovider.service.JobService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.Before;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeproviderApplicationTests {
//
//    @Autowired
//    private EmployeeMapper employeeMapper;
//    @Autowired
//    private JobMapper jobMapper;
//    @Autowired
//    private JobService jobService;
//
//    private MockMvc mockMvc;
//    @Autowired
//    WebApplicationContext context;
//
//
//
//    @Before
//    public void initMockMvc() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
//    }
//
//
//
//
//    @Test
//    public void contextLoads() {
//    }
//    @Test
//    public void insertData() throws ParseException {
//        for(int i = 0; i < 1000; i++) {
//			String s = UUID.randomUUID().toString().substring(0, 5) + i;
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//            String enpIn= "2015-06-08";
//            String birth= "1997-05-02";
//            Date date1 = sdf.parse(enpIn);
//            Date date2 = sdf.parse(birth);
//            employeeMapper.insert(new Employee(null, s, s + "@qq.com", "M", date1,date2,1,1,3000.0,1,0));
////			xml.insertSelective(new Employee(null, s, "M", s + "@qq.com", 1));
//		}
//
//
//    }
//
//
//    @Test
//    public void testMapper(){
//        List<String> strings = jobService.getJobNamesByDeptName("开发部");
//        for (String s: strings)
//            System.out.println(s);
//    }
}
