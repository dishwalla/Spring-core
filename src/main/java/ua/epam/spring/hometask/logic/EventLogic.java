package ua.epam.spring.hometask.logic;

import ua.epam.spring.hometask.IdGenerator;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.domain.EventRating;
import ua.epam.spring.hometask.service.impl.EventServiceImpl;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 01.10.17.
 */
public class EventLogic {
    
    private EventServiceImpl eventService;
    
    private static final List<Double> prices = new LinkedList<>(Arrays.asList(10.0, 15.0, 20.0, 25.0, 30.0, 35.0, 45.0, 50.0, 55.0, 60.0));
    private static final List<String> names = new LinkedList<>(Arrays.asList("Film1","Film2","Film3","Film4","Film5","Film6","Film7","Film8","Film9","Film10"));
    private static Map<String, EventRating> ratings = new ConcurrentHashMap<>();
    
    public EventLogic(){
        setRating();
    }
    
    // private static final Set<String> ids = new HashSet<String>();
    // private static final Set<String> names = new HashSet<>(Arrays.asList("Film1", "Film2","Film3","Film4","Film5","Film6","Film7","Film8","Film9","Film10"));
    public EventServiceImpl getEventService() {
        return eventService;
    }
    
    public void setEventService(EventServiceImpl eventService) {
        this.eventService = eventService;
    }
    
    public void showEvents(){
        for(Event event : eventService.getAll()) {
            System.out.println(event.toString());
        }
    }
    
    public void eventGenerator(){
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setId((long) IdGenerator.getNextEventId());
            event.setName(getName());
            event.setBasePrice(getPrice());
            event.setRating(ratings.get(event.getName()));
            LocalDateTime now = LocalDateTime.now();
           // event.addAirDateTime(now);
           // event.addAirDateTime(now.plusDays(1));
            event.addAirDateTime(now.plusDays(2));
           // event.setAuditoriums();
            eventService.save(event);
        }
    }
    
    protected double generateId(){
        int i;
        int g = 1000;
        double randomNum = 0.0;
        Random rn = new Random();
        for (i = 0; i < g; i++) {
            randomNum = rn.nextDouble();
            if(!prices.contains(randomNum)){
                prices.add(randomNum);
                return randomNum;
            } else i++;
        }
        return randomNum;
    }
    protected double getPrice(){
        Random rn = new Random();
        int randomNum = rn.nextInt(10);
        double price = 00.0;
        for (int i = 0; i < prices.size(); i++) {
            price = prices.get(randomNum);
            return price;
        }
        return price;
    }
    
    protected String getName(){
        Random rn = new Random();
        String name = "";
        Collections.shuffle(names, rn);
        for (int i = 0; i < names.size(); i++) {
            return names.iterator().next();
        }
        return name;
    }

    protected void setRating(){
        for(String film : names){
            ratings.put(film, EventRating.getRandom());
        }
    }
}
