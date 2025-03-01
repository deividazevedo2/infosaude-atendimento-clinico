package unidade.testes.dao;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.controladores.DateTimeUtilBean;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.dao.AdministradorDao;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo.Administrador;
import br.edu.ifpb.monteiro.ads.infosaude.atendimento.util.jpa.EntityManagerProducer;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wilde
 */
public class AdministradorDaoTest {

    private static EntityManagerProducer entityManagerProducer;
    private static EntityManager entityManager;
    private static AdministradorDao administradorDao;
    private static DateTimeUtilBean dateTimeUtilBean;
    private static List<Administrador> listaAdministradores;
    private static Long id;

    /**
     *
     */
    public AdministradorDaoTest() {
    }

    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
        administradorDao = new AdministradorDao();
        dateTimeUtilBean = new DateTimeUtilBean();
        entityManagerProducer = new EntityManagerProducer("InfoSaudePU_Testes");
        entityManager = entityManagerProducer.create();
        administradorDao.setEntityManager(entityManager);
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorNull() {

        Administrador administrador = new Administrador();

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test
    public void testSalvarAdministradorCamposObrigatorios() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR SOBRENOME");
        administrador.setCpfAdministrador("52645149847");
        administrador.setCartaoSusAdministrador("898 0001 0121 0004");
        administrador.setEmail("");
        administrador.setCorOuRaca("");
        administrador.setEnderecoBairro("");
        administrador.setEnderecoCep("");
        administrador.setEnderecoCidade("");
        administrador.setEnderecoNumero("");
        administrador.setEnderecoRua("");
        administrador.setRg("");
        administrador.setTelefone1("");
        administrador.setTelefone2("");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores = administradorDao.findAll();

        for (Administrador administrador1 : listaAdministradores) {

            if (administrador1.getCpfAdministrador().equals(administrador.getCpfAdministrador())) {
                id = administrador1.getId();
            }
        }

        Administrador novoAdministrador = new Administrador();
        novoAdministrador = administradorDao.findById(id);

        assertEquals(administrador.getCpfAdministrador(), novoAdministrador.getCpfAdministrador());
    }

    /**
     *
     */
    @Test
    public void testSalvarAdministradorTodosCampos() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR I SOBRENOME");
        administrador.setCpfAdministrador("23367341258");
        administrador.setCartaoSusAdministrador("898 0001 0121 0009");
        administrador.setEmail("administrador.isobrenome@domain.com");
        administrador.setCorOuRaca("PARDA");
        administrador.setDataNascimento(dateTimeUtilBean.getDateToday());
        administrador.setEnderecoBairro("BAIRRO");
        administrador.setEnderecoCep("58500-000");
        administrador.setEnderecoCidade("MONTEIRO");
        administrador.setEnderecoEstado(Estados.PB);
        administrador.setEnderecoNumero("1");
        administrador.setEnderecoRua("DAS FLORES");
        administrador.setRg("88555741-x");
        administrador.setTelefone1("(83)9988-7766");
        administrador.setTelefone2("(83)3305-0001");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores = administradorDao.findAll();

        for (Administrador administrador1 : listaAdministradores) {

            if (administrador1.getCpfAdministrador().equals(administrador.getCpfAdministrador())) {
                id = administrador1.getId();
            }
        }

        Administrador novoAdministrador = new Administrador();
        novoAdministrador = administradorDao.findById(id);

        assertEquals(administrador.getCpfAdministrador(), novoAdministrador.getCpfAdministrador());

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorDuplicado() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR II SOBRENOME");
        administrador.setCpfAdministrador("17407400253");
        administrador.setCartaoSusAdministrador("898 0001 0121 0099");
        administrador.setEmail("administrador.iisobrenome@domain.com");
        administrador.setCorOuRaca("PARDA");
        administrador.setDataNascimento(dateTimeUtilBean.getDateToday());
        administrador.setEnderecoBairro("BAIRRO");
        administrador.setEnderecoCep("58500-000");
        administrador.setEnderecoCidade("MONTEIRO");
        administrador.setEnderecoEstado(Estados.CE);
        administrador.setEnderecoNumero("1");
        administrador.setEnderecoRua("DAS FLORES");
        administrador.setRg("88555741-x");
        administrador.setTelefone1("(83)9988-7766");
        administrador.setTelefone2("(83)3305-0001");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorNome() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR III SOBRENOME");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorCpf() {

        Administrador administrador = new Administrador();

        administrador.setCpfAdministrador("53406305792");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorSus() {

        Administrador administrador = new Administrador();

        administrador.setCartaoSusAdministrador("898 0001 0121 0099");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorEmail() {

        Administrador administrador = new Administrador();

        administrador.setEmail("administrador.iiisobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorNomeCpf() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR IV SOBRENOME");
        administrador.setCpfAdministrador("53406305792");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorCpfDuplicado() {

        Administrador administrador = new Administrador();
        Administrador novoAdministrador = new Administrador();

        administrador.setNome("ADMINISTRADOR V SOBRENOME");
        administrador.setCpfAdministrador("17407400253");
        administrador.setCartaoSusAdministrador("898 0001 0121 0099");
        administrador.setEmail("administrador.iisobrenome@domain.com");

        novoAdministrador.setNome("ADMINISTRADOR X SOBRENOME");
        novoAdministrador.setCpfAdministrador("17407400253");
        novoAdministrador.setCartaoSusAdministrador("898 0001 0121 0901");
        novoAdministrador.setEmail("administrador.xsobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(novoAdministrador);
        administradorDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test(expected = Exception.class)
    public void testSalvarAdministradorSusDuplicado() {

        Administrador administrador = new Administrador();
        Administrador novoAdministrador = new Administrador();

        administrador.setNome("ADMINISTRADOR VI SOBRENOME");
        administrador.setCpfAdministrador("17407400253");
        administrador.setCartaoSusAdministrador("898 0001 0121 0099");
        administrador.setEmail("administrador.iisobrenome@domain.com");

        novoAdministrador.setNome("ADMINISTRADOR VII SOBRENOME");
        novoAdministrador.setCpfAdministrador("43622448326");
        novoAdministrador.setCartaoSusAdministrador("898 0001 0121 0099");
        novoAdministrador.setEmail("administrador.xsobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(novoAdministrador);
        administradorDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test
    public void testSalvarCpfSusTodoSistema() {

        Administrador administrador = new Administrador();

        administrador.setNome("ENTIDADE SOBRENOME");
        administrador.setCpfAdministrador("91184468680");
        administrador.setCartaoSusAdministrador("898 2221 0121 9994");
        administrador.setEmail("entidade.sobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();
    }

    /**
     *
     */
    @Test
    public void testFindAll() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR VIII SOBRENOME ");
        administrador.setCpfAdministrador("55456713314");
        administrador.setCartaoSusAdministrador("756 0000 0000 0000");
        administrador.setEmail("administrador.sobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores = administradorDao.findAll();

        assertFalse(0 == listaAdministradores.size());
    }

    /**
     *
     */
    @Test
    public void testFindById() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR IX SOBRENOME");
        administrador.setCpfAdministrador("81574762591");
        administrador.setCartaoSusAdministrador("756 0000 0000 0001");
        administrador.setEmail("administrador.sobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores = administradorDao.findAll();

        for (Administrador administrador1 : listaAdministradores) {

            if (administrador1.getCpfAdministrador().equals(administrador.getCpfAdministrador())) {
                id = administrador1.getId();
            }
        }

        Administrador novoAdministrador = new Administrador();
        novoAdministrador = administradorDao.findById(id);
        assertEquals(administrador.getCpfAdministrador(), novoAdministrador.getCpfAdministrador());
    }

    /**
     *
     */
    @Test
    public void testFindByIdInexistente() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR X SOBRENOME");
        administrador.setCpfAdministrador("82471569463");
        administrador.setCartaoSusAdministrador("756 0000 0000 0002");
        administrador.setEmail("administrador.sobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        Administrador novoAdministrador = new Administrador();

        assertNull(novoAdministrador = administradorDao.findById(0L));
    }

    /**
     *
     */
    @Test
    public void testDelete() {

        Administrador administrador = new Administrador();

        administrador.setNome("ADMINISTRADOR XI SOBRENOME");
        administrador.setCpfAdministrador("67338517177");
        administrador.setCartaoSusAdministrador("756 0000 0000 0003");
        administrador.setEmail("administrador.sobrenome@domain.com");

        administradorDao.getEntityManager().getTransaction().begin();
        administradorDao.salvar(administrador);
        administradorDao.getEntityManager().getTransaction().commit();

        listaAdministradores = (List<Administrador>) new ArrayList<Administrador>();
        listaAdministradores = administradorDao.findAll();

        for (Administrador administrador1 : listaAdministradores) {

            if (administrador1.getCpfAdministrador().equals(administrador.getCpfAdministrador())) {
                id = administrador1.getId();
                administrador = administrador1;
            }
        }
        administradorDao.delete(administrador);

        assertNull(administradorDao.findById(id));

    }
}
