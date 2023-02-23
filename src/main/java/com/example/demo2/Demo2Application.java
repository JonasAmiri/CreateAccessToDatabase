package com.example.demo2;

import java.util.List;
import java.util.ArrayList;

import com.example.demo2.Models.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Demo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
        System.out.println("Hello World");
        PostGradDAO x = new PostGradDAO();

        List<Customer> allCustomers = x.getAllCustomers();

        for (int i = 0; i < allCustomers.size(); i++) {
            print(allCustomers.get(i).getCountry());
        }

        print("----------------");
        print(x.getSpecificCustomers(1).getName());

        print("---------------- (Name");
        print(x.getSpecificCustomerByName("Leonie").getName());
        //print(x.getSpecificCustomerByName("Mercier").getName());


        print("----------------");
        List<Customer> customerList = x.getCustomerPage(10, 10);
        for (Customer customer : customerList) {
            System.out.println(customer.getName());
        }
        print("----------------");

        Customer customer = new Customer(0, "Jonas", "Amiri", "Denmark", "2300", "215454", "jsjsj@dd.com");
        x.insertCustomerIntoDatabase(customer);

        Customer customer1 = new Customer(60, "stallon", "Rambo2", "USA", "5050", "54545", "@.com");

        x.UpdateExistingCustomerInDatabase(customer1);

        print("-----\n-----");
        print(x.TheMostCustomerCountry());
        print("-----High\n-----Spend");
        x.highestSpender();
    }


    private static void print(String s) {
        System.out.println(s);
    }

}
