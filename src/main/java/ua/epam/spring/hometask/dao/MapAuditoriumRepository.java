package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 04.10.17.
 */
public class MapAuditoriumRepository implements AuditoriumRepository {
    
    private static Map<Integer, Auditorium> auditoriums;
    
    public MapAuditoriumRepository(LinkedHashMap<Integer, Auditorium> auditoriums){
        this.auditoriums = auditoriums;
        
    }
    @Override
    public Set<Auditorium> getAll() {
        return null;
    }
    
    @Override
    public Auditorium getByName(String name) {
        for (Map.Entry<Integer, Auditorium> auditoriumEntry : auditoriums.entrySet()) {
            if (auditoriumEntry.getValue().getName() != null && name.equals(auditoriumEntry.getValue().getName())){
                return (Auditorium) auditoriumEntry;
            }
        }
        return null;
    }
}
