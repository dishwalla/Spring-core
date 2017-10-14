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
    
    //FIXME: again, looks like you pass arguments and do not use them all (it would be ok in strategy, but not here)
    //This signature was defined in skeleton project, so I didn't touch it
    @Override
    public byte getDiscount(User user, Event event, Date airDateTime, long numberOfTickets) {
        return (byte)discountStrategy.getDiscountPercentage(user, event, airDateTime, numberOfTickets);
    }
}
