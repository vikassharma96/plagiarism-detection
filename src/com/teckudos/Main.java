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
        // listAllFiles();
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
        singleLinePrint(Constants.DIRECTORY_TO_SCAN);
        try (var reader = new BufferedReader(new InputStreamReader(System.in));
             var files = Files.list(Paths.get(reader.readLine()))) {
            var fileList = files.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
            singleLinePrint("   ");
            for (int i = 0; i < fileList.size(); i++) {
                singleLinePrint("   |   " + i);
                if (i == fileList.size() - 1) singleLinePrint("   |\n");
            }
            print(Constants.SEPARATOR);
            String[] fileData = new String[fileList.size()];
            for (int i = 0; i < fileList.size(); i++) {
                bufferedReader = new BufferedReader(new FileReader(fileList.get(i).toString()));
                StringBuilder stringBuilder = new StringBuilder();
                String stringToRead;
                while ((stringToRead = bufferedReader.readLine()) != null) {
                    stringBuilder.append(stringToRead);
                    // stringBuilder.append("\n");
                }
                fileData[i] = stringBuilder.toString();
            }
            for (int i = 0; i < fileData.length; i++) {
                singleLinePrint(i + "     |");
                for (int j = 0; j < fileData.length; j++) {
                    if (i == j) singleLinePrint("  100  |");
                    else {
                        singleLinePrint("   " +
                                stringMatchPercent(fileData[i], fileData[j]) +
                                "  |");
                    }
                }
                singleLinePrint("\n");
            }
        } catch (IOException exception) {
            print(exception);
        }
    }

    private static int stringMatchPercent(String s1, String s2) {
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int L[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return (int) (((float) L[m][n] / Math.min(m, n)) * 100);
    }
}
