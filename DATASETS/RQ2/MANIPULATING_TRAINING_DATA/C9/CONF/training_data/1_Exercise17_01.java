package ch_17.exercise17_01;

import java.io.*;
import java.util.Random;


public class Exercise17_01 {
    public static void main(String[] args) {
        String[] packageParts = Exercise17_01.class.getPackage().getName().split("\\.");
        String filePath = packageParts[0] + File.separator + packageParts[1] + File.separator +
                        "Exercise17_01.txt";
        File file = new File(filePath);
        PrintWriter printWriter = null;
        try {
            if (file.exists()) {
                printWriter = new PrintWriter(new FileOutputStream(new File(filePath), false));
            } else {
                printWriter = new PrintWriter(file);
            }
            System.out.println("Starting write out random Integer to: " + file.getAbsolutePath());
            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                sb.append(num).append(" ");
            }
            printWriter.write(sb.toString());
            printWriter.close();
            System.out.println("Write out completed successfully.");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurred.");
        }


    }


}
