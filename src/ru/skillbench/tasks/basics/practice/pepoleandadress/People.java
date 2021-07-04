package ru.skillbench.tasks.basics.practice.pepoleandadress;

import java.util.Calendar;

/**
 * class describing entity of people in task 3
 * @author Mark Gareev
 */

public class People {
    private Calendar birthDate;
    private long millisAge;
    private String firstName;
    private String lastName;
    private Address address;


    public People() {
    }

    public People(Calendar birthDate, String firstName, String lastName, Address address) {
        this.address = address;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.millisAge = birthDate.getTimeInMillis();
    }
    public String getLastName() {
        return lastName;
    }
    public long getMillisAge() {
        return millisAge;
    }

    public Address getAddress() {
        return this.address;
    }

    @Override
    /**
     * returns string describing person in readable format
     */
    public String toString() {
        return (firstName + " " + lastName + ", " + address + ", " + birthDate.getTime());
    }


}
