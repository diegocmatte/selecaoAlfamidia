import java.text.SimpleDateFormat;
import java.util.Date;

public class Aluno extends Pessoa{

    private double notaFinal;

    public Aluno(String nome, String telefone, String dataNascimento, Date dataCadastro, Date ultimaAlteracao, double notaFinal) {
        super(nome, telefone, dataNascimento, dataCadastro, ultimaAlteracao);
        this.notaFinal = notaFinal;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                " ID = " + super.getIdPessoa() +
                ", Nome = " + super.getNome() +
                ", Telefone = " + super.formatarString(getTelefone(), "(##) #####-####") +
                ", Data de nascimento = " + super.formatarString(getDataNascimento(), "##/##/####") +
                ", Data de cadastro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(super.getDataCadastro()) +
                ", Última alteração no cadastro = " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(super.getUltimaAlteracao()) +
                ", Nota final = " + notaFinal +
                " }";

    }
}
