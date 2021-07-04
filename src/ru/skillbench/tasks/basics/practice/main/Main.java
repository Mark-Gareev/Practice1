package ru.skillbench.tasks.basics.practice.main;

import ru.skillbench.tasks.basics.practice.pepoleandadress.Address;
import ru.skillbench.tasks.basics.practice.pepoleandadress.DataContainerWithAccess;
import ru.skillbench.tasks.basics.practice.pepoleandadress.People;
import ru.skillbench.tasks.basics.practice.quadraticequation.Equation;
import ru.skillbench.tasks.basics.practice.rolladice.Game;

import java.util.Scanner;

/**
 * demonstration class of training tasks
 * @author Mark Gareev
 */

public class Main {
    public static void main(String... args) {
//        equationDemo();
//        System.out.println("Next!");
//        gameDemo();
//        System.out.println("Next!");
        accessDemo();


    }

    /**
     * demonstrate dice game
     */
    private static void gameDemo() {
        int N;
        int K;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Put players amount : ");
        N = Integer.parseInt(scanner.nextLine());
        System.out.println("Put dice amount : ");
        K = Integer.parseInt(scanner.nextLine());
        Game game = new Game(N, K);
        game.start();
        scanner.close();
    }

    /**
     * demonstrate quadratic equation solution
     */
    private static void equationDemo() {
        Equation eq = new Equation(-5, 5, 5);
        System.out.println(eq.findRoots().toString());
    }

    /**
     * demonstrate every get method of DataContainerWithAccess
     */
    private static void accessDemo() {
        DataContainerWithAccess example = new DataContainerWithAccess();
        System.out.println("Oldest : \r\n" + example.getOldest().toString());
        System.out.println("Youngest : \r\n" + example.getYoungest().toString());
        Address demoAdress = new Address("Saint-Petersburg",
                "Korovnikova",
                "35",
                "2");
        System.out.println("People with demoAddress : \r\n" + example.getPeopleWithAddress(demoAdress).toString());
        People[] arr = example.getPeopleFormStreet("Lenina");
        System.out.println("People from Lenina street : ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i].toString());
        }
        arr = example.getPeopleWithLastName("Fedorov");
        System.out.println("People with lastname \"Fedorov\" : ");
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i].toString());
        }
    }
}
