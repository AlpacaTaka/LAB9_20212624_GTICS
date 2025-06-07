package com.example.lab9_20212624_gtics.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "proveedores")
public class Proveedor {

    //colocaremos los valores de la tabla junto con sus validaciones

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedores", nullable = false)
    private Integer id;

    private String razon_social;

    private String nombre_comercial;
    private int ruc;
    private Integer telefono;
    private String correo;
    private String web;
    private String direccion;
    private String pais;
    private String representante_legal;
    private String tipo_de_proveedor;
    private String categoria;
    private Double facturacion_dolares;

    private LocalTime fecha_registro;
    private LocalTime ultima_actualizacion;
    private boolean estado;

}
