package com.pascal.two;


import java.util.Scanner;
import java.util.regex.*;

public class Main {
    private static StringBuilder errors = new StringBuilder();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Register Employee");
        System.out.println("------------------");
        setFirstName();
        setLastName();
        setZipCode();
        setEmployeeId();
        displayUserInput();
    }
    private static void setFirstName(){
        System.out.print("Enter the first name: ");
        String firstName = userInput.nextLine();
        if (firstName.isEmpty()) {
            setErrors("The first name must be filled in.");
        }else{
            if ((firstName.length() == 1)){
                setErrors("The first and last names must be at least two characters long.");
            }
        }
    }
    private static void setLastName(){
        System.out.print("Enter the last name: ");
        String lastName = userInput.nextLine();
        if (lastName.isEmpty()) {
            setErrors("The last name must be filled in.");
        }else{
            if ((lastName.length() == 1)){
                setErrors("The first and last names must be at least two characters long.");
            }
        }
    }
    private static void setEmployeeId(){
        System.out.print("Enter an employee ID: ");
        String employeeId = userInput.nextLine();
        if (employeeId.isEmpty()){
            setErrors("An employee ID is in the format AA-1234. So, two letters, a hyphen, and four numbers.");
        }else{
            if (!Pattern.matches("[A-Z]{2}[-]\\d{3}", employeeId)){
                String error = employeeId + " is not a valid ID";
                setErrors(error);
            }
        }
    }
    private static void setZipCode(){
        System.out.print("Enter the ZIP code: ");
        String zipCode = userInput.nextLine();
        if (zipCode.isEmpty()){
            setErrors("The ZIP code must be a number.");
        }else{
            if (!isNumeric(zipCode)){
                setErrors("The ZIP code must be a number.");
            }
        }
    }

    private static boolean isNumeric(String strNum) {
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    private static void setErrors(String errors) {
        Main.errors.append(errors);
        Main.errors.append("\n");
    }

    private static StringBuilder getErrors() {
        return Main.errors;
    }
    private static void displayUserInput(){
        if (Main.errors.toString().isEmpty()){
            System.out.println("There were no errors found.");
        }else{
            System.out.println(getErrors().toString());
        }
    }
}
