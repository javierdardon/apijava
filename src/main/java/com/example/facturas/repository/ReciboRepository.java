package com.example.facturas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

import com.example.facturas.model.*;

public interface ReciboRepository extends JpaRepository<Recibo, Long> {

    @Query("SELECT r.numeroRecibo, r.fecha, r.total, r.codmuni, r.coddepto, r.tipo, r.codcaj FROM Recibo r")
    List<Object[]> findAllRecibosForAdmin();

    @Query("SELECT r.numeroRecibo, r.fecha, r.total, r.codmuni, r.coddepto, r.tipo, r.codcaj FROM Recibo r WHERE r.coddepto = :coddepto AND r.codmuni = :codmuni")
    List<Object[]> findRecibosByCoddeptoAndCodmuni(@Param("coddepto") int coddepto, @Param("codmuni") int codmuni);

    @Query("SELECT r.base64Content FROM Recibo r WHERE r.numeroRecibo = :numeroRecibo AND r.codcaj = :codcaj")
    String findBase64ContentByNumeroReciboAndCodcaj(@Param("numeroRecibo") String numeroRecibo,
            @Param("codcaj") int codcaj);
}
