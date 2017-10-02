package ua.epam.spring.hometask;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dish on 02.10.17.
 */
public class IdGenerator {
    
    public static AtomicInteger userID = new AtomicInteger(0);
    public static AtomicInteger ticketID = new AtomicInteger(0);
    public static AtomicInteger EventID = new AtomicInteger(0);
    
    public static int getNextUserId(){
        return userID.incrementAndGet();
    }
    public static int getNextTicketId(){
        return ticketID.incrementAndGet();
    }
    public static int getNextEventId(){
        return EventID.incrementAndGet();
    }
}
