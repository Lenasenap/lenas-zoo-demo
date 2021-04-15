package se.stridsberg.lenaszoo.recursive;

/**
 * Glöm aldrig ett basfall
 * Inte göra stora iterationer så att minnet tar slut
 * **/
public class Recorsion {

    public static void main(String[] args) {
        /** Kommer kalla fram ett StackOverflowError **/
        //sayHi(3);
        /**  **/
        //countBackwards(10);
        /** Räkna från 10 till 1 **/
        //System.out.println(sum(10));

        /** Indirekt rekursion **/
        oddNumber(1);

    }

    /**
     * Steg 1: Första anropet är number == 10
     * Steg 2: Andra anropet är number == 9
     * Steg 3: Tredje anropet är number 8 osv osv
     *
     * Först går den igenom hela koden tills den når basfallet - sen returnerar den "uppåt" **/
    public static int sum(int number) {
        int sum;

        if (number == 1) {
            sum = 1;
        } else {
            sum = number + sum(number - 1);
        }
        return sum;
    }

    public static void countBackwards(int number) {
        if(number == 0) {
            System.out.println("Klar!");
        } else {
            System.out.println(number);
            number--;
            countBackwards(number);
        }
    }

    public static void sayHi(int number) {
        if(number == 0) {
            System.out.println("Klar");
        } else {
            System.out.println("Hej klassen! " + number);
            number--;
            sayHi(number);
        }
    }

    /** Skriv ut siffrorna 1-10: när en siffra är jämn så +1 och när den är ojämn -1 **/
    public static void oddNumber(int number) {
        if (number <= 10) {
            System.out.println(number + 1);
            number++;
            evenNumber(number);
        }
    }

    public static void evenNumber(int number) {
        if(number <= 10) {
            System.out.println(number - 1);
            number++;
            oddNumber(number);
        }
    }

}
