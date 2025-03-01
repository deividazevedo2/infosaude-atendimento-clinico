package br.edu.ifpb.monteiro.ads.infosaude.atendimento.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Entidade que representa a Consulta para o paciente que pode ser por um médico
 * ou Odontólogo da UBS. Ao extender Pessoa, passa a herdar todos os seus
 * atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Entity
public class Consulta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "consulta_codigo")
    private String codigo;

    @Lob
    @Column(name = "consulta_observacoes", length = 500)
    private String observacoes;

    @NotNull
    @Column(name = "consulta_prescricao", length = 255)
    private String prescricao;

    @Column(name = "consulta_diagnostico", length = 255)
    private String diagnostico;

    @Column(name = "consulta_anamnese", length = 255)
    private String anamnese;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "consulta_data")
    private Date data;

    @Column(name = "consulta_exames")
    private String exames;

    @Column(name = "consulta_sintomas")
    private String sintomas;

//    @OneToOne(mappedBy = "consultaPaciente")
//    @JoinColumn(name = "paciente_pk", referencedColumnName = "id")
//    private Paciente paciente;
    @OneToOne
    @JoinColumn(name = "fichaatendimentofk_id", nullable = false)
    private FichaAtendimento fichaAtendimento;

    @OneToOne
    @JoinColumn(name = "triagem_pk")
    private Triagem triagem;

    @OneToOne
    @JoinColumn(name = "procedimento_pk")
    private Procedimento procedimento;

    @OneToOne
    @JoinColumn(name = "requisicao_exame_pk")
    private RequisicaoExame requisicaoExame;

    public Consulta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public RequisicaoExame getRequisicaoExame() {
        return requisicaoExame;
    }

    public void setRequisicaoExame(RequisicaoExame requisicaoExame) {
        this.requisicaoExame = requisicaoExame;
    }

    public String getAnamnese() {
        return anamnese;
    }

    public void setAnamnese(String anamnese) {
        this.anamnese = anamnese;
    }

    public String getExames() {
        return exames;
    }

    public void setExames(String exames) {
        this.exames = exames;
    }

    public FichaAtendimento getFichaAtendimento() {
        return fichaAtendimento;
    }

    public void setFichaAtendimento(FichaAtendimento fichaAtendimento) {
        this.fichaAtendimento = fichaAtendimento;
    }

    public Triagem getTriagem() {
        return triagem;
    }

    public void setTriagem(Triagem triagem) {
        this.triagem = triagem;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    @Override
    public int hashCode() {
        int hashConsulta = 3;
        hashConsulta = 11 * hashConsulta + Objects.hashCode(this.id);
        return hashConsulta;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consulta other = (Consulta) obj;
        return Objects.equals(this.id, other.id);
    }

}
