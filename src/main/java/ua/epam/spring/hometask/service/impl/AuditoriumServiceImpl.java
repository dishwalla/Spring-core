package ua.epam.spring.hometask.service.impl;

import ua.epam.spring.hometask.dao.AuditoriumRepository;
import ua.epam.spring.hometask.domain.Auditorium;
import ua.epam.spring.hometask.service.AuditoriumService;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Set;

/**
 * Created by dish on 01.10.17.
 */
public class AuditoriumServiceImpl implements AuditoriumService {
    
    private AuditoriumRepository auditoriumRepository;
    
    @Override
    public Set<Auditorium> getAll() {
        return null;
    }
    
    @Override
    public Auditorium getByName(@Nonnull String name) {
        return null;
    }
}
