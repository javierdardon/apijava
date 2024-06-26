package com.example.facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.example.facturas.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long> {

    // Método para devolver todas las facturas para admin
    @Query("SELECT f.nombreEntidad, f.numeroFactura, f.serieFactura, f.fechaEmision, f.fechaCobro FROM Factura f")
    List<Object[]> findAllFacturasForAdmin();

    // Método para devolver facturas por codmua y codmub para usuarios no admin
    @Query("SELECT f.nombreEntidad, f.numeroFactura, f.serieFactura, f.fechaEmision, f.fechaCobro FROM Factura f WHERE f.codmua = :codmua AND f.codmub = :codmub")
    List<Object[]> findFacturasByCodmuaAndCodmub(@Param("codmua") int codmua, @Param("codmub") int codmub);

    // Método para devolver base64 de una factura específica
    @Query("SELECT f.base64Content FROM Factura f WHERE f.numeroFactura = :numeroFactura AND f.serieFactura = :serieFactura")
    String findBase64ContentByNumeroFacturaAndSerieFactura(@Param("numeroFactura") String numeroFactura,
            @Param("serieFactura") String serieFactura);
}
