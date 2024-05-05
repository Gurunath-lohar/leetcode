package com.guru.concepts.greedy;

public class GreedyAlgorithmExample {

public static int[] coins = {1, 5, 10, 25};
    
    public static void main(String[] args) {
        int amount = 37;
        int[] result = makeChange(amount);
        System.out.println("Minimum number of coins needed to make change for " + amount + " is " + result[0]);
        System.out.println("The coins used are: ");
        for (int i = 1; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
    
    public static int[] makeChange(int amount) {
        int[] coinCount = new int[coins.length];
        int totalCoins = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                coinCount[i]++;
                totalCoins++;
            }
        }
        int[] result = new int[totalCoins + 1];
        result[0] = totalCoins;
        int j = 1;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (coinCount[i] > 0) {
                result[j++] = coins[i];
                coinCount[i]--;
            }
        }
        return result;
    }
    
}
