package cn.bzu.workermanage.service;

import cn.bzu.workermanage.pojo.EmpInput;
import cn.bzu.workermanage.pojo.Msg;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    @RabbitListener(queues = {"qst.news"})
    public void receive(EmpInput empInput){
        System.out.println("收到消息"+empInput.toString());
        Msg msg = restTemplate.postForObject("http://EMPLOYEE-PROVIDER/emp",empInput, Msg.class);
    }
}
