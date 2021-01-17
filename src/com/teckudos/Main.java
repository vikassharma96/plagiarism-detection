package com.teckudos;

import com.teckudos.utils.Constants;
import com.teckudos.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main extends Utils {

    private static BufferedReader bufferedReader;

    public static void main(String[] args) {
        listAllFiles();
        longestCommonSubsequence();
    }

    private static void listAllFiles() {
        singleLinePrint(Constants.DIRECTORY_TO_SCAN);
        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var files = Files.list(Paths.get(reader.readLine()))
        ) {
            var fileList = files.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            for (int i = 0; i < fileList.size(); i++) {
                print(i + ": " + fileList.get(i).toString());
            }

            print(Constants.SEPARATOR);

            String[] fileData = new String[fileList.size()];
            for (int i = 0; i < fileList.size(); i++) {
                bufferedReader = new BufferedReader(new FileReader(fileList.get(i).toString()));
                StringBuilder stringBuilder = new StringBuilder();
                String stringToRead;
                while ((stringToRead = bufferedReader.readLine()) != null) {
                    stringBuilder.append(stringToRead);
                    stringBuilder.append("\n");
                }
                fileData[i] = stringBuilder.toString();
            }
            for (String data : fileData) {
                print(data);
            }
        } catch (IOException exception) {
            print(exception);
        }
    }

    private static void longestCommonSubsequence() {

    }
}
