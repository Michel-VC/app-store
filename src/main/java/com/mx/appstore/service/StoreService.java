package com.mx.appstore.service;

import com.mx.appstore.model.Store;
import java.util.List;

/**
 * Interface que define las funciones para un objeto Store dado
 *
 * @author Michel Velázquez
 * @version 1.0
 */
public interface StoreService {

    List<Store> findAllWithFilter();

    void save(Store store);

    List<Store> findAllSortFirstName();

    Store findById(Integer id);

    void deleteById(Integer id);

    boolean existsById(Integer id);
}
