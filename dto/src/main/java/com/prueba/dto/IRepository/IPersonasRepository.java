package com.prueba.dto.IRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.dto.Entity.Personas;

public interface IPersonasRepository extends JpaRepository<Personas, Integer>{

	Personas findByUserAndPassword(String user, String password);

}
