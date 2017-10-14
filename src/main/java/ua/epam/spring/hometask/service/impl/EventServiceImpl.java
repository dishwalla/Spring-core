package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.EventRepository;
import ua.epam.spring.hometask.domain.Event;
import ua.epam.spring.hometask.service.EventService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collection;

/**
 * Created by dish on 01.10.17.
 */
public class EventServiceImpl implements EventService {
    
    private EventRepository eventRepository;
    
    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository = eventRepository;
    }
    
    @Override
    public Event getByName(String name) {
        return eventRepository.getByName(name);
    }
    
    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }
    
    @Override
    public void remove(Event event) {
        eventRepository.remove(event);
    }
    
    @Override
    public Event getById(Long id) {
        return eventRepository.getById(id);
    }
    
    @Override
    public Collection<Event> getAll() {
        return eventRepository.getAll();
    }
}
