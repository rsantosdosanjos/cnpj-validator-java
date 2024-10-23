package com.example.alphanumericvalidator;

import com.example.alphanumericvalidator.helpers.CNPJChecker;

public class AlphanumericvalidatorApplication {

	public static void main(String[] args) {
		System.out.println("CNPJ Alphanumeric Validator");

		// Exemplo 1: Validar um CNPJ válido
		String validCnpj = "12ABC34501DE35";
		System.out.println("Validating CNPJ: " + validCnpj);
		boolean isValid = CNPJChecker.validate(validCnpj);
		System.out.println("Is the CNPJ valid? " + isValid);

		// Exemplo 2: Validar um CNPJ inválido
		String invalidCnpj = "12ABC34501DE99";
		System.out.println("\nValidating CNPJ: " + invalidCnpj);
		isValid = CNPJChecker.validate(invalidCnpj);
		System.out.println("Is the CNPJ valid? " + isValid);

		// Exemplo 3: Calcular os dígitos verificadores de um CNPJ base
		String baseCnpj = "12ABC34501DE";
		System.out.println("\nCalculating DV for base CNPJ: " + baseCnpj);
		String calculatedDV = CNPJChecker.generateDV(baseCnpj);
		System.out.println("Calculated DV: " + calculatedDV);
		System.out.println("Complete CNPJ with DV: " + baseCnpj + calculatedDV);
	}
}
