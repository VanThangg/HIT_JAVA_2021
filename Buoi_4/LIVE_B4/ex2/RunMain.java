package ex2;

import java.util.Arrays;

public class RunMain {

    public static void main(String[] args) {

        Address address = new Address("ward", "district", "city");
        Address address2 = new Address("ward2", "district2", "city2");

        Address[] addresses = new Address[2];
        addresses[0] = address;
        addresses[1] = address2;

        Person person = new Person("Name1", 21, addresses);

        Address[] a = person.getAddresses();
        Address add = a[1];
        String city = add.getCity();
        System.out.println(city);

    }

}