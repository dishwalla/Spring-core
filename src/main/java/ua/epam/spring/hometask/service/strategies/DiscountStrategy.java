package ua.epam.spring.hometask.service.strategies;

import java.util.Date;

/**
 * Created by dish on 09.10.17.
 */
public interface DiscountStrategy {
    
    int getDiscountPercentage(Date eventDate, Date bd, long ticketCount);
}
