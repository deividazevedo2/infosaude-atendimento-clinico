package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.ExameDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Exame;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author elisangela
 */
public class ExameDaoTest {
    
    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static ExameDao exameDao;
    private static List<Exame> listaExames;
    private static Long id;
    
    public ExameDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        exameDao = new ExameDao();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        exameDao.setEntityManager(entityManager);
    }
    
    /**
     * Teste para salvar o cadastro de exame null.
     */
    @Test (expected = Exception.class)
    public void testSalvarExameNull() {
        Exame exame = new Exame();
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
    }
    
    @Test
    public void textSalvarExameCadastroCompleto() {
        Exame exame = new Exame();
        
        exame.setDescricao("Glicose");
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
        
        /**
         salvar, capturar nome findAll e pegar o id para passar no findById.
         */
        Exame novoExame = new Exame();
        
        try {
            novoExame = (Exame) exameDao.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ExameDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertEquals(exame.getId(), novoExame.getId());
    }
    
    @Test
    public void testFindAll() {
        Exame exame = new Exame();
        
        exame.setDescricao("Glicose");
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
        
        listaExames = (List<Exame>) new ArrayList<Exame>();
        listaExames = exameDao.findAll();
        
        assertFalse(0 == listaExames.size());
    }
    
    @Test
    public void textFindById() {
        Exame exame = new Exame();
        
        exame.setDescricao("Glicose");
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
        
        listaExames = (List<Exame>) new ArrayList<Exame>();
        listaExames = exameDao.findAll();
        
        for (Exame exame1 : listaExames) {
            
            if (exame1.getDescricao().equals(exame.getDescricao())) {
                id = exame1.getId();
            }
        }
        
        Exame novoExame = new Exame();
        novoExame = exameDao.findById(id);
        assertEquals(exame.getDescricao(), novoExame.getDescricao());
        
    }
    
    public void testFindByIdInexistente() {
        Exame exame = new Exame();
        
        exame.setDescricao("Glicose");
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
        
        Exame novoExame = new Exame();
        
        assertNull(novoExame = exameDao.findById(0L));
    }
    
    public void testDelete() {
        Exame exame = new Exame();
        
        exame.setDescricao("Glicose");
        
        exameDao.getEntityManager().getTransaction().begin();
        exameDao.salvar(exame);
        exameDao.getEntityManager().getTransaction().commit();
        
        listaExames = (List<Exame>) new ArrayList<Exame>();
        listaExames = exameDao.findAll();
        
        for (Exame exame1 : listaExames) {
            if (exame1.getDescricao().equals(exame.getDescricao())) {
                id = exame1.getId();
                exame = exame1;
            }
        }
        exameDao.delete(exame);
        assertNull(exameDao.findById(id));
    }
    
}
