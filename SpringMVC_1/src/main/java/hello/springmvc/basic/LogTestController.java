package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());


    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.debug("debug = {}", name);
        log.trace("trace = {}", name);
        log.info("info = {}", name);
        log.warn("warn = {}", name);
        log.error("error = {}", name);
        return "ok";
    }
}
