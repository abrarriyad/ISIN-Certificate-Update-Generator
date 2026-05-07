package com.solvians.showcase;

import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    public static ThreadLocalRandom getRandomValue(){
        return ThreadLocalRandom.current();
    }

    public static String generateRandomString(String input, int length){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<length; i++){
            int randomIndex = getRandomValue().nextInt(input.length());
//            System.out.println(randomIndex);
            sb.append(input.charAt(randomIndex));
        }
        return sb.toString();

    }

    public static int calculateCheckDigit(String input){
            String num = convertLettersToNumbers(input);
            int sum = calculateSum(num);
            int reminder = sum%10;

            if(reminder ==0){
                return 0;
            }

            return 10 - reminder;
    }

    public static String convertLettersToNumbers(String input){
        StringBuilder output = new StringBuilder();

        for(char ch: input.toCharArray()){
            if(Character.isLetter(ch)){
                output.append(ch-'A'+10);
            } else {
                output.append(ch);
            }
        }

        return output.toString();
    }

    public static int calculateSum(String input){
            int sum =0;
            int length = input.length();

            for(int i=input.length()-1; i>=0; i--){
                char currentChar = input.charAt(i);
                int digit = Character.getNumericValue(currentChar);
                int position = length - i;

                if(position %2 ==1){
                    digit = digit*2;

                    if(digit >9){
                        digit = digit / 10 + digit % 10;
                    }
                }
                sum+=digit;
            }

            return sum;
    }

    public static double roundToTwoDecimals(double input){
        return Math.round(input*100.0)/100.0;
    }


}
