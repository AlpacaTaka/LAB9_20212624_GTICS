package com.example.lab9_20212624_gtics.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.math.BigDecimal;

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

    @Column(name = "ruc")
    @Size(min = 11, max = 11, message = "El RUC debe tener exactamente 11 dígitos")
    private String ruc;

    private Integer telefono;

    private String correo;

    private String web;

    @Size(max = 150, message = "La dirección no puede exceder los 150 caracteres")
    private String direccion;

    private String pais;

    private String representante_legal;

    private String tipo_de_proveedor;

    private String categoria;

    @Column(name = "facturacion_dolares", precision = 10, scale = 10)
    private BigDecimal facturacion_dolares;  // Change to BigDecimal to match DECIMAL

    @Column(name = "fecha_registro")
    private LocalDateTime fecha_registro;

    @Column(name = "ultima_actualizacion")
    private LocalDateTime ultima_actualizacion;

    @Column(name = "estado")
    private Boolean estado;

}
