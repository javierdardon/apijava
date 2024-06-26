package com.example.facturas.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.facturas.repository.*;

@Service
public class ReciboService {

    @Autowired
    private ReciboRepository reciboRepository;

    public List<Object[]> getAllRecibosForAdmin() {
        return reciboRepository.findAllRecibosForAdmin();
    }

    public List<Object[]> getRecibosByCoddeptoAndCodmuni(int coddepto, int codmuni) {
        return reciboRepository.findRecibosByCoddeptoAndCodmuni(coddepto, codmuni);
    }

    public String getBase64ContentByNumeroReciboAndCodcaj(String numeroRecibo, int codcaj) {
        return reciboRepository.findBase64ContentByNumeroReciboAndCodcaj(numeroRecibo, codcaj);
    }
}
