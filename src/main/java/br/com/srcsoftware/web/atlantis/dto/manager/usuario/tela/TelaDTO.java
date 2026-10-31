package br.com.srcsoftware.web.atlantis.dto.manager.usuario.tela;

import java.util.Objects;

import br.com.srcsoftware.web.atlantis.dto.abstracts.AbstractDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class TelaDTO extends AbstractDTO {

	private String id;
    private String nome;
    private String query;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelaDTO telaDTO = (TelaDTO) o;
        return Objects.equals(getId(), telaDTO.getId()) &&
               Objects.equals(nome, telaDTO.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), nome);
    }
}