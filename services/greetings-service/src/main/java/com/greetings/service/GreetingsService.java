package com.greetings.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingsService {
    private RestTemplate restTemplate;
    private final String helloServiceHost;
    private final String helloServicePort;

    public GreetingsService(@Value("${service.helloHost}") String helloServiceHost,
                            @Value("${service.helloPort}") String helloServicePort,
                            @Qualifier("helloRestTemplate") RestTemplate restTemplate) {
        this.helloServiceHost = helloServiceHost;
        this.helloServicePort = helloServicePort;
        this.restTemplate = restTemplate;
    }

    public String printHello() {
        String result;
        String url = "http://" + helloServiceHost + ":" + helloServicePort + "/hello";

        result = restTemplate.getForObject(url, String.class);

        return result;
    }
}
