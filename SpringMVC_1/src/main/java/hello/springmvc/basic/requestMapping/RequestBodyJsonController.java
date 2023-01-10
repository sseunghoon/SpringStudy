package hello.springmvc.basic.requestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
public class RequestBodyJsonController {

    private ObjectMapper objectMapper = new ObjectMapper();

    @ResponseBody
    @PostMapping("/request-body-json-v2")
    public String requestBodyJsonControllerV2(@RequestBody String messageBody) throws IOException {
        log.info("messageBody = {}", messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());

        return "ok";
    }

    @ResponseBody
    @PostMapping("/request-body-json-v3")
    public String requestBodyJsonControllerV3(@RequestBody HelloData helloData) throws IOException {
        log.info("username = {}, age = {}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
