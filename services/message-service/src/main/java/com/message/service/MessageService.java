package com.message.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public String printMessage() {

        List<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("Olá");
        messages.add("Hola");
        messages.add("Aloha");
        messages.add("Allons-y");

        Random random = new Random();
        int randomIndex = random.nextInt(messages.size());
        String randomMessage = messages.get(randomIndex);

        return randomMessage;
    }
}
