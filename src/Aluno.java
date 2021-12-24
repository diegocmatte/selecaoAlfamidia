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
                ", telefone = " + super.getTelefone() +
                ", data de nascimento = " + super.getDataNascimento() +
                ", data de cadastro = " + super.getDataCadastro() +
                ", última alteração no cadastro = " + super.getUltimaAlteracao() +
                ", nota final = " + notaFinal +
                " }";

    }
}
