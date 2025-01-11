package com.biblioteca.service;

import java.util.List;

import com.biblioteca.models.Prestamo;

public interface PrestamoService {
	List<Prestamo> listarPrestamos();

	List<Prestamo> filtrarPrestamos(String fechaInicio, String fechaFin, String estado);
}
