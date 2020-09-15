package com.pluralsight.io;

import com.pluralsight.model.Kid;

import java.io.*;

public class Writer {

    private static int count = 0;

    public static void write (Kid kid) throws FileNotFoundException, UnsupportedEncodingException {

        File file = new File("C:\\Users\\Plamen Admin\\Desktop\\Kids\\kids.txt");
        if (count == 0 && file.exists()) {
            file.delete();
        }
        System.out.println(kid.getFirstName());

        try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));) {
            String house = "";
            switch (kid.getHouse()) {
                case "1":
                    house = "Дипломати";
                    break;
                case "2":
                    house = "Хармони";
                    break;
                case "3":
                    house = "Интелекти";
                    break;
                case "4":
                    house = "Идеали";
                    break;
            }
            writer.append(String.format("%s %s %s %s", kid.getLevel(), kid.getFirstName(), kid.getFamily(), house));
            writer.append(System.lineSeparator());
            count++;
        }
    }
}
