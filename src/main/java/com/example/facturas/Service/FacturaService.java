package com.example.facturas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.example.facturas.repository.*;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    // Método para obtener todas las facturas para el admin
    public List<Object[]> getAllFacturasForAdmin() {
        return facturaRepository.findAllFacturasForAdmin();
    }

    // Método para obtener facturas por codmua y codmub para usuarios no admin
    public List<Object[]> getFacturasByCodmuaAndCodmub(int codmua, int codmub) {
        return facturaRepository.findFacturasByCodmuaAndCodmub(codmua, codmub);
    }

    // Método para obtener el contenido base64 de una factura específica
    public String getBase64ContentByNumeroFacturaAndSerieFactura(String numeroFactura, String serieFactura) {
        return facturaRepository.findBase64ContentByNumeroFacturaAndSerieFactura(numeroFactura, serieFactura);
    }
}
