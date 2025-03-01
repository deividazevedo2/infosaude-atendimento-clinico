package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Enfermeiro;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.EnfermeiroService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.RollbackException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elisangela
 */
@Model
public class EnfermeiroBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(EnfermeiroBean.class);

    @Inject
    private Enfermeiro enfermeiro;

    @Inject
    private EnfermeiroService enfermeiroService;

    @Inject
    private Enfermeiro enfermeiroSelecionado;

    @Inject
    private PessoaService pessoaService;

    private transient List<Enfermeiro> enfermeiros;

    /**
     *
     */
    public EnfermeiroBean() {
    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (enfermeiro.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(enfermeiro.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     *
     * @return
     */
    public List<Enfermeiro> getEnfermeiros() {
        this.enfermeiros = enfermeiroService.findAll();
        return enfermeiros;
    }

    /**
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.enfermeiroService.save(enfermeiro);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do enfermeiro '" + enfermeiro.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaEnfermeiro.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            enfermeiro = new Enfermeiro();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     *
     * @throws NegocioException
     */
    public void excluir() throws NegocioException {
        this.enfermeiroService.delete(enfermeiroSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.enfermeiro.getId() != null;
    }

    public Enfermeiro getEnfermeiroSelecionado() {
        return enfermeiroSelecionado;
    }

    public void setEnfermeiroSelecionado(Enfermeiro enfermeiroSelecionado) {
        this.enfermeiroSelecionado = enfermeiroSelecionado;
    }

    public Enfermeiro getEnfermeiro() {
        return enfermeiro;
    }

    public void setEnfermeiro(Enfermeiro enfermeiro) {
        this.enfermeiro = enfermeiro;
    }

    public EnfermeiroService getEnfermeiroService() {
        return enfermeiroService;
    }

    public void setEnfermeiroService(EnfermeiroService enfermeiroService) {
        this.enfermeiroService = enfermeiroService;
    }

}
