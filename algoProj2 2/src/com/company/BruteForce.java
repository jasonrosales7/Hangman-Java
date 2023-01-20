package com.company;

public class BruteForce {


    public static boolean bruteForce(String guess, String[] arr){
        int count = 0;
        boolean found = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals(guess)) {
                System.out.println("Your word was found!");
                found = true;
                break;
            }
            count = count + 1;
        }
        System.out.println("Attempts taken to find that word via brute force: " + count);

        if(!found){
            System.out.println("That is not a word");
        }
        return found;

    }

    public static String bruteAutoCorrect(String nonexistingWord, String[] arr){
        String closestMatch = arr[0];
        int highestMatchCount = 0;
        for (String option : arr) {
            int matchCount = 0;

            //longer vs shorter to avoid out of bounds error
            if(option.length() > nonexistingWord.length()){
                for (int i = 0; i < nonexistingWord.length(); i++) {
                    if (nonexistingWord.charAt(i) == option.charAt(i)) {
                        matchCount++;
                    }
                }
            }else if(option.length() < nonexistingWord.length()){
                for (int i = 0; i < option.length(); i++) {
                    if (nonexistingWord.charAt(i) == option.charAt(i)) {
                        matchCount++;
                    }
                }
            }

            if (matchCount > highestMatchCount) {
                closestMatch = option;
                highestMatchCount = matchCount;
            }
        }

        return closestMatch;
    }

}
