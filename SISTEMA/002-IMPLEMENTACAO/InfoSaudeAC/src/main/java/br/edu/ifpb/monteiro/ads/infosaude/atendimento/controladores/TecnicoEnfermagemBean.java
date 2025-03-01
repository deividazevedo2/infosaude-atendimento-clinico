package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.TecnicoEnfermagem;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.PessoaService;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.TecnicoEnfermagemService;
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
public class TecnicoEnfermagemBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(TecnicoEnfermagemBean.class);

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagem;

    @Inject
    private TecnicoEnfermagemService tecnicoEnfermagemService;

    @Inject
    private TecnicoEnfermagem tecnicoEnfermagemSelecionado;

    @Inject
    private PessoaService pessoaService;

    private transient List<TecnicoEnfermagem> tecnicos;

    /**
     *
     */
    public TecnicoEnfermagemBean() {

    }

    /**
     *
     */
    public void carregarCidades() {
        PessoaBean.cidades.clear();
        if (tecnicoEnfermagem.getEnderecoEstado() != null) {
            for (String cidadesFiltradas : pessoaService.retornaCidades(tecnicoEnfermagem.getEnderecoEstado().getCodigo())) {
                PessoaBean.cidades.add(cidadesFiltradas);
            }
        }
    }

    /**
     *
     * @return
     */
    public List<TecnicoEnfermagem> getTecnicos() {
        this.tecnicos = tecnicoEnfermagemService.findAll();
        return tecnicos;
    }

    /**
     *
     * @throws NegocioException
     */
    public void salvar() throws NegocioException {
        try {
            this.tecnicoEnfermagemService.save(tecnicoEnfermagem);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Cadastro do téc. em enfermagem '" + tecnicoEnfermagem.getNome() + "' atualizado com sucesso!");
                FacesUtil.redirecionaPara("PesquisaTecnicoEnfermagem.xhtml");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            tecnicoEnfermagem = new TecnicoEnfermagem();
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
        this.tecnicoEnfermagemService.delete(tecnicoEnfermagemSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /**
     * Metodo que verifica se o objeto esta nulo quando for recuperado. Se sim,
     * refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     *
     * @return
     */
    public boolean getEditando() {
        return this.tecnicoEnfermagem.getId() != null;
    }

    /**
     *
     * @return
     */
    public TecnicoEnfermagem getTecnicoEnfermagemSelecionado() {
        return tecnicoEnfermagemSelecionado;
    }

    public void setTecnicoEnfermagemSelecionado(TecnicoEnfermagem tecnicoEnfermagemSelecionado) {
        this.tecnicoEnfermagemSelecionado = tecnicoEnfermagemSelecionado;
    }

    public TecnicoEnfermagem getTecnicoEnfermagem() {
        return tecnicoEnfermagem;
    }

    public void setTecnicoEnfermagem(TecnicoEnfermagem tecnicoEnfermagem) {
        this.tecnicoEnfermagem = tecnicoEnfermagem;
    }

    public TecnicoEnfermagemService getTecnicoEnfermagemService() {
        return tecnicoEnfermagemService;
    }

    public void setTecnicoEnfermagemService(TecnicoEnfermagemService tecnicoEnfermagemService) {
        this.tecnicoEnfermagemService = tecnicoEnfermagemService;
    }

}
