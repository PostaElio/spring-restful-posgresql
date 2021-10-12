package com.example.demo.models;

import javax.persistence.*;
import java.io.Serializable;

//spring.jpa.hibernate.ddl-auto=update nos permite crear tablas en nuestra base de datos
@Entity //Modelo real
@Table(name="usuario") //Nombre de la tabla
public class UsuarioModel implements Serializable {
    /*
    {
    "id": 1,
    "nombre": "Elio",
    "email": "postaelio76@gmail.com",
    "prioridad": 2
    }
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Genera un valor de identidad
    @Column(unique = true,nullable = false) //El valor es unico y no puede ser nulo
    private Long id;
    private String nombre;
    private String email;
    private Integer prioridad;

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

}

