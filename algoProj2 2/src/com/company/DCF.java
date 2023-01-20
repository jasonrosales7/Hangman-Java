package com.company;

public class DCF {

    public static String decreaseConstantFactor(String userWord, int low, int high, String[] arr){
        int mid = 0;
        int count = 0;
        while(low <= high){
            mid = (low+high)/2;
            int wordCheck = arr[mid].compareTo(userWord);
            if(wordCheck == 0){
                System.out.println("Word Found!");
                System.out.println("Splits needed to find word: " + count);
                return arr[mid];
            }else if(wordCheck < 0){
                low = mid +1;
            }else if(wordCheck > 0){
                high = mid-1;
            }
            count++;
        }
        System.out.println("Word not found!");
        System.out.println("Word entered was autocorrected to: " + arr[mid-1]);
        return arr[mid-1];
    }
}
