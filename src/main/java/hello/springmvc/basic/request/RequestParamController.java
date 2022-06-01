package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {


    @RequestMapping("/request-param-v1")
    public void requerstParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username = {}" , username);

        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requerstParamV4( String userName,int age ) throws IOException {
        log.info("username={}, age={}" , userName,age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requerstParamMap(@RequestParam Map<String,Object> paramMap) throws IOException {
        log.info("username={}, age={}",paramMap.get("username"),paramMap.get("age"));

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")//타입이 다르게 들어갈 경우 binding오류가 난다
    public String modelAttributeV1(@ModelAttribute HelloData helloData){

        return "";
    }
}
