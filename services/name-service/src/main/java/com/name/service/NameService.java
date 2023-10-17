package com.name.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    public String printName() {

        List<String> names = new ArrayList<>();
        names.add("Sarah");
        names.add("Alejandro");
        names.add("Wei");
        names.add("Fatima");
        names.add("Ivan");
        names.add("Yuki");
        names.add("Élise");
        names.add("Amani");
        names.add("Aarav");
        names.add("Sophia");

        Random random = new Random();
        int randomIndex = random.nextInt(names.size());
        String randomName = names.get(randomIndex);

        return randomName;
    }
}
