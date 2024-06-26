package com.example.facturas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.facturas.Service.FacturaService;;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    // Ruta para obtener todas las facturas para admin
    @GetMapping("/admin")
    public ResponseEntity<List<Object[]>> getAllFacturasForAdmin() {
        List<Object[]> facturas = facturaService.getAllFacturasForAdmin();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    // Ruta para obtener facturas por codmua y codmub para usuarios no admin
    @GetMapping("/display/{codmua}/{codmub}")
    public ResponseEntity<List<Object[]>> getFacturasByCodmuaAndCodmub(@PathVariable int codmua,
            @PathVariable int codmub) {
        List<Object[]> facturas = facturaService.getFacturasByCodmuaAndCodmub(codmua, codmub);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    // Ruta para obtener el contenido base64 de una factura específica
    @GetMapping("/{numeroFactura}/{serieFactura}")
    public ResponseEntity<String> getBase64ContentByNumeroFacturaAndSerieFactura(@PathVariable String numeroFactura,
            @PathVariable String serieFactura) {
        String base64Content = facturaService.getBase64ContentByNumeroFacturaAndSerieFactura(numeroFactura,
                serieFactura);
        return new ResponseEntity<>(base64Content, HttpStatus.OK);
    }
}
