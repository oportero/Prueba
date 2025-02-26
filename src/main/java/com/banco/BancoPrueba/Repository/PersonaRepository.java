/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.banco.BancoPrueba.Repository;

import com.banco.BancoPrueba.Dto.DtoPersona;
import com.banco.BancoPrueba.Entidades.Persona;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

    @Query("Select p from Persona p")
    List<Persona> obtenerPersonas();
    
    
    @Query("Select new  com.banco.BancoPrueba.Dto.DtoPersona(p.personaId, p.nombre,  p.identificacion)  from Persona p where p.identificacion = :ci")
    Set<DtoPersona> obtenerPersonaDto(@Param("ci")  String ci );

}
