package com.example.demo.sevice.definir;

import com.example.demo.entity.DTO.DevisCreateDto;
import com.example.demo.entity.DTO.DevisPaginationDto;
import com.example.demo.entity.Devis;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DevisService {
//    Page<Devis> getDevis(int page, int size);
DevisPaginationDto getDevis(int page, int size);

    Devis createDevis(DevisCreateDto devisCreateDto);
//    Devis createDevis(Devis devis);

}
