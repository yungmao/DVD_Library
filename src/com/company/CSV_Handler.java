package com.company;

import java.io.*;

public class CSV_Handler {
    private static final String DELIMITER = ",";
    File fileNameIn = new File("data/in/dvds.txt");
    File fileNameOut = new File("data/out/Output.txt");

    public static void readCSV(String fileNameIn){
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
                String[] tokens = line.split(DELIMITER);
                for(String token : tokens)
                {
                    //Print all tokens
                    System.out.println(token);
                }
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
    }
    public static void writeCSV(String fileNameOut){
        int arrOut[][] = {{5, 100, 115, 20},{10,20,30,50}};

        try {
            FileWriter fw = new FileWriter(fileNameOut);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < arrOut.length; i++) {
                for (int j = 0; j<arrOut[i].length;j++){
                Integer x = arrOut[i][j];
                bw.write(x.toString() + ",");
            }
                bw.write("\n");
                bw.flush();

            }
            bw.close();
        } catch (Exception e) {

        }
    }
}

