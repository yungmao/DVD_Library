package com.company;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Responsible for controlling DVD in Library
 */
public class DVD_Controller {
    public static Scanner input = new Scanner(System.in);

    /**
     * Add new DVD to library by user
     * @param library ArrayList of all DVDs
     */
    public static void addDVD(ArrayList<DVD> library) {
        DVD dvd = new DVD();
        library.add(dvd);
    }

    /**
     * Remove DVD from library by its title
     * @param library ArrayList of all DVDs
     */
    public static void removeDVD(ArrayList<DVD> library) {
        System.out.print("Which movie do you want to remove from Library: ");
        int index = findDVDIndex(library);
        library.remove(index);
    }

    /**
     * List all DVD title in library
     * @param library ArrayList of all DVDs
     */
    public static void listDVD(ArrayList<DVD> library) {
        System.out.println("Library currently have these DVDs: ");
        for (DVD dvd : library) {
            System.out.println(dvd.getTitle());
        }
    }

    /**
     * Display metadata of DVD by its title
     * @param library ArrayList of all DVDs
     */
    public static void displayDVDsData(ArrayList<DVD> library) {
        System.out.print("Which movie's information do you want to display: ");
        int index = findDVDIndex(library);
        DVD dvd = library.get(index);
        System.out.println(dvd.toString());
    }

    /**
     * Find index of DVD in library
     * @param library ArrayList of all DVDs
     * @return index of search DVD in library
     */
    public static int findDVDIndex(ArrayList<DVD> library) {
        String title = input.nextLine();
        int index = 0;
        for (int i = 0; i < library.size(); i++) {
            DVD dvd = library.get(i);
            if (title.equalsIgnoreCase(dvd.getTitle())) {
                index = i;
            }
        }
        return index;
    }


    /**
     * Edit DVD metadata
     * @param library ArrayList of all DVDs
     */
    public static void editDVD(ArrayList<DVD> library) {
        System.out.print("Which movie's information do you want to edit: ");
        int index = findDVDIndex(library);
        DVD dvd = library.get(index);
        boolean stillEdit = true;
        while(stillEdit) {
            printOptions();
            int option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    System.out.print("New title: ");
                    String title = input.nextLine();
                    dvd.setTitle(title);
                    break;
                case 2:
                    System.out.print("New release date: ");
                    String release_date = input.nextLine();
                    dvd.setRelease_date(release_date);
                    break;
                case 3:
                    System.out.print("New MPAA rating: ");
                    String ratingMPAA = input.nextLine();
                    dvd.setRatingMPAA(ratingMPAA);
                    break;
                case 4:
                    System.out.print("New Director name: ");
                    String director_name = input.nextLine();
                    dvd.setDirector_name(director_name);
                    break;
                case 5:
                    System.out.print("New Studio name: ");
                    String studio_name = input.nextLine();
                    dvd.setStudio_name(studio_name);
                    break;
                case 6:
                    System.out.print("New Additional information:  ");
                    String additional_information = input.nextLine();
                    dvd.setAdditional_information(additional_information);
                    break;
                case 7:
                    stillEdit=false;
                    break;
                default:
                    System.out.println("Wrong option");
            }
        }
    }
    private static void printOptions(){
        System.out.println("Which information do you want to edit");
        System.out.println("1 - Title");
        System.out.println("2 - Release date");
        System.out.println("3 - MPAA rating");
        System.out.println("4 - Director's name");
        System.out.println("5 - Studio's name");
        System.out.println("6 - Additional information");
        System.out.println("7 - Exit");
    }

}
