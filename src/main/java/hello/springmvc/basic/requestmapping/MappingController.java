package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value={"/hello-basic","/hello-go"}, method = RequestMethod.GET)
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    /**
     *
     * @return
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
        log.info("mapping path userId={}",userId);

        return "ok";
    }

    @GetMapping(value="/mapping-param", params = "mode=debug")
    public String mappingParam(){

        return "ok";
    }

    @PostMapping(value="/mapping-consumes", consumes= "application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");

        return "ok";
    }

    //요청헤더 Accept의 요청에 따라 응답으로 만들어 줌
    @PostMapping(value="mapping-produces" , produces = "text/html")
    public String mappingProduces(){
        log.info(mappingProduces());

        return "ok";
    }

}
