package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.text.html.parser.Parser;

public class BeanLifeCycleTest {

    @Test
    public void lifecycleTest() {
        // ApplicationContext 에는 close가 없어서
        // ConfigurableApplicationContext 나 AnnotationConfigApplicationContext를 사용해야 함
        // AnnotationConfig~~~ 가 ConfigurableApplicationContext를 상속하고 Config~~ 는 ApplicationContext를 상속

//        ApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient bean = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig {

        // 앱 시작과 동시에 스프링 빈으로 등록이 된다.  -> return 되는 결과물이
        // 빈의 이름은 networkClient
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient( );
            networkClient.setUrl("www.naver.com");
            return networkClient;

        }


    }

}
