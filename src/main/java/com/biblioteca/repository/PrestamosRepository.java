package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.biblioteca.models.Prestamo;


public interface PrestamosRepository extends JpaRepository<Prestamo, Integer>, JpaSpecificationExecutor<Prestamo>{

}
