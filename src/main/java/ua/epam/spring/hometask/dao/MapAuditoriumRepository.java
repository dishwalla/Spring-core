package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 04.10.17.
 */
public class MapAuditoriumRepository implements AuditoriumRepository {
    
    private static Map<String, Auditorium> auditoriums;
    private static Set<Auditorium> aud = new HashSet<Auditorium>();
    
    public MapAuditoriumRepository(LinkedHashMap<String, Auditorium> auditoriums){
        this.auditoriums = auditoriums;
    }
    
    @Override
    public Set<Auditorium> getAll() {
        for (Map.Entry entry : auditoriums.entrySet()) {
            aud.add((Auditorium)entry.getValue());
            System.out.println(entry.getValue().toString());
        }
        return aud;
    }
    
    @Override
    public Auditorium getByName(String name) {
        Auditorium auditorium = null;
        for (Map.Entry auditoriumEntry : auditoriums.entrySet()) {
            auditorium = (Auditorium)auditoriumEntry.getValue();
            if (auditorium.getName() != null && name.equals(auditorium.getName())) {
                return auditorium;
            }
        }
        return auditorium;
    }
    
    @Override
    public Set<String> getAuditoriumNames(){
        return auditoriums.keySet();
    }
}
