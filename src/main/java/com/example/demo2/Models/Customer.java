package com.example.demo2.Models;

import java.sql.*;

public class Customer {

    private int Id;
    private String first_name, last_name,country,phone_number,email, postal_code;

    public Customer(int id, String fn, String ln, String c, String pc, String pn, String em) {
        Id = id;
        first_name = fn;
        last_name = ln;
        country = c;
        phone_number = pn;
        email = em;
    }


    public int getId() {
        return Id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCountry() {
        return country;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public String getPostal_code() {
        return postal_code;
    }


    public String getName(){
        return first_name + " " + last_name;
    }


}
