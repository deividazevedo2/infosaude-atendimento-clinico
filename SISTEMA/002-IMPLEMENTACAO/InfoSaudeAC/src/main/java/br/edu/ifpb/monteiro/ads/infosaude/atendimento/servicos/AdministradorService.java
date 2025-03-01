package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AdministradorDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 * Classe de serviço que faz chamadas aos métodos de persistência e pode conter
 * lógica de negócio e pode fazer chamadas a outras partes do sistema, caso
 * necessite.
 *
 * @author elisangela
 */
public class AdministradorService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AdministradorDao administradorDAO;

    /**
     *
     */
    public AdministradorService() {
    }

    /**
     *
     * @param administrador
     */
    @Transactional
    public void save(Administrador administrador) {
        if (administrador != null) {
            this.administradorDAO.salvar(administrador);
        }
    }

    /**
     *
     * @param administrador
     * @throws NegocioException
     */
    @Transactional
    public void delete(Administrador administrador) throws NegocioException {
        administradorDAO.delete(findById(administrador.getId()));
    }

    /**
     *
     * @return
     */
    public List<Administrador> findAll() {
        return administradorDAO.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Administrador findById(Long id) {
        return administradorDAO.findById(id);
    }

}
