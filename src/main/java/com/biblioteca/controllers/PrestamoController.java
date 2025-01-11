package com.biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.biblioteca.models.Prestamo;
import com.biblioteca.service.PrestamoService;

import java.util.List;

@Controller
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    /**
     * Carga la página principal de préstamos con los datos iniciales.
     */
    @GetMapping
    public String mostrarPrestamos(Model model) {
        List<Prestamo> prestamos = prestamoService.listarPrestamos();
        model.addAttribute("prestamos", prestamos);
        return "prestamos"; // Renderiza el archivo prestamos.html en templates
    }

    /**
     * Filtra los préstamos según las condiciones dadas y redirige a la misma página con resultados filtrados.
     */
    @GetMapping("/filtrar")
    public String filtrarPrestamos(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            @RequestParam(required = false) String estado,
            Model model) {

        List<Prestamo> prestamos = prestamoService.filtrarPrestamos(fechaInicio, fechaFin, estado);
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("fechaInicio", fechaInicio);
        model.addAttribute("fechaFin", fechaFin);
        model.addAttribute("estado", estado);
        return "prestamos"; // Renderiza la misma página con los resultados filtrados
    }

    /**
     * Devuelve los préstamos en formato JSON para un consumo API.
     */
    @GetMapping("/api")
    @ResponseBody
    public List<Prestamo> obtenerPrestamosAPI() {
        return prestamoService.listarPrestamos();
    }

    /**
     * Filtra préstamos para consumo API.
     */
    @GetMapping("/api/filtrar")
    @ResponseBody
    public List<Prestamo> filtrarPrestamosAPI(
            @RequestParam(required = false) String fechaInicio,
            @RequestParam(required = false) String fechaFin,
            @RequestParam(required = false) String estado) {

        return prestamoService.filtrarPrestamos(fechaInicio, fechaFin, estado);
    }
}
