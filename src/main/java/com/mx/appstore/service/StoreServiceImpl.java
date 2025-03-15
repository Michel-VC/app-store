package com.mx.appstore.service;

import com.mx.appstore.model.Store;
import com.mx.appstore.repository.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que implementa los métodos definidos en la interface StoreService, se declara como Bean
 *
 * @author Michel Velázquez
 * @version 1.0
 */
@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;

    /**
     * Constructor del controlador.
     *
     * @param storeRepository Es el bean que gestiona el acceso a la base de datos.
     */
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    /**
     * Obtiene una lista registros de la tabla Store ordenados por el atributo de firstName de forma ascendente.
     *
     * @return lista de objetos Store ordenados por el campo firstName.
     */
    @Override
    public List<Store> findAllWithFilter() {
        return storeRepository.findByPhoneNumbersIsNull();
    }

    /**
     * Metodo que guarda o actualiza un registro en la tabla store.
     *
     * @param store es el objeto a guardar o actualizar. El campo internalId nulo, indica un nuevo objeto
     *              internalId no nulo, indica una actualización.
     */
    @Override
    public void save(Store store) {
        storeRepository.save(store);
    }

    /**
     * Obtiene una lista registros de la tabla Store ordenados por el atributo de firstName de forma ascendente.
     *
     * @return lista de objetos Store ordenados por el campo firstName.
     */
    @Override
    public List<Store> findAllSortFirstName() {
        return storeRepository.findAllStoresOrderByFirstNameAsc();
    }

    /**
     * Obtiene un objeto tipo Store buscando en la base de datos por internalId.
     *
     * @return objeto de tipo Store encontrado, nulo si no se encuentra.
     */
    @Override
    public Store findById(Integer id) {
        return storeRepository.findById(id).orElse(null);
    }

    /**
     * Verifica si existe un objeto tipo Store buscando en la base de datos por internalId.
     *
     * @return falso o verdadero según la búsqueda.
     */
    @Override
    public boolean existsById(Integer id) {
        return storeRepository.existsById(id);
    }

    /**
     * Elimina un registro de la tabla Store por id.
     *
     * @param id es el internalId del objeto Store a eliminar. Se debe conocer al momento de realizar la eliminiación.
     */
    @Override
    public void deleteById(Integer id) {
        storeRepository.deleteById(id);
    }
}
