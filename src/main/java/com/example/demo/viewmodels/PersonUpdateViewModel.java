package com.example.demo.viewmodels;

public class PersonUpdateViewModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phone;

    public PersonUpdateViewModel(int id, String firstName, String lastName, String email, Long phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
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
