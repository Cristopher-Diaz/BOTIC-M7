package fase2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestamo {
    private int idUsuario;
    private String nombreLibro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
}
