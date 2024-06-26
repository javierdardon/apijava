package com.example.facturas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.facturas.Service.*;

@RestController
@RequestMapping("/recibos")
public class ReciboController {

    @Autowired
    private ReciboService reciboService;

    @GetMapping("/admin")
    public ResponseEntity<List<Object[]>> getAllRecibosForAdmin() {
        List<Object[]> recibos = reciboService.getAllRecibosForAdmin();
        return new ResponseEntity<>(recibos, HttpStatus.OK);
    }

    @GetMapping("/display/{coddepto}/{codmuni}")
    public ResponseEntity<List<Object[]>> getRecibosByCoddeptoAndCodmuni(@PathVariable int coddepto,
            @PathVariable int codmuni) {
        List<Object[]> recibos = reciboService.getRecibosByCoddeptoAndCodmuni(coddepto, codmuni);
        return new ResponseEntity<>(recibos, HttpStatus.OK);
    }

    @GetMapping("/{numeroRecibo}/{codcaj}")
    public ResponseEntity<String> getBase64ContentByNumeroReciboAndCodcaj(@PathVariable String numeroRecibo,
            @PathVariable int codcaj) {
        String base64Content = reciboService.getBase64ContentByNumeroReciboAndCodcaj(numeroRecibo, codcaj);
        return new ResponseEntity<>(base64Content, HttpStatus.OK);
    }
}
