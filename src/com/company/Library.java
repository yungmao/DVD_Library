package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library of DVDs
 */
public class Library {
    private static ArrayList<DVD> library;

    /**
     * Initilize Library with its functionality
     */
    Library() {
       String input_filepath =  CSV_Handler.getInputFilepath();
        library = CSV_Handler.readCSV(input_filepath);
        boolean finishLibrary = false;
        while (!finishLibrary) {
           finishLibrary = editLibrary();
        }
    }

    /**
     * Edit Library content
     * @return Flag ending editing library
     */
    public static boolean editLibrary() {
        boolean finishLibrary = false;
        Scanner input = new Scanner(System.in);
        printOptions();
        System.out.print("Option: ");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                DVD_Controller.addDVD(library);
                break;
            case 2:
                DVD_Controller.removeDVD(library);
                break;
            case 3:
                DVD_Controller.editDVD(library);
                break;
            case 4:
                DVD_Controller.listDVD(library);
                break;
            case 5:
                DVD_Controller.displayDVDsData(library);
                break;
            case 6:
                System.out.println("Before closing save Library");
                String output_filepath = CSV_Handler.getOutputFilepath();
                CSV_Handler.writeCSV(library, output_filepath);
                System.out.println("Program will close!");
                finishLibrary=true;
                break;
            default:
                System.out.println("Error");
        }
        return finishLibrary;
    }

    private static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add new DVD");
        System.out.println("2 - Remove DVD");
        System.out.println("3 - Edit DVD");
        System.out.println("4 - List DVDs");
        System.out.println("5 - Display one DVD information");
        System.out.println("6 - Exit Library");
    }
}
