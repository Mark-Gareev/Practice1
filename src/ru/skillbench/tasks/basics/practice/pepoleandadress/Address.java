package ru.skillbench.tasks.basics.practice.pepoleandadress;


import java.util.concurrent.atomic.AtomicReference;

/**
 *  class that perform address entity from task 3
 * @author Mark Gareev
 */

public class Address {
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    /**
     * constructor to set parameters of address
     * @param city
     * @param street
     * @param houseNumber
     * @param flatNumber
     */
    public Address(String city, String street, String houseNumber, String flatNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    @Override
    /**
     * returns true if all fields of addresses are the same
     */
    public boolean equals(Object o) {
        return this.toString().equals(o.toString());
    }

    /**
     * concatenate all fields of address
     * @return string contains all address fileds with " " between them
     */
    public String toString(){
        return (city +" "+ street +" "+ houseNumber +" "+ flatNumber);
    }

}
