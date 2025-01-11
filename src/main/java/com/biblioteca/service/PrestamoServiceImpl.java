package com.biblioteca.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.criteria.Predicate;


import com.biblioteca.models.Prestamo;
import com.biblioteca.repository.PrestamosRepository;

@Service 
public class PrestamoServiceImpl implements PrestamoService{
	
	@Autowired
	private PrestamosRepository prestamoRepository;

	@Override
	public List<Prestamo> listarPrestamos() {
		// TODO Auto-generated method stub
		return prestamoRepository.findAll();
	}
	
	@Override
	public List<Prestamo> filtrarPrestamos(String fechaInicio, String fechaFin, String estado) {
	    return prestamoRepository.findAll((root, query, cb) -> {
	        List<Predicate> predicates = new ArrayList<>();

	        if (fechaInicio != null && !fechaInicio.isEmpty()) {
	            predicates.add(cb.greaterThanOrEqualTo(root.get("fecha_prestamo"), LocalDate.parse(fechaInicio)));
	        }
	        if (fechaFin != null && !fechaFin.isEmpty()) {
	            predicates.add(cb.lessThanOrEqualTo(root.get("fecha_prestamo"), LocalDate.parse(fechaFin)));
	        }
	        if (estado != null && !estado.isEmpty()) {
	            predicates.add(cb.equal(root.get("estado"), estado.charAt(0)));
	        }

	        return cb.and(predicates.toArray(new Predicate[0]));
	    });
	}


}
