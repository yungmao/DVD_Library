package com.company;

import java.io.*;
import java.util.ArrayList;

public class CSV_Handler {
    private static final String DELIMITER = ",";
    File fileNameIn = new File("data/in/dvds.txt");
    File fileNameOut = new File("data/out/Output.txt");

    public static ArrayList<DVD> readCSV(String fileNameIn){
        ArrayList<DVD> allDVDs = new ArrayList<DVD>();
        BufferedReader fileReader = null;
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(fileNameIn));

            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] metadata = line.split(DELIMITER);
                DVD dvd = new DVD(metadata);
                allDVDs.add(dvd);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {

                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return allDVDs;
    }
    public static void writeCSV(ArrayList<DVD> allDVDs, String fileNameOut){
        try {
            FileWriter fw = new FileWriter(fileNameOut);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < allDVDs.size(); i++) {
                DVD dvd = allDVDs.get(i);
                String metadata = dvd.toString();
                bw.write(metadata.toString() + "\n");
                bw.flush();
            }
            bw.close();
        } catch (Exception e) {

        }
    }
}

