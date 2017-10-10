package ua.epam.spring.hometask.service.strategies;

import java.util.Date;

/**
 * Created by dish on 10.10.17.
 */
public class BirthdayStrategy implements DiscountStrategy {
    
    public static int FIVE_DAYS = 5*24*60*60*1000;
    @Override
    public int getDiscountPercentage(Date eventDate, Date bd, long ticketCount) {
        if (Math.abs(eventDate.getTime() - bd.getTime()) < FIVE_DAYS){
            return 5;
        }
        return 0;
    }
}
