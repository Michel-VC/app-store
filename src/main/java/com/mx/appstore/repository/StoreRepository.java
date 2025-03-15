package com.mx.appstore.repository;

import com.mx.appstore.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface para acceso a base de datos, extiende de JpaRepository. Se define como un Bean
 *
 * @author Michel Velázquez
 * @version 1.0
 */

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    /**
     * Obtiene una lista registros de la tabla Store filtrados por el campo phone_numbers nulo.
     *
     * @return lista de objetos Store con el criterio indicado.
     */
    List<Store> findByPhoneNumbersIsNull();

    /**
     * Obtiene una lista registros de la tabla Store ordenados por el atributo de firstName de forma ascendente.
     * Se utiliza la notación @Query para personalizar la consulta.
     * @return lista de objetos Store ordenados por el campo firstName.
     */
    @Query("SELECT s FROM Store s ORDER BY s.firstName ASC")
    List<Store> findAllStoresOrderByFirstNameAsc();
}
