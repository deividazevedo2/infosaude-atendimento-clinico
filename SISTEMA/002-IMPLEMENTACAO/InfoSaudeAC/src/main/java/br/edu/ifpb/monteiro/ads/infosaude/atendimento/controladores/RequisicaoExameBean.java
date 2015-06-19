package br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.UBSException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.RequisicaoExame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos.RequisicaoExameService;
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
public class RequisicaoExameBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Log LOGGER = LogFactory.getLog(RequisicaoExameBean.class);

    @Inject
    private RequisicaoExame requisicaoExame;

    @Inject
    private RequisicaoExameService requisicaoExameService;

    @Inject
    private RequisicaoExame requisicaoExameSelecionado;

    private transient List<RequisicaoExame> requisicaoExames;

    /**
     *
     */
    public RequisicaoExameBean() {
    }

    /**
     *
     * @return
     */
    public List<RequisicaoExame> getRequisicaoExames() {
        this.requisicaoExames = requisicaoExameService.findAll();
        return requisicaoExames;
    }

    /**
     *
     * @throws UBSException
     */
    public void salvar() throws UBSException {
        try {
            this.requisicaoExameService.save(requisicaoExame);
            if (getEditando()) {
                FacesUtil.mensagemSucesso("Atualização do cadastro efetuada com sucesso!");
            } else {
                FacesUtil.mensagemSucesso("Cadastro efetuado com sucesso!");
            }
            requisicaoExame = new RequisicaoExame();
        } catch (RollbackException rollback) {
            FacesUtil.mensagemErro("O CPF informado já está cadastrado. Informe outro CPF.");
            LOGGER.warn(rollback);
        }
    }

    /**
     *
     * @throws UBSException
     */
    public void excluir() throws UBSException {
        this.requisicaoExameService.delete(requisicaoExameSelecionado);
        FacesUtil.mensagemSucesso("Exclusão efetuada com sucesso!");
    }

    /*
     * Metodo que verifica se o objeto esta nulo quando for recuperado.
     * Se sim, refere-se a um novo cadastro, senao refere-se a um produto a ser editado
     */

    /**
     *
     * @return
     */
    
    public boolean getEditando() {
        return this.requisicaoExame.getId() != null;
    }

    /**
     *
     * @return
     */
    public RequisicaoExame getRequisicaoExameSelecionado() {
        return requisicaoExameSelecionado;
    }

    /**
     *
     * @param requisicaoExameSelecionado
     */
    public void setRequisicaoExameSelecionado(RequisicaoExame requisicaoExameSelecionado) {
        this.requisicaoExameSelecionado = requisicaoExameSelecionado;
    }

    /**
     *
     * @return
     */
    public RequisicaoExame getRequisicaoExame() {
        return requisicaoExame;
    }

    /**
     *
     * @param requisicaoExame
     */
    public void setRequisicaoExame(RequisicaoExame requisicaoExame) {
        this.requisicaoExame = requisicaoExame;
    }

    /**
     *
     * @return
     */
    public RequisicaoExameService getRequisicaoExameService() {
        return requisicaoExameService;
    }

    /**
     *
     * @param requisicaoExameService
     */
    public void setRequisicaoExameService(RequisicaoExameService requisicaoExameService) {
        this.requisicaoExameService = requisicaoExameService;
    }

}
