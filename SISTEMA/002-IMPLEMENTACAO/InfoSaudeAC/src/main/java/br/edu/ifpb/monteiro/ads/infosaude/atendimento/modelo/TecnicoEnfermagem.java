package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Entidade que representa o Técnico em enfermagem da UBS. Ao extender Pessoa,
 * passa a herdar todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class TecnicoEnfermagem extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpfTecnicoEnfermagem;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusTecnicoEnfermagem;

    @Column(name = "tecnico_enfermagem_coren", unique = true, length = 50)
    private String corenTecnicoEnfermagem;

    public TecnicoEnfermagem() {
    }

    public String getCpfTecnicoEnfermagem() {
        return cpfTecnicoEnfermagem;
    }

    public void setCpfTecnicoEnfermagem(String cpfTecnicoEnfermagem) {
        this.cpfTecnicoEnfermagem = cpfTecnicoEnfermagem;
    }

    public String getCartaoSusTecnicoEnfermagem() {
        return cartaoSusTecnicoEnfermagem;
    }

    public void setCartaoSusTecnicoEnfermagem(String cartaoSusTecnicoEnfermagem) {
        this.cartaoSusTecnicoEnfermagem = cartaoSusTecnicoEnfermagem;
    }

    public String getCorenTecnicoEnfermagem() {
        return corenTecnicoEnfermagem;
    }

    public void setCorenTecnicoEnfermagem(String corenTecnicoEnfermagem) {
        this.corenTecnicoEnfermagem = corenTecnicoEnfermagem;
    }

    @Override
    public int hashCode() {
        int hashTecnicoEnfermagem = 7;
        hashTecnicoEnfermagem = 47 * hashTecnicoEnfermagem + Objects.hashCode(this.cpfTecnicoEnfermagem);
        return hashTecnicoEnfermagem;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TecnicoEnfermagem other = (TecnicoEnfermagem) obj;
        return Objects.equals(this.cpfTecnicoEnfermagem, other.cpfTecnicoEnfermagem);
    }
}
