package school.sptech;

public class Turma {
    private String nome;
    private Double mensalidade;
    private Integer qtdAluno;
    private Boolean ativa;

    public Turma(String nome, Double mensalidade) {
        this.qtdAluno = 0;
        this.ativa = true;
        this.mensalidade = mensalidade;
        this.nome = nome;
    }

    public void matricular(Integer qtd) {
        if (qtd != null && qtd > 0 && this.ativa) {
            this.qtdAluno += qtd;
        }
    }

    public Integer cancelar(Integer qtd) {
        if (qtd != null && qtd > 0 && qtd <= this.qtdAluno && this.ativa) {
            this.qtdAluno -= qtd;
            return qtd;
        }
        return null;
    }

    public Integer desativar() {
        if (!this.ativa) {
            return null;
        }
        this.ativa = false;
        Integer qtdAntiga = this.qtdAluno;
        this.qtdAluno = 0;
        return qtdAntiga;
    }

    public void transferir(Turma destino, Integer qtdATransferir) {
        if (destino != null && destino.ativa  && qtdATransferir != null && qtdATransferir > 0 &&
        this.qtdAluno >= qtdATransferir &&
        this.ativa) {
            this.qtdAluno -= qtdATransferir;
            destino.qtdAluno += qtdATransferir;
        }
    }

    public Boolean reajustarMensalidade(Double reajuste) {
        if (reajuste == null || reajuste <= 0) {
            return false;
        }
        this.mensalidade = this.mensalidade + (this.mensalidade * reajuste);
        return true;
    }

    public String getNome() {return this.nome;}
    public Double getMensalidade() {return this.mensalidade;}
    public Integer getQtdAluno() {return this.qtdAluno;}
    public Boolean getAtiva() {if (this.ativa) {return true;} else {return false;} }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
