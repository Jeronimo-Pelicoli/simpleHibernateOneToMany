package com.pluralsight.hibernatefundamentals;

import com.pluralsight.hibernatefundamentals.airport.Airport;
import com.pluralsight.hibernatefundamentals.airport.Passenger;
import com.pluralsight.hibernatefundamentals.airport.Ticket;

import javax.persistence.*;

public class main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernatefundamentals.m02.ex01");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        // Set Airport
        Airport airport = new Airport(1, "Henri Coanda");
        //Set passenger
        Passenger john = new Passenger(1, "John Smith");
        //Set passenger at airport
        john.setAirport(airport);
        // create and set mike
        Passenger mike = new Passenger(2, "Michael Johnson");
        mike.setAirport(airport);
        //add passenger at airport
        airport.addPassenger(john);
        airport.addPassenger(mike);
        //create ticket and add passenger John
        Ticket ticket1 = new Ticket(1, "AA1234");
        ticket1.setPassenger(john);
        Ticket ticket2 = new Ticket(2, "BB5678");
        ticket2.setPassenger(john);
        john.addTicket(ticket1);
        john.addTicket(ticket2);
        //create ticket and add passenger Mike
        Ticket ticket3 = new Ticket(3, "CC0987");
        ticket3.setPassenger(mike);
        mike.addTicket(ticket3);
        //persiste date
        em.persist(airport);
        em.persist(john);
        em.persist(mike);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);

        em.getTransaction().commit();

        emf.close();
    }
}
