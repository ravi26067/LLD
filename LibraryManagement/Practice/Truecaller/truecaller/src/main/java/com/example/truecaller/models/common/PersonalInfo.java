package com.example.truecaller.models.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonalInfo {
    private String firstName;
    private String lastName;
    private String middleName;
    private String dob;
    private Address address;
    private Gender gender;
    private String companyName;

    public PersonalInfo(String firstName) {
        this.firstName = firstName;
    }

}
