package org.example.createAndDestroyObjects;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> nameDictionary1 = Arrays.asList("John", "Michael", "David", "Sarah", "Emma", "James", "Emily", "William", "Olivia", "Sophia", "Zoro");
        List<String> nameDictionary2 = Arrays.asList("Jack", "Steve", "Timon", "Ahmad", "Jad", "Tem", "Jack", "Samer", "Asad", "Marly", "Jimmy", "Naruto", "Lufi", "Ace", "Brad");
        Team team1 = new Team(nameDictionary1);
        Team team2 = new Team(nameDictionary2);
        Team.createTeamWithFormation(nameDictionary1, 1, 2,4,4);

        // Write team1's data to a file
        System.out.println(team1);
        System.out.println(team2);

    }
}

