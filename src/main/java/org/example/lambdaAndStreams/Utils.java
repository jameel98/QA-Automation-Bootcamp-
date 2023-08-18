package org.example.lambdaAndStreams;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class Utils {
    static List<String> names = Arrays.asList("John", "Michael", "David", "Sarah", "Emma", "James", "Emily", "William", "Olivia", "Sophia", "Zoro");
    public static Date generateRandomDate() {
     //   long startDate = new Date(2023,1,1).getTime();
        long today = new Date().getTime();
        return new Date((today + ThreadLocalRandom.current().nextInt()));

//        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
//        long randomNumberOfDays = ThreadLocalRandom.current().nextLong(daysBetween + 1);
//        LocalDate randomDate = startDate.plusDays(randomNumberOfDays);
//        return randomDate;

    }

    public static Type generateRandomType(){
        Random random = new Random();
        Type type = Type.values()[random.nextInt(Type.values().length)];
        return type;
    }
    public static String generateRandomName() {
        return names.get(ThreadLocalRandom.current().nextInt(names.size()));
    }

    public static double generateRandomWeight() {
        return ThreadLocalRandom.current().nextDouble(100);
    }
}
