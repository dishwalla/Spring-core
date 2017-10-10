package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.User;
import ua.epam.spring.hometask.service.DiscountService;
import ua.epam.spring.hometask.service.strategies.DiscountStrategy;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by dish on 01.10.17.
 */
public class DiscountServiceImpl implements DiscountService {
    
    private DiscountStrategy discountStrategy;
    
    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }
    
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    @Override
    public byte getDiscount(User user, Event event, Date airDateTime, long numberOfTickets) {
        return (byte)discountStrategy.getDiscountPercentage(airDateTime, user.getBirthday(), numberOfTickets);
    }
}
