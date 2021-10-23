package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static final String INPUT_FILE_DIR = "C:\\Users\\Student241165\\IdeaProjects\\DVD_Library\\data\\in\\";
    private static final String OUTPUT_FILE_DIR = "C:\\Users\\Student241165\\IdeaProjects\\DVD_Library\\data\\out\\";
    private static final String EXTENSION = ".txt";

    public static Scanner input = new Scanner(System.in);

    public static String getInputName() {
        System.out.println("Welcome to DVD Library");
        System.out.printf("Which file to read: ");
        String read_filename = input.nextLine();
        return INPUT_FILE_DIR + read_filename + EXTENSION;
    }

    public static String getOutputName() {
        System.out.printf("Enter output filename: ");
        String output_filename = input.nextLine();
        return OUTPUT_FILE_DIR + output_filename + EXTENSION;
    }

    public static void addDVD(ArrayList<DVD> library) {
        DVD dvd = new DVD();
        library.add(dvd);
    }

    public static void removeDVD(ArrayList<DVD> library) {
        System.out.printf("Which movie do you want to remove from Library: ");
        int index = searchDVDIndex(library);
        library.remove(index);
    }

    public static void listDVD(ArrayList<DVD> library) {
        System.out.println("Library currently have these DVDs: ");
        for (DVD dvd : library) {
            System.out.println(dvd.getTitle());
        }
    }

    public static void displayDVDsData(ArrayList<DVD> library) {
        System.out.printf("Which movie's information do you want to display: ");
        int index = searchDVDIndex(library);
        DVD dvd = library.get(index);
        System.out.println(dvd.toString());
    }

    public static int searchDVDIndex(ArrayList<DVD> library) {
        String title = input.nextLine();
        int index = 0;
        for (int i = 0; i < library.size(); i++) {
            DVD dvd = library.get(i);
            if (title.equals(dvd.getTitle())) {
                index = i;
            }
        }
        return index;
    }

    private static void editOptions(){
        System.out.println("Which information do you want to edit");
        System.out.println("1 - Title");
        System.out.println("2 - Release date");
        System.out.println("3 - MPAA rating");
        System.out.println("4 - Director's name");
        System.out.println("5 - Studio's name");
        System.out.println("6 - Additional information");
    }

    public static void editDVD(ArrayList<DVD> library) {
        System.out.printf("Which movie's information do you want to edit: ");
        int index = searchDVDIndex(library);
        DVD dvd = library.get(index);
        while(true) {
            editOptions();
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.printf("New title: ");
                    String title = input.nextLine();
                    dvd.setTitle(title);
                    break;
                case 2:
                    System.out.printf("New release date: ");
                    String release_date = input.nextLine();
                    dvd.setRelease_date(release_date);
                    break;
                case 3:
                    System.out.printf("New MPAA rating: ");
                    String ratingMPAA = input.nextLine();
                    dvd.setRatingMPAA(ratingMPAA);
                    break;
                case 4:
                    System.out.printf("New Director name: ");
                    String director_name = input.nextLine();
                    dvd.setDirector_name(director_name);
                    break;
                case 5:
                    System.out.printf("New Studio name: ");
                    String studio_name = input.nextLine();
                    dvd.setStudio_name(studio_name);
                    break;
                case 6:
                    System.out.printf("New Additional information:  ");
                    String additional_information = input.nextLine();
                    dvd.setAdditional_information(additional_information);
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }

}
