package com.example.bicicletas;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.bicicletas.dto.ProductoDTO;
import com.example.bicicletas.service.ProductoService;


@SpringBootApplication
public class BicicletasApplication implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(BicicletasApplication.class);

	private final ProductoService productoService;

	// Inyeccion por constructor 
	public BicicletasApplication(ProductoService productoService) {
		this.productoService = productoService;
	}


	public static void main(String[] args) {
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(BicicletasApplication.class, args);
		LOG.info("APPLICATION FINISHED"); 
		
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING: command line runner");

		///debug de argumentos (para comprobar si llegan o no)
		LOG.info("args.length = {}", args.length);
		for(int i=0; i<args.length; i++) {
			LOG.info("args[{}]: '{}'", i, args[i]);
		}

		//si no hay argumentos, no accedes a args[0]
		/*if (args.length == 0) {
			LOG.info("Sin argumentos. Usa: readAll | readById <id> | updatePrecio <id> <precio> | createCommit");
			//LOG.warn("No se han pasado argumentos. Usa read|create|update|delete|all");
			return;
		}*/

		String cmd = (args.length > 0) ? args[0].toLowerCase() : "help"; //para que no me de problemas de READ, rEAD, etc
		// Pasando un argumento, ejecuto solo esa parteh
		//String cmd= "maptest"; //para probar el mapeo sin necesidad de pasar argumentos cada vez por consola
		switch (cmd) {
			case "readall" -> { LOG.info("-- Read all ---");
				productoService.readAll().forEach(p -> LOG.info("{}", p.toString()));
			}

			case "readbyid" -> {
				if (args.length < 2) {
				LOG.warn("Falta el id. Ejemplo: readyById 3");
				return;
			}
			
			int id = Integer.parseInt(args[1]);
			LOG.info(" --- Read by Id: {} ---", id);
			productoService.readProductoById(id).ifPresentOrElse(
				p -> LOG.info("Encontrado: {}", p),
				() ->LOG.warn("No existe producto con id: {}", id)
			);
			}
			
			//case "read" -> testRead();
			case "create" -> {
			ProductoDTO dto = new ProductoDTO();
			dto.setNombre("Producto1");
			dto.setNum_serie("Test-" + System.currentTimeMillis());
			dto.setFab_com(true);
			dto.setOferta(false);
			dto.setPrecio(new BigDecimal("39.99"));
			dto.setCoste_prod(new BigDecimal("18.50"));
			//dto.setTamano("420 mm");
			//dto.setPeso(new BigDecimal(0.30)); no hacen falta, no son columnas obligatorias
			dto.setLinea(1);
			dto.setId_subcat(1); //hay que usar un id de subcategoria que exista

			ProductoDTO creado = productoService.createProducto(dto);
			LOG.info("CREADO: {}", creado);
			LOG.info("ID creado = {}", creado.getId_producto());

			//leer lo que hay en BD
			productoService.readProductoById(creado.getId_producto()).ifPresentOrElse(leido -> LOG.info("LEÍDO DESDE BD (Entity->DTO): {}", leido),
			() -> LOG.warn("No se ha encontrado el producto recien creado (raro)"));
			}

			case "updateprecio" -> {
				if (args.length < 3) {
					LOG.warn("Uso: updatePrecio <id> <precio>");
					return;
				}
				int id1 = Integer.parseInt(args[1]);
				BigDecimal precio2 = new BigDecimal(args[2]);

				productoService.updatePrecio(id1, precio2).ifPresentOrElse(
					actualizado -> LOG.info("Actualizado: {}", actualizado),
					() -> LOG.warn("No existe el producto con el id {}", id1)
				);

			}
			//case "update" > testUpdate();
			case "delete" -> {
				if (args.length < 2) {
					LOG.warn("Uso: delete <id>");
					return;
				}
				int id2 = Integer.parseInt(args[1]);
				productoService.deleteProducto(id2);

				LOG.info("ID eliminado = {}", id2);
			}

			case "maptest" -> {
				LOG.info("-- MAP TEST (DTO -> ENTITY -> DTO) ---");

				ProductoDTO dto = new ProductoDTO();
				dto.setNombre("DTO prueba");
				dto.setNum_serie("MAP-" + System.currentTimeMillis());
				dto.setFab_com(true);
				dto.setOferta(false);
				dto.setPrecio(new BigDecimal("10.00"));
				dto.setCoste_prod(new BigDecimal("5.00"));
				dto.setLinea(1);
				dto.setId_subcat(1);

				ProductoDTO vuelta = productoService.mapRoundTrip(dto);
					LOG.info("DTO original: {}", dto);
					LOG.info("DTO vuelta: {}", vuelta);
				}


			/*case "all" -> {
				testRead();
				testCreate();
				testUpdate();
				testDelete();
			}*/
			//default -> LOG.warn("Comando no válido: {}. Usa read|create|update|delete|all", args[0]);
			default -> LOG.warn("Comando no valido: {}. Usa readAll | readById <id> | updatePrecio <id> <precio> | create", cmd);
		}
	}
}

	/*private void testRead() {
		LOG.info("--- Read all ---");
		service.readAll().forEach(p -> LOG.info("{}", p));
	}*/


		






//hacer pruebas de coger algun objeto DTO y guardarlo en base de datos -> de dto a entity y de entity a dto
//gestionar excepciones
