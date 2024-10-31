package com.example.demo.entity.DTO;

import com.example.demo.entity.Devis;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public record DevisPaginationDto(
        List<Devis> content,
        int totalPages,
        long totalElements,
        int pageNumber,
        boolean last,
        boolean first

) {
}
