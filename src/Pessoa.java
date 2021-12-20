import java.util.Date;

public class Pessoa {

    private String nome;
    private Integer telefone;
    private String dataNascimento;
    private Date dataCadastro;
    private Date ultimaAlteracao;

    public Pessoa(String nome, Integer telefone, String dataNascimento, Date dataCadastro, Date ultimaAlteracao) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.ultimaAlteracao = ultimaAlteracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getUltimaAlteracao() {
        return ultimaAlteracao;
    }

    public void setUltimaAlteracao(Date ultimaAlteracao) {
        this.ultimaAlteracao = ultimaAlteracao;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                " Nome = " + nome +
                ", telefone = " + telefone +
                ", data de nascimento = '" + dataNascimento + '\'' +
                ", data de cadastro = " + dataCadastro +
                ", última alteração no cadastro = " + ultimaAlteracao +
                '}';
    }
}
