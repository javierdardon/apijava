package com.example.facturas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_entidad")
    private String nombreEntidad;

    @Column(name = "numero_factura")
    private String numeroFactura;

    @Column(name = "serie_factura")
    private String serieFactura;

    @Column(name = "fecha_emision")
    private String fechaEmision;

    @Column(name = "fecha_cobro")
    private String fechaCobro;

    @Column(name = "base64_content")
    private String base64Content;

    private int codmua;
    @Column(name = "comub")
    private int codmub;
}
