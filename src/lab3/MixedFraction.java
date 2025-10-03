package lab3;

import java.util.Scanner;

public class MixedFraction extends Fraction {
    private int naturalNumber;

    public MixedFraction(int N, int n, int d) {
        super(n, d);
        this.naturalNumber = N;
    }

    public int getNaturalNumber() { return naturalNumber; }
    public void setNaturalNumber(int n) { this.naturalNumber = n; }

    public Fraction toFraction() {
        int n = getNumerator();
        int d = getDenominator();
        if (d == 0) return new Fraction(n, d);
        int improper = naturalNumber * d + n;
        return new Fraction(improper, d);
    }

    // overloaded add(MixedFraction)
    public Fraction add(MixedFraction mf) {
        return this.toFraction().add(mf.toFraction());
    }

    @Override public String toString() { return naturalNumber + " " + super.toString(); }

    @Override public double toDecimal() {
        int n = getNumerator(), d = getDenominator();
        return ((double) naturalNumber * d + n) / d;
    }

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




