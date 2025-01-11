package fase2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamoService {

    /**
     * Verifica si un usuario tiene préstamos vencidos y genera una alerta.
     */
    public void verificarDevolucionesTardias(int idUsuario, List<Prestamo> prestamos) {
        List<String> librosVencidos = new ArrayList<>();
        LocalDate hoy = LocalDate.now();

        for (Prestamo prestamo : prestamos) {
            if (prestamo.getIdUsuario() == idUsuario &&
                prestamo.getFechaDevolucion() != null &&
                prestamo.getFechaDevolucion().isBefore(hoy.minusDays(7))) {
                librosVencidos.add(prestamo.getNombreLibro());
            }
        }

        if (librosVencidos.isEmpty()) {
            System.out.println("El usuario no tiene préstamos vencidos.");
        } else {
            System.out.println("El usuario tiene préstamos vencidos: " + librosVencidos);
        }
    }

    /**
     * Calcula el total de préstamos realizados por un usuario en un mes y año específicos.
     */
    public void calcularPrestamosPorUsuario(int idUsuario, int mes, int año, List<Prestamo> prestamos) {
        long totalPrestamos = prestamos.stream()
                .filter(p -> p.getIdUsuario() == idUsuario &&
                        p.getFechaPrestamo() != null &&
                        p.getFechaPrestamo().getMonthValue() == mes &&
                        p.getFechaPrestamo().getYear() == año)
                .count();

        System.out.println("El usuario " + idUsuario + " realizó " + totalPrestamos +
                " préstamos en " + mes + "/" + año + ".");
    }
}
