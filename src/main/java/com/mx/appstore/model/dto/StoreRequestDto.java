package com.mx.appstore.model.dto;

import java.util.List;

/**
 * Dto para obtener los datos del cuerpo de la petición.
 */
public class StoreRequestDto {

    // Declaración de atributos que coinciden con el Json de la petición
    private List<String> phone_numbers;
    private String last_name;
    private String external_id;
    private String first_name;

    // Settes y Getters
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

    // Metodo toString
    @Override
    public String toString() {
        return "StoreRequestDto{" +
                ", phone_numbers=" + phone_numbers +
                ", last_name='" + last_name + '\'' +
                ", external_Id='" + external_id + '\'' +
                ", first_name='" + first_name + '\'' +
                '}';
    }
}
