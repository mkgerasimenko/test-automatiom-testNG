package com.waverleysoftware.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A simple model class for client processing.
 */
@Data
@XmlRootElement(name = "Client")
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String job;
    private int age;

    public Client() {
        this.id = 2;
        this.firstName = "Maks";
        this.lastName = "Maksimov";
        this.job = "QA";
        this.age = 26;
    }
}
