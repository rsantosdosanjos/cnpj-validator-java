package com.example.alphanumericvalidator.helpers;

public class CNPJChecker {
    private static final int CNPJ_BASE_LENGTH = 12;
    private static final String FORMATTING_CHARACTERS_REGEX = "[./-]";
    private static final String CNPJ_BASE_PATTERN = "[A-Z\\d]{12}";
    private static final String DV_PATTERN = "\\d{2}";
    private static final String ALL_ZEROES_REGEX = "^[0]+$";
    private static final int CHAR_TO_INT_OFFSET = (int) '0';
    private static final int[] WEIGHTS_FOR_DV = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

    // Method to verify if the provided CNPJ is valid
    public static boolean validate(String cnpj) {
        if (cnpj != null) {
            cnpj = stripFormatting(cnpj);
            if (hasValidCNPJStructureWithDV(cnpj)) {
                String providedDV = cnpj.substring(CNPJ_BASE_LENGTH);
                String calculatedDV = generateDV(cnpj.substring(0, CNPJ_BASE_LENGTH));
                return calculatedDV.equals(providedDV);
            }
        }
        return false;
    }

    // Method to generate the verification digits (DV)
    public static String generateDV(String baseCNPJ) {
        if (baseCNPJ != null) {
            baseCNPJ = stripFormatting(baseCNPJ);
            if (hasValidCNPJStructureWithoutDV(baseCNPJ)) {
                String firstDV = String.valueOf(calculateSingleDigit(baseCNPJ));
                String secondDV = String.valueOf(calculateSingleDigit(baseCNPJ + firstDV));
                return firstDV + secondDV;
            }
        }
        throw new IllegalArgumentException(String.format("CNPJ %s is invalid for DV generation", baseCNPJ));
    }

    // Private method to calculate a single verification digit
    private static int calculateSingleDigit(String cnpj) {
        int sum = 0;
        for (int i = cnpj.length() - 1; i >= 0; i--) {
            int charValue = cnpj.charAt(i) - CHAR_TO_INT_OFFSET;
            sum += charValue * WEIGHTS_FOR_DV[WEIGHTS_FOR_DV.length - cnpj.length() + i];
        }
        int remainder = sum % 11;
        return remainder < 2 ? 0 : 11 - remainder;
    }

    // Removes formatting characters such as dots, slashes, and dashes
    private static String stripFormatting(String cnpj) {
        return cnpj.trim().replaceAll(FORMATTING_CHARACTERS_REGEX, "");
    }

    // Checks if the base CNPJ (without DV) has a valid structure
    private static boolean hasValidCNPJStructureWithoutDV(String cnpj) {
        return cnpj.matches(CNPJ_BASE_PATTERN) && !cnpj.matches(ALL_ZEROES_REGEX);
    }

    // Checks if the full CNPJ (with DV) has a valid structure
    private static boolean hasValidCNPJStructureWithDV(String cnpj) {
        return cnpj.matches(CNPJ_BASE_PATTERN + DV_PATTERN) && !cnpj.matches(ALL_ZEROES_REGEX);
    }
}
