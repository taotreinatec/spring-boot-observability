package com.greetings.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingsService {
    private RestTemplate helloRestTemplate;
    private final String helloServiceHost;
    private final String helloServicePort;
    private RestTemplate fortuneRestTemplate;
    private final String fortuneServiceHost;
    private final String fortuneServicePort;

    public GreetingsService(@Value("${service.helloHost}") String helloServiceHost,
                            @Value("${service.helloPort}") String helloServicePort,
                            @Value("${service.fortuneHost}") String fortuneServiceHost,
                            @Value("${service.fortunePort}") String fortuneServicePort,
                            @Qualifier("helloRestTemplate") RestTemplate helloRestTemplate,
                            @Qualifier("fortuneRestTemplate") RestTemplate fortuneRestTemplate) {
        this.helloServiceHost = helloServiceHost;
        this.helloServicePort = helloServicePort;
        this.helloRestTemplate = helloRestTemplate;
        this.fortuneServiceHost = fortuneServiceHost;
        this.fortuneServicePort = fortuneServicePort;
        this.fortuneRestTemplate = fortuneRestTemplate;
    }

    public String printHello() {
        String result;
        String url = "http://" + helloServiceHost + ":" + helloServicePort + "/hello";

        result = helloRestTemplate.getForObject(url, String.class);

        return result;
    }

    public String printFortune() {
        String result;
        String url = "http://" + fortuneServiceHost + ":" + fortuneServicePort + "/fortune";

        result = fortuneRestTemplate.getForObject(url, String.class);

        return result;
    }
}
