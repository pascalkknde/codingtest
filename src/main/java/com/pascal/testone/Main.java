package com.pascal.testone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(escapeCharacters(readingFile("C:/Project/codingtestforpascalkkndes/src/main/resources/word.txt"),false));
    }
    private static String escapeCharacters(String text, boolean quote){
        StringBuilder builder = new StringBuilder();
        if (quote){
            builder.append("\"");
        }

        for (char c : text.toCharArray()){
            if (c =='\''){
                builder.append("\'");
            }else if ( c == '\"' ) {
                builder.append("\"");
            }else if( c == '\r' ){
                builder.append( "\r" );
            }else if( c == '\n' ){
                builder.append( "\n" );
            } else if( c == '\t' ){
                builder.append( "\t" );
            } else if( c < 32 || c >= 127 ){
                builder.append( String.format( "\\u%04x", (int)c ) );
            }
            else {
                builder.append(c);
            }
        }
        if(quote){
            builder.append("\"");
        }

        return builder.toString();
    }

    private static String readingFile(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
