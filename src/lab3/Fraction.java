package lab3;

import java.util.Scanner;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 1;
        this.denominator = 1;
    }
    public Fraction(int n, int d) {
        this.numerator = n;
        this.denominator = d;
        reduce();
    }

    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }
    public void setNumerator(int n) { this.numerator = n; reduce(); }
    public void setDenominator(int d) { this.denominator = d; reduce(); }

    static int findGCD(int n, int d) {
        n = Math.abs(n);
        d = Math.abs(d);
        if (n == 0) return 1; 
        if (d == 0) return n; 
        return findGCD(d, n % d);
    }

    private void reduce() {
        if (denominator < 0) { denominator = -denominator; numerator = -numerator; }
        if (numerator != 0 && denominator != 0) {
            int g = findGCD(numerator, denominator);
            numerator /= g; denominator /= g;
        }
        if (denominator == 0 && numerator != 0) {
            numerator = (numerator > 0) ? 1 : -1; 
        }
    }

    public Fraction add(Fraction other) {
        int newN = this.numerator * other.denominator + other.numerator * this.denominator;
        int newD = this.denominator * other.denominator;
        return new Fraction(newN, newD);
    }

    @Override public String toString() { return numerator + "/" + denominator; }

    public double toDecimal() { return (double) numerator / (double) denominator; }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("*** WELCOME TO FRACTION ACTION ***");
        System.out.println("1. Add Fractions");
        System.out.println("2. Add Mixed Fraction");
        System.out.print("*** Enter your choice ***\n");
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("------- Input first fraction -------");
            System.out.println("Numerator: ");
            int n1 = sc.nextInt();
            System.out.println("Denominator: ");
            int d1 = sc.nextInt();

            System.out.println("------- Input second fraction -------");
            System.out.println("Numerator: ");
            int n2 = sc.nextInt();
            System.out.println("Denominator: ");
            int d2 = sc.nextInt();

            Fraction f1 = new Fraction(n1, d1);
            Fraction f2 = new Fraction(n2, d2);
            Fraction sum = f1.add(f2);

            System.out.println("f1 = " + f1);
            System.out.println("f2 = " + f2);
            System.out.println("f1 + f2 = " + sum);
            System.out.println("The sum in decimal is: " + sum.toDecimal());
        } else if (choice == 2) {
            System.out.println("------- Input first mixed fraction -------");
            System.out.print("Natural number\n");
            int N1 = sc.nextInt();
            System.out.println("Numerator: ");
            int n1 = sc.nextInt();
            System.out.println("Denominator: ");
            int d1 = sc.nextInt();

            System.out.println("------- Input second mixed fraction -------");
            System.out.print("Natural number\n");
            int N2 = sc.nextInt();
            System.out.println("Numerator: ");
            int n2 = sc.nextInt();
            System.out.println("Denominator: ");
            int d2 = sc.nextInt();

            MixedFraction mf1 = new MixedFraction(N1, n1, d1);
            MixedFraction mf2 = new MixedFraction(N2, n2, d2);
            Fraction sum = mf1.add(mf2);

            System.out.println("mf1 = " + mf1);
            System.out.println("mf2 = " + mf2);
            System.out.println("mf1 + mf2 = " + sum);
            System.out.println("The sum in decimal is: " + sum.toDecimal());
        } else {
            System.out.println("Goodbye!");
        }
    }
}




