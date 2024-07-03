package br.gov.sp.fatec.domain.entity;

import br.gov.sp.fatec.domain.enums.AluguelStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor

public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  double valor;

    @Enumerated(value = EnumType.STRING)
    private AluguelStatus aluguelStatus;

    @OneToOne(mappedBy = "cliente")
    private Cliente cliente;

    @ManyToMany(mappedBy = "carro")
    private List<Carro> carros;

    public void setUpdatedAt(Date dataFim) {
        throw new UnsupportedOperationException("Unimplemented method 'setUpdatedAt'");
    }
    public void setCreatedAt(Date dataInicio) {
        throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
    }
}
