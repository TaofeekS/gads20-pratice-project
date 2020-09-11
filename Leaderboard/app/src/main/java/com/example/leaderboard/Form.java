package com.example.leaderboard;

public class Form {

    private String email;
    private String firstName;
    private String lastName;
    private String linkToGithub;

    public Form( String firstName, String lastName, String email, String linkToGithub) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.linkToGithub = linkToGithub;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLinkToGithub() {
        return linkToGithub;
    }
}
