package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Responsible for handling csv file. Class based on FileIOBasics by Eugene O'Regan
 */
public class CSV_Handler {

    /**
     * Must be changed to user absolute path of data/in
     */
    private static final String INPUT_FILE_DIR = "C:\\Users\\Student241165\\IdeaProjects\\DVD_Library\\data\\in\\";
    /**
     * Must be changed to user absolute path of data/out
     */
    private static final String OUTPUT_FILE_DIR = "C:\\Users\\Student241165\\IdeaProjects\\DVD_Library\\data\\out\\";
    private static final String EXTENSION = ".txt";
    private static final String DELIMITER = ",";

    public static Scanner input = new Scanner(System.in);

    /**
     * Method ask user for input file name without file extension
     * @return Absolute filepath of Input file
     */
    public static String getInputFilepath() {
        System.out.print("Which file to read: ");
        String read_filename = input.nextLine();
        return INPUT_FILE_DIR + read_filename + EXTENSION;
    }

    /**
     * Method ask user for output file name without file extension
     * @return Absolute filepath of Output file
     */
    public static String getOutputFilepath() {
        System.out.print("Enter output filename: ");
        String output_filename = input.nextLine();
        return OUTPUT_FILE_DIR + output_filename + EXTENSION;
    }

    /**
     * Method reads and parse DVDs metadata from input file
     * @param inputFilepath Absolute path of input file
     * @return ArrayList of all DVDs parsed from input file
     */
    public static ArrayList<DVD> readCSV(String inputFilepath){
        ArrayList<DVD> allDVDs = new ArrayList<DVD>();
        BufferedReader fileReader = null;
        try
        {
            String line = "";
            //Create the file reader
            fileReader = new BufferedReader(new FileReader(inputFilepath));

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
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        finally
        {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
        return allDVDs;
    }

    /**
     * Method save ArrayList of DVDs in library to csv file
     * @param allDVDs ArrayList of all DVDs in library
     * @param outputFilepath Absolute path of output file
     */
    public static void writeCSV(ArrayList<DVD> allDVDs, String outputFilepath){
        try {
            FileWriter fw = new FileWriter(outputFilepath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < allDVDs.size(); i++) {
                DVD dvd = allDVDs.get(i);
                String metadata = dvd.toString();
                bw.write(metadata + "\n");
                bw.flush();
            }
            bw.close();
        } catch (Exception e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}

