package com.waverleysoftware.model;


import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A simple model class for client processing.
 */
@Data
@XmlRootElement
public class Client {

    private final String firstName;
    private final String lastName;
    private final String job;
    private final int age;

    public Client(final String firstName, final String lastName, final String job, final String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.age = Integer.parseInt(age);
    }
}
