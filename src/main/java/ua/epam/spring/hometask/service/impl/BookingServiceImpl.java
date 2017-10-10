package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.TicketRepository;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.Ticket;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.BookingService;
import ua.epam.spring.hometask.service.DiscountService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by dish on 01.10.17.
 */
public class BookingServiceImpl implements BookingService{
    
    private TicketRepository ticketRepository;
    private DiscountService discountService;
    
    public BookingServiceImpl(TicketRepository repository, DiscountService discountService){
        ticketRepository = repository;
        this.discountService = discountService;
        
    }
    @Override
    public double getTicketsPrice(Event event, Date dateTime, User user, Set<Long> seats) {
        long vipSeats = event.getAuditoriums().get(dateTime).countVipSeats(seats);
        double vipPrice = vipSeats * 2 * event.getBasePrice();
        double regularPrice = (seats.size() - vipSeats) * event.getBasePrice();
        double totalPrice = vipPrice + regularPrice;
        return totalPrice - totalPrice/100 * discountService.getDiscount(user, event, dateTime, seats.size());
    }
    
    @Override
    public void bookTickets(Set<Ticket> tickets) {
        Set<Ticket> ticketSet = tickets.stream()
            .filter(t -> t.getUser() != null)
            .collect(Collectors.toSet());
        ticketRepository.bookTickets(ticketSet);
        
    }
    
    @Override
    public Set<Ticket> getPurchasedTicketsForEvent(Event event, Date dateTime) {
        return ticketRepository.getPurchasedTicketsForEvent(event, dateTime);
    }
}
