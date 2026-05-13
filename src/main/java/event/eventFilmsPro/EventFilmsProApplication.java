package event.eventFilmsPro;

import event.eventFilmsPro.model.Almacenamiento;
import event.eventFilmsPro.service.AlmacenamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class EventFilmsProApplication implements CommandLineRunner {

	@Autowired
	private AlmacenamientoService almacenamientoService;

	public static void main(String[] args) {
		SpringApplication.run(EventFilmsProApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			System.out.println("\n MENÚ CRUD ALMACENAMIENTOS");
			System.out.println("1. Insertar Almacenamiento");
			System.out.println("2. Listar Almacenamientos");
			System.out.println("3. Actualizar Ubicación");
			System.out.println("0. Salir");
			System.out.print("Elige una opción: ");

			opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
				case 1:
					Almacenamiento nuevo = new Almacenamiento();
					System.out.print("Nombre del equipo/material: ");
					nuevo.setNombre(scanner.nextLine());
					System.out.print("Tamaño (ej. Grande, Pequeño): ");
					nuevo.setTamano(scanner.nextLine());
					System.out.print("Condiciones (ej. Nuevo, Usado): ");
					nuevo.setCondiciones(scanner.nextLine());
					System.out.print("Ubicación en el local: ");
					nuevo.setUbicacion(scanner.nextLine());
					nuevo.setActivo(true);

					almacenamientoService.guardar(nuevo);
					System.out.println(" Guardado con éxito.");
					break;
				case 2:
					System.out.println("\n--- Lista de Almacenamiento ---");
					almacenamientoService.listarTodos().forEach(a ->
							System.out.println("ID: " + a.getId() + " | Nombre: " + a.getNombre() + " | Ubicación: " + a.getUbicacion())
					);
					System.out.println("-------------------------------");
					break;
				case 3:
					System.out.print("Ingrese el ID del almacenamiento a actualizar: ");
					Long idActualizar = scanner.nextLong();
					scanner.nextLine();
					System.out.print("Ingrese la NUEVA UBICACIÓN: ");
					String nuevaUbi = scanner.nextLine();

					if (almacenamientoService.actualizarUbicacion(idActualizar, nuevaUbi) != null) {
						System.out.println(" Ubicación actualizada con éxito.");
					} else {
						System.out.println(" Error: No se encontró un registro con ese ID.");
					}
					break;
				case 0:
					System.out.println("Saliendo...");
					break;
				default:
					System.out.println("Opción no válida.");
					break;
			}
		}
	}
}