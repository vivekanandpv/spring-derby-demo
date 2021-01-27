package com.example.demo.viewmodels;

public class PersonListViewModel {
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;

    public PersonListViewModel(String firstName, String lastName, String email, Long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhone() {
        return phone;
    }
}
