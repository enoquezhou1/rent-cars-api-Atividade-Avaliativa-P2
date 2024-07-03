package br.gov.sp.fatec.controller.impl;

import br.gov.sp.fatec.controller.AluguelController;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AluguelControllerImpl implements AluguelController {

    private final AluguelService aluguelService;

    @Override
    public ResponseEntity<AluguelResponse> save(AluguelRequest aluguel) {
        return null;
    }

    @Override
    public ResponseEntity<AluguelResponse> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AluguelResponse>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateById(Long id, AluguelUpdateRequest request) {
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteById(Long id) {
        return ResponseEntity.noContent().build();
    }
}
