package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by dish on 01.10.17.
 */
public interface TicketRepository {
    
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats);
    
    public void bookTickets(Set<Ticket> tickets);
   
    public Set<Ticket> getPurchasedTicketsForEvent(Event event,LocalDateTime dateTime);
}
