package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static String[] arr;

    public static void main(String[] args) throws FileNotFoundException {


        //Gets random word from the dictionary
        Random rand = new Random();
        String[] arr = getWords();

        System.out.println("Welcome to hangman!");

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("What mode do you wish to play in?");
            System.out.println("(1) - Computer mode - the word will be picked at random from the games dictionary file ");
            System.out.println("(2) - Player mode - you can provide the word! Given that its a legitimate English word, you can chose your search method for it as well! ");
            System.out.println("(3) - About, more about the program creator");
            System.out.println("(4) - Exit, if you arent in the main menu type 'quit!' with an exclamation point to quit anytime ");

            int mode = scan.nextInt();

            switch (mode) {
                case 1:
                    System.out.println("Computer mode! Lets start");
                    HangManGame obj = new HangManGame();
                    int rando = rand.nextInt(370100);
                    String guessWord = arr[rando];
                    obj.startGame(guessWord);
                    break;
                case 2:
                    System.out.println("Player mode! Lets start");
                    System.out.println("What method would you like to use to search for your word:");
                    System.out.println("1. Brute Force");
                    System.out.println("2. Binary Search Tree");
                    System.out.println("3. Decrease by a Constant Factor ");
                    int searchMode = scan.nextInt();
                    switch(searchMode){
                        case 1:
                            System.out.println("You chose Brute Force!");
                            System.out.println("Enter the word you'd like to enter: ");
                            Scanner scan2 = new Scanner(System.in);
                            String userWord = scan2.nextLine();
                            if(BruteForce.bruteForce(userWord,arr)){
                                HangManGame obj2 = new HangManGame();
                                obj2.startGame(userWord);
                            }else{
                                System.out.println("Lets autocorrect that!");
                                String autoCorrectedBrute = BruteForce.bruteAutoCorrect(userWord, arr);
                                System.out.println("Your autocorrected suggested via brute force is: " + autoCorrectedBrute);
                                HangManGame obj3 = new HangManGame();
                                obj3.startGame(autoCorrectedBrute);
                            }
                            break;
                        case 2:
                            System.out.println("You chose Binary Search Tree!");
                            System.out.println("The dictionary was created into a tree!");
                            BinarySearchTree bst = new BinarySearchTree();
                            bst.buildTree(arr);
                            Scanner scan3 = new Scanner(System.in);
                            System.out.println("Enter the word you'd like to enter: ");
                            String userWord2 = scan3.nextLine();
                            String bstResult = bst.search(userWord2);
                            HangManGame obj5 = new HangManGame();
                            obj5.startGame(bstResult);
                            System.out.println();
                            break;
                        case 3:
                            System.out.println("You chose Decrease by a Constant Factor!");
                            System.out.println("Enter the word you'd like to enter: ");
                            Scanner scan4 = new Scanner(System.in);
                            String userWord3 = scan4.nextLine();
                            String dcfResult = DCF.decreaseConstantFactor(userWord3, 0, arr.length-1, arr);
                            HangManGame obj4 = new HangManGame();
                            obj4.startGame(dcfResult);
                            break;
                    }
                    break;
                case 3:
                    System.out.println("About section:");
                    System.out.println();
                    System.out.println("Game maker: Jason Rosales");
                    System.out.println("Professor: Dr. Rusu");
                    System.out.println("Class: CPSC3343");
                    System.out.println("Date of Game Completion: December 20 2022");
                    System.out.println("More info: The purpose of program is to combine a fun game and the concepts learned in Design and Analysis of Algorithms!");
                    System.out.println();
                    break;
                case 4:
                    System.exit(0);
                    break;
            }

        }

    }

    public static String[] getWords() throws FileNotFoundException {
        Scanner scann = new Scanner(new FileReader("Dictionary/words.txt"));
        int i = 0;
        arr = new String[370099];
        while (scann.hasNextLine()) {
            arr[i++] = scann.nextLine();
        }
        return arr;
    }

}
