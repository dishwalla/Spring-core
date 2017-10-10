package ua.epam.spring.hometask.logic;

import ua.epam.spring.hometask.service.BookingService;

/**
 * Created by dish on 01.10.17.
 */
public class TicketLogic {
    private BookingService bookingService;
    
    public BookingService getBookingService() {
        return bookingService;
    }
    
    public void setBookingService(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    
}
