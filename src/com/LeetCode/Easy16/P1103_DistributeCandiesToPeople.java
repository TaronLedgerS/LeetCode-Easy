package com.LeetCode.Easy16;

public class P1103_DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }

}
