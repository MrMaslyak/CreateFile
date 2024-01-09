import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;


import java.io.*;
import java.util.Scanner;

public class Main {
    static String name;

    public static void main(String[] args) {
        createOrOpenFile();
        name = readString();

        save("Hello, world!");
        String savedString = readString();
        System.out.println("Прочитано з файлу: " + savedString);
    }

    public static void save(String data){
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Успішно записано у файл.");
        } catch (IOException e) {
            System.out.println("Сталася помилка.");
            e.printStackTrace();
        }
    }

    public static String readString(){
        String text = "";
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            if (myReader.hasNextLine()) {
                text = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Сталася помилка.");
            e.printStackTrace();
        }
        return text;
    }

    public static void createOrOpenFile(){
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("Файл створено: " + myObj.getName());
            } else {
                System.out.println("Файл вже існує.");
            }
        } catch (IOException e) {
            System.out.println("Сталася помилка.");
            e.printStackTrace();
        }
    }
}