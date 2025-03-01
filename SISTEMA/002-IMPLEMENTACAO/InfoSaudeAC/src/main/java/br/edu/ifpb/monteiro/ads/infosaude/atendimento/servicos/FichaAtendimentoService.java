package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.FichaAtendimentoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.FichaAtendimento;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author Cássio Oliveira
 */
public class FichaAtendimentoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private FichaAtendimentoDao fichaAtendimentoDao;

    public FichaAtendimentoService() {
    }

    @Transactional
    public void save(FichaAtendimento fichaAtendimento) {
        if (fichaAtendimento != null) {
            fichaAtendimento.setData(new DateTimeUtilBean().getDateToday());
            this.fichaAtendimentoDao.salvar(fichaAtendimento);
        }
    }

    @Transactional
    public void delete(FichaAtendimento fichaAtendimento) throws NegocioException {
        fichaAtendimentoDao.delete(findById(fichaAtendimento.getId()));
    }

    public FichaAtendimento findById(Long id) {
        return fichaAtendimentoDao.findById(id);
    }

    public List<FichaAtendimento> findAll() {
        return fichaAtendimentoDao.findAll();
    }

}
