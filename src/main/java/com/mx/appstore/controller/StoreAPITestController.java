package com.mx.appstore.controller;

import com.mx.appstore.model.Store;
import com.mx.appstore.model.dto.StoreRequestDto;
import com.mx.appstore.service.StoreService;
import com.mx.appstore.util.Constantes;
import com.mx.appstore.util.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la API sobre la tabla Store de la base de datos.
 *
 * @author Michel Velázquez
 * @version 1.0
 */

@RestController
@RequestMapping("/records/customers")
public class StoreAPITestController {

    // Crear un logger estático para esta clase
    private static final Logger logger = LoggerFactory.getLogger(StoreAPITestController.class);
    private final StoreService storeService;

    /**
     * Constructor del controlador.
     *
     * @param storeService Es el bean de servicio que gestiona los registros de la clase Store.
     */
    public StoreAPITestController(StoreService storeService) {
        this.storeService = storeService;
    }

    /**
     * Obtiene una lista registros de la tabla Store ordenados por el atributo de firstName de forma ascendente.
     *
     * @return lista de objetos Store ordenados por el campo firstName.
     */
    @GetMapping("/test")
    private ResponseEntity<List<Store>> findAllRecordsWithSort() {
        // Obtiene la lista de objetos
        List<Store> list = storeService.findAllSortFirstName();
        logger.info("Registros encontrados: {}", list);
        return ResponseEntity.ok(list);// Enviamos la respuesta con estatus 200
    }

    /**
     * Actualiza un registro de la tabla store, enviando un id en la petición.
     *
     * @param id              es el internalId del objeto Store a actualizar. Se debe conocer al momento de realizar la actualización
     * @param storeRequestDto es un objeto en el cuerpo de la petición.
     * @return String con una observación sobre el proceso realizado.
     */
    @PutMapping("/{id}/test")
    private ResponseEntity<String> putRecordStore(@PathVariable Integer id, @RequestBody StoreRequestDto storeRequestDto) {
        logger.info("Registro a buscar con id: {}", id);
        // Buscamos el objeto Store por id
        Store updateStore = storeService.findById(id);
        if (updateStore != null) { // Si se encuentra el registro
            logger.info("Registro encontrado: {}", updateStore);
            // Mapea el StoreRequestDto a Store para ser actualizado con el metodo save
            Store updatedStore = MapperUtils.mapperStoreResquestToStore(updateStore.getInternalId(),
                    storeRequestDto);
            logger.info("Se guardará el registro: {}", updatedStore);
            storeService.save(updatedStore);
            logger.info("Se guardó el registro...");
            return ResponseEntity.ok(Constantes.STORE_UPDATE_SUCCESS);
        }
        // No se encontró el registro
        logger.info("No se localízó el registro con id: {}", id);
        return ResponseEntity.ok(Constantes.STORE_NOT_FOUND);
    }

    /**
     * Elimina un registro de la tabla Store por id.
     *
     * @param id es el internalId del objeto Store a eliminar. Se debe conocer al momento de realizar la eliminiación.
     * @return String con una observación sobre el proceso realizado.
     */
    @DeleteMapping("/{id}/test")
    private ResponseEntity<String> deleteStore(@PathVariable Integer id) {
        // Verifica si existe el registro por id
        if (storeService.existsById(id)) {// Existe el registro
            logger.info("Se eliminará el registro con id: {}", id);
            storeService.deleteById(id); // Se elimina registro
            logger.info("Objeto eliminado...");
            return ResponseEntity.ok(Constantes.STORE_DELETE_SUCCESS);// Respuesta
        }
        // No existe el registro
        logger.info("El objeto con id: {} no existe", id);
        return ResponseEntity.ok(Constantes.STORE_NOT_FOUND);
    }

    /**
     * Guarda un registro de la tabla Store.
     *
     * @param storeRequestDto es el Json del cuerpo de la petición para guardarse en base de datos.
     * @return String con una observación sobre el proceso realizado.
     */
    @PostMapping("/test")
    private ResponseEntity<String> postStore(@RequestBody StoreRequestDto storeRequestDto) {
        // Dado que el storeRequestDto no tiene un id, se mapea el objeto para guardarse como Store
        Store storeToSave = MapperUtils.mapperStoreResquestToStore(null, storeRequestDto);
        logger.info("Se guardará el registro: {}", storeToSave);
        storeService.save(storeToSave);// Se guarda el registro
        logger.info("Registro guardado...");
        // Envía la respuesta con estatus 201
        return new ResponseEntity<>(Constantes.STORE_SAVE_SUCCESS_SINGLE, HttpStatus.CREATED);
    }
}
