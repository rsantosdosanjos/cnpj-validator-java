
# Alphanumeric CNPJ Validator

This is a Java console application that validates and calculates the verification digits (DV) for alphanumeric CNPJ numbers. The CNPJ consists of 12 alphanumeric characters followed by 2 numeric verification digits.

## Features

- Validate alphanumeric CNPJ (12 alphanumeric characters + 2 verification digits)
- Calculate the verification digits (DVs) for a CNPJ base (without the DVs)

## Prerequisites

- Java JDK 8 or higher

## How to Run

1. Clone the repository or download the project files.
2. Open a terminal in the project folder.
3. Compile the project using the following command:
    ```bash
    javac AlphanumericvalidatorApplication.java CNPJChecker.java
    ```
4. Run the application using:
    ```bash
    java AlphanumericvalidatorApplication
    ```

## Example Usage

The application works as follows:

1. **Validate a CNPJ**: Check whether a given CNPJ is valid based on its alphanumeric structure and verification digits.
2. **Calculate Verification Digits**: For a CNPJ base (12 characters), calculate and append the correct verification digits.

### Example Input/Output

#### Validating a CNPJ:

For a valid CNPJ:

```bash
Validating CNPJ: 12ABC34501DE35
Is the CNPJ valid? true
```

For an invalid CNPJ:

```bash
Validating CNPJ: 12ABC34501DE99
Is the CNPJ valid? false
```

#### Calculating the Verification Digits (DV):

```bash
Calculating DV for base CNPJ: 12ABC34501DE
Calculated DV: 35
Complete CNPJ with DV: 12ABC34501DE35
```

## Code Structure

- `CNPJChecker.java`: Contains the core logic for validating and calculating CNPJ verification digits.
- `AlphanumericvalidatorApplication.java`: The main entry point of the application, which demonstrates how to use the validation and DV calculation functions.
- `README.md`: Instructions for using the project.