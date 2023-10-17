package com.hello.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    private RestTemplate messageRestTemplate;
    private RestTemplate nameRestTemplate;
    private final String messageServiceHost;
    private final String messageServicePort;
    private final String nameServiceHost;
    private final String nameServicePort;

    public HelloService(@Value("${service.messageHost}") String messageServiceHost,
                        @Value("${service.messagePort}") String messageServicePort,
                        @Value("${service.nameHost}") String nameServiceHost,
                        @Value("${service.namePort}") String nameServicePort,
                        @Qualifier("messageRestTemplate") RestTemplate messageRestTemplate,
                        @Qualifier("nameRestTemplate") RestTemplate nameRestTemplate) {
        this.messageServiceHost = messageServiceHost;
        this.messageServicePort = messageServicePort;
        this.nameServiceHost = nameServiceHost;
        this.nameServicePort = nameServicePort;
        this.messageRestTemplate = messageRestTemplate;
        this.nameRestTemplate = nameRestTemplate;
    }
    
    public String printHello() {
        String result;
        String msgStr;
        String nameStr;
        String messageUrl = "http://" + messageServiceHost + ":" + messageServicePort + "/message";
        String nameUrl = "http://" + nameServiceHost + ":" + nameServicePort + "/name";

        msgStr = messageRestTemplate.getForObject(messageUrl, String.class);
        nameStr = nameRestTemplate.getForObject(nameUrl, String.class);
        
        result = msgStr + ", " + nameStr;
        return result;
    }


}
