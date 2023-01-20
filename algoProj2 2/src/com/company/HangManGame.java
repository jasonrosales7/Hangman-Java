package com.company;
import java.util.Scanner;
import java.util.ArrayList;

public class HangManGame {

    public void startGame(String word){

        System.out.println("Letters you have available:");
        String[] letterStrings = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> letter = new ArrayList<String>();
        for(int i = 0; i < letterStrings.length; i++){
            letter.add(letterStrings[i]);
        }

        System.out.println(letter);


        System.out.println("Lets start the game!");
        System.out.println("The computer chose: " + word + ", this line wont appear for actual games");

        int wordLength = word.length();
        String[] wordLetters = new String[wordLength];
        for(int i = 0; i < wordLetters.length; i++){
            String addLetter = "" + word.charAt(i);
            wordLetters[i] = addLetter;
        }
        String[] lettersGuessedArray = new String[wordLength];
        for(int i = 0; i < lettersGuessedArray.length; i++){
            lettersGuessedArray[i] = "False";
        }

        int errors = 0;
        boolean gameWon = checkWise(lettersGuessedArray);
        System.out.println("Word has this many letters: " + word.length());
        while(errors < 6 && gameWon != true){
            System.out.println();
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter guess: ");
            String guess = scan.nextLine();
            if(guess.equalsIgnoreCase("quit!")){
                System.exit(0);
            }
            boolean validGuess = false;
            for(int i = 0; i < letter.size(); i++){
                if(letter.get(i).equals(guess)){
                    validGuess = true;
                    break;
                }
            }
            if(validGuess == true){
                letter.remove(guess);
                System.out.println("Letters left after guess: " + letter);
                if(guess.equalsIgnoreCase("quit!")){
                    System.exit(0);
                }
                boolean isGuessInWord = checkGuess(wordLetters, lettersGuessedArray, guess);
                if(isGuessInWord == false){
                    errors += 1;
                }
                switch (errors) {
                    case 1 -> errorOneResult();
                    case 2 -> errorTwoResult();
                    case 3 -> errorThreeResult();
                    case 4 -> errorFourResult();
                    case 5 -> errorFiveResult();
                    case 6 -> errorSixResult();
                }
                System.out.println("Errors made: " + errors);
                checkWord(wordLetters, lettersGuessedArray);
                System.out.println();
                gameWon = checkWise(lettersGuessedArray);
                if( errors < 6 && gameWon != true){
                    System.out.println("Would you like to guess the full word? Y|N");
                    String makeGuess = scan.nextLine();
                    if(guess.equalsIgnoreCase("quit!")){
                        System.exit(0);
                    }
                    if(makeGuess.equalsIgnoreCase("Y")){
                        System.out.println("Enter your guess for the word: ");
                        String wildGuess = scan.nextLine();
                        if(wildGuess.equals(word)){
                            System.out.println("You guessed CORRECTLY!");
                            gameWon = true;
                            break;
                        }else{
                            System.out.println("That is not the word");
                        }
                    }else if(makeGuess.equals("N")){
                        continue;
                    }else{
                        continue;
                    }
                }
            }else{
                System.out.println("Invalid input or you guessed that letter already, try again");
            }
        }

        System.out.println();
        if(gameWon == true){
            System.out.println("You won the game!");
        }else if(gameWon == false || errors > 9){
            System.out.println("You lost the game");
        }
    }

    public static boolean checkWise(String[] boolArray){
        boolean wonGame = false;
        int lettersGuessedTotal = 0;
        int correctTotal = boolArray.length;

        for(int i = 0; i < boolArray.length; i++){
            if(boolArray[i].equals("True")){
                lettersGuessedTotal += 1;
            }
        }
        // False, True, False, True, True
        if(lettersGuessedTotal == correctTotal){
            wonGame = true;
        }
        return wonGame;
    }

    public static boolean checkGuess(String[] wordLetters, String[] boolArray, String guess){
        boolean guessCorrect = false;
        for(int i = 0; i < wordLetters.length; i++){
            if(wordLetters[i].equals(guess)){
                boolArray[i] = "True";
                guessCorrect = true;
            }
        }
        return guessCorrect;
    }

    public static void checkWord(String[] wordLetter, String[] boolArray){
        for(int i = 0; i < wordLetter.length; i++){
            if(boolArray[i].equals("False")){
                System.out.print("_");
            }else{
                System.out.print(wordLetter[i]);
            }
        }
    }


    //text images of hangman

    public void errorOneResult(){
        System.out.println("   —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |\n" +
                "    |\n" +
                "—-------\n");
    }

    public void errorTwoResult(){
        System.out.println("    —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |      |\n" +
                "    |\n" +
                "—-------\n");
    }

    public void errorThreeResult(){
        System.out.println("    —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |    / |\n" +
                "    |\n" +
                "—-------\n");
    }

    public void errorFourResult(){
        System.out.println("    —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |    / | \\\n" +
                "    |\n" +
                "—-------\n");
    }

    public void errorFiveResult(){
        System.out.println("    —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |    / | \\\n" +
                "    |     /\n" +
                "—-------\n");
    }

    public void errorSixResult(){
        System.out.println("    —-------\n" +
                "    |\t   |\n" +
                "    |      O\n" +
                "    |    / | \\\n" +
                "    |     / \\\n" +
                "—-------\n");
    }


}
