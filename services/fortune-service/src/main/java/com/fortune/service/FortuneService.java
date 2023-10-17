package com.fortune.service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class FortuneService {
    public String printFortune() {

        List<String> fortunes = new ArrayList<>();
        fortunes.add("A thrilling opportunity will soon come your way. Seize it with confidence!");
        fortunes.add("Your kindness and generosity will lead to unexpected blessings.");
        fortunes.add("Good news is on the horizon. Keep your spirits high.");
        fortunes.add("A journey of a thousand miles begins with a single step. Start your journey today.");
        fortunes.add("You will find happiness in the small, everyday moments of life. Cherish them.");
        fortunes.add("Your creativity knows no bounds. Embrace your imagination and see where it takes you.");
        fortunes.add("In the near future, you will receive a pleasant surprise that will brighten your day.");
        fortunes.add("Your perseverance in the face of challenges will lead to great success.");
        fortunes.add("A new friendship will enter your life, bringing joy and laughter.");

        Random random = new Random();
        int randomIndex = random.nextInt(fortunes.size());
        String randomFortune = fortunes.get(randomIndex);

        return randomFortune;
    }
}
