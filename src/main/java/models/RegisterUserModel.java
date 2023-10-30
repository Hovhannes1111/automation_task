package models;

import lombok.Data;

@Data
public class RegisterUserModel {
    private String name;
    private String days;
    private String months;
    private String years;
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipCode;
    private String mobileNumber;
}
