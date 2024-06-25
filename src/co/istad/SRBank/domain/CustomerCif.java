package co.istad.SRBank.domain;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerCif {
    private int cifId;
    private int CifNumber;
    private String first_name;
    private String last_name;
    private char gender;
    private Date dob;
    private String nid;
    private String employment;
    private String sourceOfFund;
    private String phoneNumber;
    private String district;
    private String provinceCity;
    private String street;
    private String house;
    private LocalDate createOn;
    private int id;

    public CustomerCif() {
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public int getCifNumber() {
        return CifNumber;
    }

    public void setCifNumber(int cifNumber) {
        CifNumber = cifNumber;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getEmployment() {
        return employment;
    }

    public void setEmployment(String employment) {
        this.employment = employment;
    }

    public String getSourceOfFund() {
        return sourceOfFund;
    }

    public void setSourceOfFund(String sourceOfFund) {
        this.sourceOfFund = sourceOfFund;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public LocalDate getCreateOn() {
        return createOn;
    }

    public void setCreateOn(LocalDate createOn) {
        this.createOn = createOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int cifId() {
        return cifId;
    }

    public void cifId(int cifId) {
        this.cifId = cifId;
    }


    @Override
    public String toString() {
        return
                "  CifNumber= " + CifNumber +
                "  cifId= " + cifId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", gender=" + gender +
                ", dob=" + dob +
                ", nid='" + nid + '\'' +
                ", employment='" + employment + '\'' +
                ", sourceOfFund='" + sourceOfFund + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", district='" + district + '\'' +
                ", provinceCity='" + provinceCity + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", createOn=" + createOn +
                ", Staff_id=" + id;
    }
}
