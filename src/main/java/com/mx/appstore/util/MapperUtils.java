package com.mx.appstore.util;

import com.mx.appstore.model.Store;
import com.mx.appstore.model.dto.StoreRequestDto;

/**
 * Clase de Utilidad para el mapeo de clases persistentes y Dto´s
 *
 * @author Michel Velázquez
 * @version 1.0
 */
public class MapperUtils {

    /**
     * Obtiene una lista registros de la tabla Store filtrados por el campo phone_numbers vacío.
     *
     * @param id es el internalId del objeto Store a mapear, en caso de que se conozca, puede ser nulo.
     * @return Objeto tipo Store para ser utilizado por los service y a su vez por los repository
     */
    public static Store mapperStoreResquestToStore(Integer id, StoreRequestDto storeRequestDto) {
        return new Store(id, // Puede ser nulo, dependiendo el metodo aplicado (update o save)
                // Verifica si el campo de phone_numbers del request es nulo, en caso contrario concatena los strings incluidos
                storeRequestDto.getPhone_numbers().isEmpty() ? null
                        : String.join(",", storeRequestDto.getPhone_numbers()),
                storeRequestDto.getLast_name(),
                storeRequestDto.getExternal_id(),
                storeRequestDto.getFirst_name()
        );
    }
}
