package br.com.srcsoftware.web.atlantis.dto.abstracts;

import br.com.srcsoftware.web.atlantis.dto.manager.empresa.EmpresaDTO;
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
public abstract class AuditoriaAbstractDTOComEmpresa extends AuditoriaAbstractDTO{

	private EmpresaDTO empresa;

}
