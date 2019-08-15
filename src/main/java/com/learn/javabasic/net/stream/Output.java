package com.learn.javabasic.net.stream;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Output {
    public static void main(String[] args) {
        String path = "D:\\ubuntu\\learn\\JavaWeb\\MavenProject\\maven03\\lear_servlet\\src\\main\\resources\\test\\abc.txt";
        File file = new File(path);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            generateCharacters(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateCharacters(OutputStream out) throws IOException {
        int firstPrintableCharacter = 33;
        int numberOfPrintableCharacter = 94;
        int numberOfCharactersPerLine = 72;

        int start = firstPrintableCharacter;

        while (true) {
            for (int i = start; i < start + numberOfCharactersPerLine; i++) {
                out.write(((i - firstPrintableCharacter) % numberOfPrintableCharacter) + firstPrintableCharacter);
            }
            out.write('\r');
            out.write('\n');
            start = ((start + 1) - firstPrintableCharacter) % numberOfPrintableCharacter + firstPrintableCharacter;
        }
    }
}
