package com.example.candidateonboarding;

public class HelperClass {
    String Name, Location,College,Aadhar_Card_number;

    public String getName() {return Name; }

    public void setName(String name) {
        Name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCollege() {
        return College;
    }

    public void setCollege(String college) {
        College = college;
    }

    public String getAadhar_Card_number() {
        return Aadhar_Card_number;
    }

    public void setAadhar_Card_number(String aadhar_Card_number) {
        Aadhar_Card_number = aadhar_Card_number;
    }

    public HelperClass(String name, String location, String college, String aadhar_Card_number) {
        Name = name;
        Location = location;
        College = college;
        Aadhar_Card_number = aadhar_Card_number;
    }

    public HelperClass() {

    }
}
