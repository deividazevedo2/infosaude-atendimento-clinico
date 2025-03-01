package br.edu.ifpb.monteiro.ads.infosaude.atendimento.servicos;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.OdontologoDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.excecoes.NegocioException;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Odontologo;
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
public class OdontologoService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private OdontologoDao odontologoDAO;

    /**
     *
     */
    public OdontologoService() {
    }

    /**
     *
     * @param odontologo
     */
    @Transactional
    public void save(Odontologo odontologo) {
        if (odontologo != null) {
            odontologoDAO.salvar(odontologo);
        }
    }

    /**
     *
     * @param odontologo
     * @throws NegocioException
     */
    @Transactional
    public void delete(Odontologo odontologo) throws NegocioException {
        odontologoDAO.delete(findById(odontologo.getId()));
    }

    /**
     *
     * @return
     */
    public List<Odontologo> findAll() {
        return odontologoDAO.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Odontologo findById(Long id) {
        return odontologoDAO.findById(id);
    }

}
