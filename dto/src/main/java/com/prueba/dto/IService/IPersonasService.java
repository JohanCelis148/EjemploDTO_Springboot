package com.prueba.dto.IService;

import java.util.List;
import java.util.Optional;

import com.prueba.dto.Dto.PersonasDto;
import com.prueba.dto.Entity.Personas;

public interface IPersonasService {
public List<Personas> all();
    
    public Optional<Personas> findById(Integer id);
    
    public Personas save(Personas persons);
    
    public void delete(Integer id);
    
    public PersonasDto login(String user, String password);
}
