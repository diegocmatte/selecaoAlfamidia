import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    private String nome;
    private String telefone;
    private String dataNascimento;
    private Date dataCadastro;
    private Date ultimaAlteracao;

    public Pessoa(String nome, String telefone, String dataNascimento, Date dataCadastro, Date ultimaAlteracao) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
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
                ", telefone = " + formatarString(telefone, "(##) ####-####") +
                ", data de nascimento = " + formatarString(dataNascimento, "##/##/####")  +
                ", data de cadastro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataCadastro) +
                ", última alteração no cadastro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(ultimaAlteracao) +
                '}';
    }

    private String formatarString(String value, String pattern) {
        MaskFormatter mf;
        try {
            mf = new MaskFormatter(pattern);
            mf.setValueContainsLiteralCharacters(false);
            return mf.valueToString(value);
        } catch (ParseException ex) {
            return value;
        }
    }
}