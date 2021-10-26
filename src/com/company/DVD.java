package com.company;

import java.util.Scanner;

/**
 * Representation of a single DVD in library
 */
public class DVD {

    private String title;
    private String release_date;
    private String ratingMPAA;
    private String director_name;
    private String studio_name;
    private String additional_information;

    /**
     * Constructor initialize DVD from csv file
     * @param dvd_data Single line parsed from csv file
     */
    DVD(String[] dvd_data) {
        try {
            this.title = dvd_data[0];
            this.release_date = dvd_data[1];
            this.ratingMPAA = dvd_data[2];
            this.director_name = dvd_data[3];
            this.studio_name = dvd_data[4];
            this.additional_information = dvd_data[5];
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Constructor initialize DVD with input from user using setters
     */
    DVD() {
        Scanner input = new Scanner(System.in);
        System.out.print("Title: ");
        setTitle(title = input.nextLine());
        System.out.print("Release date: ");
        setRelease_date(release_date = input.nextLine());
        System.out.print("MPAA rating: ");
        setRatingMPAA(ratingMPAA = input.nextLine());
        System.out.print("Director name: ");
        setDirector_name(director_name = input.nextLine());
        System.out.print("Studio name: ");
        setStudio_name(studio_name = input.nextLine());
        System.out.print("Additional information: ");
        setAdditional_information(additional_information = input.nextLine());

    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getRatingMPAA() {
        return ratingMPAA;
    }

    public String getDirector_name() {
        return director_name;
    }

    public String getStudio_name() {
        return studio_name;
    }

    public String getAdditional_information() {
        return additional_information;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setRatingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }

    public void setDirector_name(String director_name) {
        this.director_name = director_name;
    }

    public void setStudio_name(String studio_name) {
        this.studio_name = studio_name;
    }

    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    /**
     * Method allows for instance of DVD to be parsed to a new csv file
     * @return Parse DVD to .csv file format
     */
    @Override
    public String toString(){
        StringBuilder metadata = new StringBuilder();
        String DELIMITER = ",";
        try {
            metadata.append(getTitle()+DELIMITER);
            metadata.append(getRelease_date()+DELIMITER);
            metadata.append(getRatingMPAA()+DELIMITER);
            metadata.append(getDirector_name()+DELIMITER);
            metadata.append(getStudio_name()+DELIMITER);
            metadata.append(getAdditional_information());
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        return metadata.toString();
    }
}
