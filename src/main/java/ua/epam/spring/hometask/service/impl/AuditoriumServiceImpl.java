package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.AuditoriumRepository;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by dish on 01.10.17.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    
    private AuditoriumRepository auditoriumRepository;
    
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository){
        this.auditoriumRepository = auditoriumRepository;
    }
    
    @Override
    public Set<Auditorium> getAll() {
        return auditoriumRepository.getAll();
    }
    
    @Override
    public Auditorium getByName(String name) {
       return auditoriumRepository.getByName(name);
    }
    
    @Override
    public Set<String> getAuditoriumNames() {
        return auditoriumRepository.getAuditoriumNames();
    }
    
    @Override
    public Auditorium getRandomAuditorium(){
        List<String> lst = new ArrayList<>(getAuditoriumNames());
        Random rn = new Random();
        int index = rn.nextInt(lst.size());
        String name = lst.get(index);
        return getByName(name);
    }
}
