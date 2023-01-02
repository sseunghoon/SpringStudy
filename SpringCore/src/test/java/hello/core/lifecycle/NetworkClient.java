package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자를 호출합니다" + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("Connect to : " + url);
    }

    public void call(String msg) {
        System.out.println("Call to :" + url + ", " + msg);
    }

    public void disconnect() {
        System.out.println("Close : " + url);
    }

    @PostConstruct
    public void init() {
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
         disconnect();
    }


}
