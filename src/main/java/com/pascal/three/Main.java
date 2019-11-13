package com.pascal.three;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static StringBuilder info = new StringBuilder();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void setSiteName(){
        System.out.println("Site name: ");
        String siteName = userInput.nextLine();
    }
    public static void setAuthorName(){
        System.out.println("Author: ");
        userInput.nextLine();

    }
    public static void createFolder(String folderName){
        String path = "C:\\Project\\codingtestforpascalkkndes\\src\\main\\resources\\"+folderName;
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) {
                generateIndex(folderName);
                System.out.println("Created!");
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }
    private static void generateIndex(String folderName){
        String path = folderName+"\\"+ "index.html";
        String content = "<meta charset=\"utf-8\"><title>\n"+ "index.html" +"</title>";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void setInfo(String message) {
        Main.info.append(message);
        Main.info.append("\n");
    }
    private static void otherFolder(String folderName){
        System.out.println("Do you want a folder for JavaScript?");
        if (userInput.nextLine().equalsIgnoreCase("y")){

        }
        System.out.println("Do you want a folder for CSS?");
        if (userInput.nextLine().equalsIgnoreCase("y")){

        }
    }
}
