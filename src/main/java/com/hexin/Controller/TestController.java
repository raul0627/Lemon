package com.hexin.Controller;

import com.hexin.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;
    @Value("${server.port}")
    private int port;

    @ResponseBody
    @RequestMapping("/madrid.do")
    public String madrid() {
        String res = "";
        try {
            res = testService.madrid();
            System.out.println("port: " + port);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return res;
    }
}
