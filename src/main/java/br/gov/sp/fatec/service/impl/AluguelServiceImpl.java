package br.gov.sp.fatec.service.impl;

import br.gov.sp.fatec.domain.entity.Aluguel;
import br.gov.sp.fatec.domain.mapper.AluguelMapper;
import br.gov.sp.fatec.domain.request.AluguelRequest;
import br.gov.sp.fatec.domain.request.AluguelUpdateRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import br.gov.sp.fatec.domain.response.AluguelResponse;
import br.gov.sp.fatec.repository.AluguelRepository;
import br.gov.sp.fatec.service.AluguelService;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AluguelServiceImpl implements AluguelService {

    private final AluguelRepository aluguelRepository;
    private final AluguelMapper aluguelMapper;

    @Override
    public AluguelResponse findById(Long id) {
        Aluguel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado!"));
        return aluguelMapper.map(aluguel);
    }
    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        Aluguel aluguel = aluguelMapper.map(aluguelRequest);
        Aluguel savedAluguel = aluguelRepository.save(aluguel);
        return aluguelMapper.map(savedAluguel);
    }
    @Override
    public List<AluguelResponse> findAll() {
        List<Aluguel> alugueis = aluguelRepository.findAll();
        List<AluguelResponse> responses = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            responses.add(aluguelMapper.map(aluguel));
        }
        return responses;
    }
    @Override
    public void deleteById(Long id) {
        if (!aluguelRepository.existsById(id)) {
            throw new EntityNotFoundException("Aluguel não encontrado!");
        }
        aluguelRepository.deleteById(id);
    }
    @Override
    public void updateById(Long id, AluguelUpdateRequest aluguelRequest) {
        Aluguel aluguelToUpdate = aluguelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Aluguel não encontrado!"));

        aluguelToUpdate.setCreatedAt(aluguelRequest.dataInicio());
        aluguelToUpdate.setUpdatedAt(aluguelRequest.dataFim());

        aluguelRepository.save(aluguelToUpdate);
    }
}
