package com.solvians.showcase;

public class IsinGenerator {

    private static final String UPPER_CASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String generate(){
        String randomUpperCaseLetters = Utils.generateRandomString(UPPER_CASE_LETTERS,2);
        String randomAlphaNums = Utils.generateRandomString(ALPHANUMERIC_CHARS,9);

        StringBuilder sb = new StringBuilder();
        sb.append(randomUpperCaseLetters).append(randomAlphaNums);

//        System.out.println(sb);

        int checkDigit = Utils.calculateCheckDigit(sb.toString());

//        System.out.println(checkDigit);

        return sb.append(checkDigit).toString();
    }
}
