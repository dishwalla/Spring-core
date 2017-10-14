package ua.epam.spring.hometask.dao;

import ua.epam.spring.hometask.domain.Auditorium;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by dish on 04.10.17.
 */
public class MapAuditoriumRepository implements AuditoriumRepository {
    
    private static Map<String, Auditorium> auditoriums;
    
    public MapAuditoriumRepository(LinkedHashMap<String, Auditorium> auditoriums){
        this.auditoriums = auditoriums;
    }
    
    @Override
    public Set<Auditorium> getAll() {
        //FIXME: if you do that to show auditoriums on screen it's bad practice to mix logic of methods
        //DONE
        //FIXME: what's problem to return initial map? or auditoriums.values() ?
        //DONE
        return new HashSet<>(auditoriums.values());
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
