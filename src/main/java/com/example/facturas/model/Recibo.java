package com.example.facturas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Data
@Table(name = "recibos")
public class Recibo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "recibo")
    private String numeroRecibo;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "total")
    private Double total;

    @Column(name = "cod_muni")
    private int codmuni;

    @Column(name = "cod_depto")
    private int coddepto;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "cod_caj")
    private int codcaj;

    @Column(name = "base64_content")
    private String base64Content;
}
