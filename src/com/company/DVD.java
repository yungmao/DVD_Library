package com.company;

import java.util.Scanner;

public class DVD {
    private String title;
    private String release_date; // Note to myself change to Calendar date
    private String ratingMPAA; //Note to myself check from enum?
    private String director_name;
    private String studio_name;
    private String additional_information;

    DVD(String title, String release_date, String ratingMPAA,
        String director_name, String studio_name, String additional_information) {
        this.title = title;
        this.release_date = release_date;
        this.ratingMPAA = ratingMPAA;
        this.director_name = director_name;
        this.studio_name = studio_name;
        this.additional_information = additional_information;
    }

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

    DVD() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Title: ");
        setTitle(title = input.nextLine());
        System.out.printf("Release date: ");
        setRelease_date(release_date = input.nextLine());
        System.out.printf("MPAA rating: ");
        setRatingMPAA(ratingMPAA = input.nextLine());
        System.out.printf("Director name: ");
        setDirector_name(director_name = input.nextLine());
        System.out.printf("Studio name: ");
        setStudio_name(studio_name = input.nextLine());
        System.out.printf("Additional information: ");
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
