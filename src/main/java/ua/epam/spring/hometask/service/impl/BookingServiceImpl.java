package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.BookingService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by dish on 01.10.17.
 */
public class BookingServiceImpl implements BookingService{
    
    
    @Override
    public double getTicketsPrice(Event event, LocalDateTime dateTime, User user, Set<Long> seats) {
        return 0;
    }
    
    @Override
    public void bookTickets(@Nonnull Set<Ticket> tickets) {
        
    }
    
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, LocalDateTime dateTime) {
        return null;
    }
}
