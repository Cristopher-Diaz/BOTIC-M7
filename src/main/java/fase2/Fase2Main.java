package fase2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fase2Main {
    public static void main(String[] args) {
        PrestamoService prestamoService = new PrestamoService();
        Scanner scanner = new Scanner(System.in);

        // Datos simulados
        List<Prestamo> prestamos = Arrays.asList(
                new Prestamo(1, "El Quijote", LocalDate.of(2024, 12, 10), LocalDate.of(2024, 12, 20)),
                new Prestamo(2, "Cien Años de Soledad", LocalDate.of(2024, 12, 15), LocalDate.of(2024, 12, 25)),
                new Prestamo(1, "Sapiens", LocalDate.of(2024, 12, 20), LocalDate.of(2024, 12, 27)),
                new Prestamo(3, "Historia de la Humanidad", LocalDate.of(2024, 11, 5), LocalDate.of(2024, 11, 12))
        );

        System.out.println("Seleccione una opción:");
        System.out.println("1. Verificar devoluciones tardías");
        System.out.println("2. Calcular préstamos por usuario en un mes y año específico");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.print("Ingrese el ID del usuario: ");
            int idUsuario = scanner.nextInt();
            prestamoService.verificarDevolucionesTardias(idUsuario, prestamos);
        } else if (opcion == 2) {
            System.out.print("Ingrese el ID del usuario: ");
            int idUsuario = scanner.nextInt();
            System.out.print("Ingrese el mes (1-12): ");
            int mes = scanner.nextInt();
            System.out.print("Ingrese el año (YYYY): ");
            int año = scanner.nextInt();
            prestamoService.calcularPrestamosPorUsuario(idUsuario, mes, año, prestamos);
        } else {
            System.out.println("Opción no válida.");
        }
    }
}

