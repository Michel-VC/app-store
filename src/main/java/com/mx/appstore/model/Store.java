package com.mx.appstore.model;

import jakarta.persistence.*;

/**
 * Clase que mapea la table store de la base datos para ser manipulada por JPA
 *
 */
@Entity
@Table(name = "Store")
public class Store {

    // Declaración de variables del mapeo hacia la tabla Store en BD
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer internalId;

    @Column(name = "phone_numbers")
    String phoneNumbers;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "external_id")
    String externalId;

    @Column(name = "first_name")
    String firstName;

    /**
     * Constructor del controlador.
     *
     * @param internalId, phoneNumbers, lastName, externalId, firstName son datos dependiendo
     *                    el proceso a realizar. Se mantiene el id para temas de actualización
     */
    public Store(Integer internalId, String phoneNumbers, String lastName, String externalId, String firstName) {
        this.internalId = internalId;
        this.phoneNumbers = phoneNumbers;
        this.lastName = lastName;
        this.externalId = externalId;
        this.firstName = firstName;
    }

    /**
     * Constructor del controlador sin argumentos.
     * Se utiliza para crear objetos con uno o más atributos nulos
     */
    public Store() {
    }

    // Inicio de setters y getters
    public Integer getInternalId() {
        return internalId;
    }

    public void setInternalId(Integer internalId) {
        this.internalId = internalId;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    // Fin de setters y getters

    // Declaración del method toString
    @Override
    public String toString() {
        return "Store{" +
                "internalId=" + internalId +
                ", phoneNumbers='" + phoneNumbers + '\'' +
                ", lastName='" + lastName + '\'' +
                ", externalId='" + externalId + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
