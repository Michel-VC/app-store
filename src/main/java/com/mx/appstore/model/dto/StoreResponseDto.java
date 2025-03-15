package com.mx.appstore.model.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Dto para regresar un objeto Store sin id versus la base de datos.
 */
public class StoreResponseDto {

    // Declaración de atributos para la respuesta
    private List<String> phone_numbers;
    private String last_name;
    private String external_id;
    private String first_name;

    /**
     * Constructor del controlador.
     *
     * @param lastName es el campo del objeto Store lastName
     * @param externalId es el campo del objeto Store externalId
     * @param firstName es el campo del objeto Store firsName
     */
    public StoreResponseDto(String lastName, String externalId, String firstName) {
        phone_numbers = new ArrayList<>();// Por definición el atributo es nulo.
        last_name = lastName;
        external_id = externalId;
        first_name = firstName;
    }

    // Setters y Getters (no se ocupan pero se mantienen por práctica para agregar o quitar funciones futuras).
    public List<String> getPhone_numbers() {
        return phone_numbers;
    }

    public void setPhone_numbers(List<String> phone_numbers) {
        this.phone_numbers = phone_numbers;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
}
