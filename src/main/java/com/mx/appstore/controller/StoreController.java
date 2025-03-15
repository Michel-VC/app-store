package com.mx.appstore.controller;

import com.mx.appstore.model.Store;
import com.mx.appstore.model.dto.StoreRequestDto;
import com.mx.appstore.model.dto.StoreResponseDto;
import com.mx.appstore.service.StoreService;
import com.mx.appstore.util.Constantes;
import com.mx.appstore.util.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para realizar operaciones especializadas sobre la tabla Store de la base de datos.
 * Utiliza solicitudes HTTP GET y POST para la obtención de registros y el guardado de ellos.
 *
 * @author Michel Velázquez
 * @version 1.0
 */

@RestController
@RequestMapping("/records")
public class StoreController {

    // Crear un logger estático para esta clase
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    private final StoreService storeService;

    /**
     * Constructor del controlador.
     *
     * @param storeService Es el bean de servicio que gestiona los registros de la clase Store.
     */
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * Obtiene una lista registros de la tabla Store filtrados por el campo phone_numbers vacío.
     *
     * @return lista de objetos StoreResponseDto ya formateados y filtrados para obtener la vista final.
     */

    @GetMapping
    private ResponseEntity<List<StoreResponseDto>> findRecordsFiltered() {
        // Se obtiene la lista de objetos encontrados y filtrados
        List<Store> storeListFiltered = storeService.findAllWithFilter();

        logger.info("Registros encontrados filtrados: {}", storeListFiltered);
        // Formate la lista de objetos filtrada a los objetos de salida en el Response
        List<StoreResponseDto> storeResponseDtos = storeListFiltered.stream()
                .map(store -> new StoreResponseDto(store.getLastName(),
                        store.getExternalId(),
                        store.getFirstName()))
                .toList();
        return ResponseEntity.ok(storeResponseDtos);// Se devuelve el resultado del mapeo
    }

    /**
     * Guarda los registros contenidos en un lista de StoreRequestDto obtenido del cuerpo de la petición.
     *
     * @param storesRequest es una Lista de objetos del tipo StoreRequestDto.
     * @return Dependiendo de la validación del parámetro de entrada especifica el detalle de la petición.
     */
    @PostMapping("/save")
    private ResponseEntity<String> saveRecords(@RequestBody List<StoreRequestDto> storesRequest) {
        // Se verifica el tamaño del Json de entrada
        if (storesRequest.isEmpty()) {
            logger.info("El arreglo de registros está vacío...");
            // Respuesta en forma de String en caso de tener una lista vacía
            return ResponseEntity.ok(Constantes.STORE_SAVE_LIST_EMPTY);
        }
        // Ciclo para guardar los elementos de la petición
        for (StoreRequestDto storeToSave : storesRequest) {
            // Mapea el StoreRequest a un Store para ser guardado en la base de datos
            Store store = MapperUtils.mapperStoreResquestToStore(null, storeToSave);
            logger.info("Registro a guardar: {}...", store);
            storeService.save(store);
            logger.info("Registro guardado...");
        }
        return ResponseEntity.ok(Constantes.STORE_SAVE_SUCCESS);// Respuesta de guardado exitoso
    }
}
