package se.stridsberg.lenaszoo.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExceptions {
    /**
     * Exceptions är någonting som händer som gör att vårat program slutar fungera
     * Checked exceptions kontrolleras av vår JVM medan vi som utvecklare förväntas hantera Runtimeexceptions själva
     * för att införa anpassad logik när detta sker.
     * **/

    public static void main(String[] args) {
        /** Checked exception - vi blir tillsagda att hantera det här felet innan vi kan köra vårt program.
         * För att kunna köra koden måste vi lägga in en try-catch eller lägga in throws i metoden
         * FileNotFoundException är en subklass av IOException
        **/

        /*try {
            FileReader file = new FileReader("pom.xml");
            file = null;
            file.read();
        } catch (IOException e) {
            // Lägg in random logik som ska ske om filen inte hittas
            e.printStackTrace();
        }*/

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        /** ArrayIndexOutOfBounds **/
        //System.out.println(numbers.get(3));

        List<String> list = new ArrayList<>();
        /** IndexOutOfBounds **/
        //list.get(0);

        /** NullPointer **/
        List<Integer> list2 = null;
        //list2.get(0);

        /** Såhär fångar vi exceptions **/

        try {
            System.out.println(1);
            System.out.println(numbers.get(3));
            System.out.println(2);
        } catch (Exception e) {
            System.out.println(3);
            System.out.println("Det gick inte");
        }

        System.out.println("Resten av koden körs nu");


        /** Visa att vi kan exekvera ny kod istället för att kasta ett exception **/
        Scanner scan = new Scanner(System.in);
        System.out.println("Skriv ett valfritt nummer:");

        /*try {
            int number = scan.nextInt();
            System.out.println(number);
        } catch (Exception e) {
            System.out.println("Det får bara stå nummer här!");
        }*/

        list2 = new ArrayList<>();
        list2.add(1);

        try {
            System.out.println(list2.get(1));
        } catch(NullPointerException e) {
            System.out.println("Din lista är null");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indexet är out of bounds");
        } catch (Exception e) {
            System.out.println("Någonting annat har gått fel nu");
        } finally {
            System.out.println("Här kan vi stänga våra öppna anslutningar eller liknande");
        }
    }
}
