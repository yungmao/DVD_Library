package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Library {
    private static ArrayList<DVD> library;

    Library() {
       String input_filepath =  Menu.getInputName();
        library = CSV_Handler.readCSV(input_filepath);
        boolean finishLibrary = false;
        while (!finishLibrary) {
           finishLibrary = editLibrary(finishLibrary);
        }
    }

    public static void libraryOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Add new DVD");
        System.out.println("2 - Remove DVD");
        System.out.println("3 - Edit DVD");
        System.out.println("4 - List DVDs");
        System.out.println("5 - Display one DVD information");
        System.out.println("6 - Exit Library");
    }

    public static boolean editLibrary(boolean finishLibrary) {
        Scanner input = new Scanner(System.in);
        libraryOptions();
        System.out.printf("Option: ");
        int option = input.nextInt();
        input.nextLine();
        switch (option) {
            case 1:
                Menu.addDVD(library);
                break;
            case 2:
                Menu.removeDVD(library);
                break;
            case 3:
                Menu.editDVD(library);
                break;
            case 4:
                Menu.listDVD(library);
                break;
            case 5:
                Menu.displayDVDsData(library);
                break;
            case 6:
                System.out.println("Before closing save Library");
                String output_filepath = Menu.getOutputName();
                CSV_Handler.writeCSV(library, output_filepath);
                System.out.println("Program will close!");
                finishLibrary=true;
                break;
            default:
                System.out.println("Error");
        }
        return finishLibrary;
    }
}
