package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 01.10.17.
 */
public class MapTicketRepository implements TicketRepository{
    
    private static Map<Integer, Ticket> users = new ConcurrentHashMap<>();
    
    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
        return 0;
    }
    
    @Override
    public void bookTickets(Set<Ticket> tickets) {
        
    }
    
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return null;
    }
}
