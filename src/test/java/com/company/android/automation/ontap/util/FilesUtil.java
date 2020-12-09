package com.company.android.automation.ontap.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesUtil {
    public static boolean checkDirectoryExists(String path) {
        File file = new File(path);

        return file.exists();
    }

    public static void writeFile(String name, String content) {
        try (FileWriter fileWriter = new FileWriter(name, true)) {
            fileWriter.write(content.concat("\n"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkFileExists(String file) {
        return new File(file).exists();
    }

    public static void createDirectory(String directory) {
        if (!checkDirectoryExists(directory))
            new File(directory).mkdir();
    }

    public static void createFile(String name, String content) {
        try {
            new File(name).createNewFile();
            FileOutputStream outputStream = new FileOutputStream(name);
            byte[] strToBytes = content.getBytes();
            outputStream.write(strToBytes);

            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFile(String file) {
        List<String> list = new ArrayList<>();

        String st;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((st = br.readLine()) != null) {
                list.add(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}
