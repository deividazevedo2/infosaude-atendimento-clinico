package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import br.edu.ifpb.monteiro.ads.infosaude.atendimento.enumeracoes.Estados;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados.
 *
 * @author cassio
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull(message = "Um nome deve ser informado")
    @Column(name = "pessoa_nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "pessoa_rg", length = 15)
    private String rg;

    @Column(name = "pessoa_endereco_rua", length = 150)
    private String enderecoRua;

    @Column(name = "pessoa_endereco_numero", length = 6)
    private String enderecoNumero;

    @Column(name = "pessoa_endereco_bairro", length = 100)
    private String enderecoBairro;

    @Enumerated(EnumType.STRING)
    @Column(name = "pessoa_endereco_estado")
    private Estados enderecoEstado;

    @Column(name = "pessoa_endereco_cidade", length = 100)
    private String enderecoCidade;

    @Column(name = "pessoa_endereco_cep", length = 10)
    private String enderecoCep;

    @Temporal(TemporalType.DATE)
    @Column(name = "pessoa_data_nascimento")
    private Date dataNascimento;

    @Column(name = "pessoa_telefone1", length = 20)
    private String telefone1;

    @Column(name = "pessoa_telefone2", length = 20)
    private String telefone2;

    @Pattern(regexp = "^$|^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$",
            message = "E-mail com formato incorreto")
    @Column(name = "pessoa_email", length = 100)
    private String email;

    @Column(name = "pessoa_cor_raca", length = 15)
    private String corOuRaca;

    /**
     *
     */
    public Pessoa() {

    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getRg() {
        return rg;
    }

    /**
     *
     * @param rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     *
     * @return
     */
    public String getEnderecoRua() {
        return enderecoRua;
    }

    /**
     *
     * @param enderecoRua
     */
    public void setEnderecoRua(String enderecoRua) {
        this.enderecoRua = enderecoRua;
    }

    /**
     *
     * @return
     */
    public String getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     *
     * @param enderecoNumero
     */
    public void setEnderecoNumero(String enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    /**
     *
     * @return
     */
    public String getEnderecoBairro() {
        return enderecoBairro;
    }

    /**
     *
     * @param enderecoBairro
     */
    public void setEnderecoBairro(String enderecoBairro) {
        this.enderecoBairro = enderecoBairro;
    }

    /**
     *
     * @return
     */
    public Estados getEnderecoEstado() {
        return enderecoEstado;
    }

    /**
     *
     * @param enderecoEstado
     */
    public void setEnderecoEstado(Estados enderecoEstado) {
        this.enderecoEstado = enderecoEstado;
    }

    /**
     *
     * @return
     */
    public String getEnderecoCidade() {
        return enderecoCidade;
    }

    /**
     *
     * @param enderecoCidade
     */
    public void setEnderecoCidade(String enderecoCidade) {
        this.enderecoCidade = enderecoCidade;
    }

    /**
     *
     * @return
     */
    public String getEnderecoCep() {
        return enderecoCep;
    }

    /**
     *
     * @param enderecoCep
     */
    public void setEnderecoCep(String enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    /**
     *
     * @return
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     *
     * @param dataNascimento
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     *
     * @return
     */
    public String getTelefone1() {
        return telefone1;
    }

    /**
     *
     * @param telefone1
     */
    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    /**
     *
     * @return
     */
    public String getTelefone2() {
        return telefone2;
    }

    /**
     *
     * @param telefone2
     */
    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getCorOuRaca() {
        return corOuRaca;
    }

    /**
     *
     * @param corOuRaca
     */
    public void setCorOuRaca(String corOuRaca) {
        this.corOuRaca = corOuRaca;
    }

    @Override
    public int hashCode() {
        int hashPessoa = 5;
        hashPessoa = 37 * hashPessoa + Objects.hashCode(this.id);
        return hashPessoa;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return Objects.equals(this.id, other.id);
    }
}
