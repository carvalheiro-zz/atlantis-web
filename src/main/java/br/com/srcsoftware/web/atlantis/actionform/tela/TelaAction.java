package br.com.srcsoftware.web.atlantis.actionform.tela;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.srcsoftware.web.atlantis.actionform.abstracts.AbstractCRUDAction;
import br.com.srcsoftware.web.atlantis.exceptions.ApplicationException;
import br.com.srcsoftware.web.utilidades.MensagensStruts;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelaAction extends AbstractCRUDAction<TelaForm> {

	@Override
	public ActionForward abrirCadastro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			TelaForm telaForm = (TelaForm) form;

			telaForm.reset(mapping, request);
			
			return mapping.findForward("telaCampos");
		} catch (ApplicationException e) {
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));
			return mapping.findForward("telaCampos");
		}
	}

	@Override
	public ActionForward inserir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = getCastingForm(form, request);

		try {			
			if (telaForm.getTela().getNome().isBlank() || telaForm.getTela().getQuery().isBlank()) {
				// Erro de negócio tratado externalizado
				addErrors(request, MensagensStruts.criarErroCamposObrigatorios("Nome e Query"));

				return mapping.findForward("telaCampos");
			}

			// Sucesso externalizado
			addMessages(request, MensagensStruts.criarSucesso("mensagem.sucesso.cadastro"));

			return mapping.findForward("telaCampos");
		} catch (ApplicationException e) {
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));
			return mapping.findForward("telaCampos");
		}
	}

	public ActionForward alterar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = getCastingForm(form, request);

		try {
			if (telaForm.getTela().getId().isBlank()) {				
				addErrors(request, MensagensStruts.criarErroDinamico("Registro deve ser pré-selecionado antes de alterar."));

				return mapping.findForward("telaCampos");
			}
			if (telaForm.getTela().getNome().isBlank() || telaForm.getTela().getQuery().isBlank()) {
				addErrors(request, MensagensStruts.criarErroCamposObrigatorios("Nome e Query"));
				return mapping.findForward("telaCampos");
			}

			// Sucesso externalizado
			addMessages(request, MensagensStruts.criarSucesso("mensagem.sucesso.alteracao"));

			return mapping.findForward("telaCampos");
		} catch (ApplicationException e) {

			// Erro de negócio tratado externalizado
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));

			return mapping.findForward("telaCampos");
		}
	}

	public ActionForward excluir(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		TelaForm telaForm = getCastingForm(form, request);

		try {
			if (telaForm.getTela().getId().isBlank()) {				
				addErrors(request, MensagensStruts.criarErroDinamico("Registro deve ser pré-selecionado antes de excluir."));

				return mapping.findForward("telaCampos");
			}			

			// Sucesso externalizado
			addMessages(request, MensagensStruts.criarSucesso("mensagem.sucesso.exclusao"));

			return mapping.findForward("telaCampos");
		} catch (ApplicationException e) {

			// Erro de negócio tratado externalizado
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));

			return mapping.findForward("telaCampos");
		}
	}

	// O botão Cancelar aciona o <html:cancel>, que por padrão direciona para o
	// cancel mapping ou método específico se configurado.
	public ActionForward cancelar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		TelaForm telaForm = (TelaForm) form;

		// Limpa o form da sessão/request se necessário
		if (form != null) {
			// Exemplo: resetando propriedades se estiver em escopo de sessão
			telaForm.reset(mapping, request);
		}

		// Redireciona para a página home do sistema (configurada no struts-config.xml)
		return mapping.findForward("homeGlobalForwards");
	}

	@Override
	public ActionForward abrirListagem(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			TelaForm telaForm = (TelaForm) form;

			telaForm.reset(mapping, request);

			return mapping.findForward("telaLista");
		} catch (ApplicationException e) {

			// Erro de negócio tratado externalizado
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));

			return mapping.findForward("telaLista");
		}
	}

	@Override
	public ActionForward filtrar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			TelaForm telaForm = (TelaForm) form;

			telaForm.reset(mapping, request);

			return mapping.findForward("telaLista");
		} catch (ApplicationException e) {

			// Erro de negócio tratado externalizado
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));

			return mapping.findForward("telaLista");
		}
	}

	@Override
	public ActionForward selecionar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try {
			TelaForm telaForm = (TelaForm) form;

			telaForm.reset(mapping, request);

			return mapping.findForward("telaCampos");
		} catch (ApplicationException e) {
			addErrors(request, MensagensStruts.criarErroDinamico(e.getMessage()));
			return mapping.findForward("telaCampos");
		}
	}

	@Override
	public ActionForward limpar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return abrirCadastro(mapping, form, request, response);
	}

	@Override
	public ActionForward limparFiltro(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return abrirListagem(mapping, form, request, response);
	}
}
