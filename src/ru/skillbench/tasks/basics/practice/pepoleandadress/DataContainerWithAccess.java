package ru.skillbench.tasks.basics.practice.pepoleandadress;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class to contain people array, and get access to that
 * @author Mark Gareev
 */
public class DataContainerWithAccess {
    private People[] peoples = new People[5];

    /**
     * Initializing method
     */
    public DataContainerWithAccess() {
        peoples[0] = new People(new GregorianCalendar(2000, Calendar.AUGUST, 23),
                "Ivan",
                "Ivanov",
                new Address("Moscow",
                        "Lenina",
                        "12",
                        "34"));
        peoples[1] = new People(new GregorianCalendar(1985, Calendar.AUGUST, 14),
                "Elena",
                "Timonova",
                new Address("Saint-Petersburg",
                        "Korovnikova",
                        "35",
                        "2"));
        peoples[2] = new People(new GregorianCalendar(1978, Calendar.FEBRUARY, 5),
                "Evgeniy",
                "Ivanov",
                new Address("Kiev",
                        "Svobody",
                        "2",
                        "38"));
        peoples[3] = new People(new GregorianCalendar(1999, Calendar.JANUARY, 3),
                "Igor",
                "Serebrennikov",
                new Address("Nighniy Novgorod",
                        "Kstovskaya",
                        "5",
                        "45"));
        peoples[4] = new People(new GregorianCalendar(1956, Calendar.APRIL, 2),
                "Fedor",
                "Fedorov",
                new Address("Moscow",
                        "Lenina",
                        "12",
                        "34"));
    }

    /**
     * returns oldest people in array
     * @return People
     */
    public People getOldest() {
        People result = peoples[0];
        long age = peoples[0].getMillisAge();
        for (int i = 0; i < 5; i++) {
            if (age > peoples[i].getMillisAge()) {
                result = peoples[i];
                age = peoples[i].getMillisAge();
            }
        }
        return result;
    }

    /**
     * returns youngest people in array
     * @return People
     */
    public People getYoungest() {
        People result = peoples[0];
        long age = peoples[0].getMillisAge();
        for (int i = 0; i < 5; i++) {
            if (age < peoples[i].getMillisAge()) {
                result = peoples[i];
                age = peoples[i].getMillisAge();
            }
        }
        return result;
    }

    /**
     * Returns array of people lives on the  any street, if no matches return void array
     * @param street
     * @return People[]
     */
    public People[] getPeopleFormStreet(String street) {
        int amount = 0;
        for (int i = 0; i < 5; i++) { // to get amount of person from street
            if (street.equals(peoples[i].getAddress().getStreet())) {
                amount++;
            }
        }
        People[] res = new People[amount];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            if (street.equals(peoples[i].getAddress().getStreet())) {
                res[index] = peoples[i];
                index++;
            }
        }
        return res;
    }

    /**
     * return people with address, if no matches return void array
     * @param address
     * @return People
     */
    public People getPeopleWithAddress(Address address) {
        People result = new People();
        for (int i = 0; i < 5; i++) {
            if(address.equals(peoples[i].getAddress()))
            {
                result = peoples[i];
            }
        }
        return result;
    }

    /**
     * REturns array of people with that lastnames
     * @param lastname
     * @return
     */
    public People[] getPeopleWithLastName(String lastname) {
        int amount = 0;
        for (int i = 0; i < 5; i++) {
            if(lastname.equals(peoples[i].getLastName()))
            {
                amount++;
            }
        }
        People[] result = new People[amount];
        int index = 0;
        for (int i = 0; i < 5; i++)
        {
            if(lastname.equals(peoples[i].getLastName()))
            {
                result[index] = peoples[i];
            }
        }
        return result;
    }
}