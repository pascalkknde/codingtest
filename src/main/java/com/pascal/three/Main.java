package com.pascal.three;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static StringBuilder info = new StringBuilder();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String folderName = setSiteName();
        setInfon(folderName);
        setAuthorName();
        createFolder(folderName);
        createIndexFile(folderName);
        otherFolder(folderName);
        System.out.println(getInfo().toString());
    }

    private static void setInfon(String name) {
        info.append(name);
        info.append('\n');
    }

    private static StringBuilder getInfo() {
        return info;
    }

    private static String setSiteName(){
        System.out.print("Site name: ");
        return userInput.nextLine();
    }
    private static void setAuthorName(){
        System.out.print("Author: ");
        userInput.nextLine();
    }
    private static void createFolder(String folderName){
        File file = new File(folderName);
        String name = "Created ./"+folderName;
        if (!file.exists()) {
            if (file.mkdir()) {
                setInfo(name);
            } else {
                System.out.println("Failed to create directory!");
            }
        }
    }
    private static void createIndexFile(String folderName){
        String path = folderName+"\\"+ "index.html";
        String name = "Created ./"+folderName+"/index.html";
        String content = "<meta charset=\"utf-8\"><title>\n"+ folderName +"</title>";
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write(content);
            setInfo(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void setInfo(String message) {
        Main.info.append(message);
        Main.info.append("\n");
    }
    private static void otherFolder(String folderName) throws IOException {
        System.out.print("Do you want a folder for JavaScript?");
        File js = new File(folderName+"/js");
        File css = new File(folderName+"/css");
        if (userInput.nextLine().equalsIgnoreCase("y")){
            if (js.mkdir()){
             setInfo("Created "+"./js/");
            }
        }
        System.out.println("Do you want a folder for CSS?");
        if (userInput.nextLine().equalsIgnoreCase("y")){
            if (css.mkdir()){
                setInfo("Created "+"./css/");
            }
        }
    }
}
