package ru.skillbench.tasks.basics.practice.quadraticequation;

import static java.lang.Math.*;

/**
 * public class to find quadratic equation solution
 * allow only "a * x^2 + b * x + c = 0" equation
 * roots will produced in string like "x1|x2"
 * @author Mark Gareev
 */
public class Equation {
    private double a;
    private double b;
    private double c;

    /**
     * unique constructor to set equation parameters
     *
     * @param a -- parameter before x^2
     * @param b -- parameter before x
     * @param c -- free parameter
     */
    public Equation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return Roots object with two String fileds
     */
    public Roots findRoots() {
        Roots result = new Roots();
        double doubleInterimResult;
        String stringInterimResult;
        double d = new DiscriminantFinder().getDiscriminant(a, b, c);
        if (d < 0) {
            doubleInterimResult = (-b / (2 * a));
            stringInterimResult = (sqrt(abs(d)) / (2 * a)) + "i";
            result.setFirstRoot(doubleInterimResult + " + " + stringInterimResult);
            result.setSecondRoot(doubleInterimResult + " - " + stringInterimResult);
        } else {
            result.setFirstRoot(String.valueOf((-b + sqrt(d)) / (2 * a)));
            result.setSecondRoot(String.valueOf((-b - sqrt(d)) / (2 * a)));

        }
        return result;
    }

    /**
     * class to contain both roots of quadratic equation
     */
    public class Roots {
        private String firstRoot;
        private String secondRoot;

        public void setFirstRoot(String firstRoot) {
            this.firstRoot = firstRoot;
        }

        public void setSecondRoot(String secondRoot) {
            this.secondRoot = secondRoot;
        }

        @Override
        public String toString() {
            return firstRoot + "|" + secondRoot;
        }
    }

    /**
     * inner class with only one method that finds discriminant
     */
    private class DiscriminantFinder {
        /**
         * finds discriminant
         * @param a
         * @param b
         * @param c
         * @return
         */
        public double getDiscriminant(double a, double b, double c) {
            return (pow(b, 2) - 4 * a * c);
        }

    }
}
