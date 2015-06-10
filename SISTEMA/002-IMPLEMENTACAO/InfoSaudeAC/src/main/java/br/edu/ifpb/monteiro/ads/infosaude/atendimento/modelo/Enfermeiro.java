package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Classe que representa um modelo de uma entidade a ser persistida no banco,
 * com todos os atributos relacionados.
 *
 * @author cassio
 */
@Entity
public class Enfermeiro extends Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "pessoa_cpf", nullable = false, unique = true, length = 11)
    private String cpfEnfermeiro;

    @Column(name = "pessoa_cartao_sus", unique = true, nullable = false, length = 20)
    private String cartaoSusEnfermeiro;

    @Column(name = "enfermeiro_coren", unique = true, length = 30)
    private String corenEnfermeiro;

    public Enfermeiro() {
    }

    public String getCpfEnfermeiro() {
        return cpfEnfermeiro;
    }

    public void setCpfEnfermeiro(String cpfEnfermeiro) {
        this.cpfEnfermeiro = cpfEnfermeiro;
    }

    public String getCartaoSusEnfermeiro() {
        return cartaoSusEnfermeiro;
    }

    public void setCartaoSusEnfermeiro(String cartaoSusEnfermeiro) {
        this.cartaoSusEnfermeiro = cartaoSusEnfermeiro;
    }

    public String getCorenEnfermeiro() {
        return corenEnfermeiro;
    }

    public void setCorenEnfermeiro(String corenEnfermeiro) {
        this.corenEnfermeiro = corenEnfermeiro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.cpfEnfermeiro);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Enfermeiro other = (Enfermeiro) obj;
        return Objects.equals(this.cpfEnfermeiro, other.cpfEnfermeiro);
    }
}
