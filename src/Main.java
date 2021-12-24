import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pessoa> lista = new ArrayList<>();

    public static void menu(){
        System.out.println("\tMenu principal");
        System.out.println("0. Fim");
        System.out.println("1. Incluir Aluno/Pessoa");
        System.out.println("2. Alterar Aluno/Pessoa");
        System.out.println("3. Excluir Aluno/Pessoa");
        System.out.println("4. Consultar todos Aluno/Pessoa");
        System.out.print("Digite a opção desejada: ");
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    System.out.println("Opção 'Incluir' selecionada.");
                    Scanner entradaIncluir = new Scanner(System.in);

                    System.out.print("Digite o nome: ");
                    String nome = entradaIncluir.nextLine();
                    while(nome.equals("")){
                        System.out.println("Nome não pode ser vazio.");
                        System.out.print("Digite o nome: ");
                        nome = entradaIncluir.nextLine();
                    }

                    System.out.print("Digite a data de nascimento (DDMMAAAA): ");
                    String dataNascimento = entradaIncluir.nextLine();
                    while(dataNascimento.length() != 8){
                        System.out.println("Data de nascimento não pode ser menor/maior que 8 dígitos.");
                        System.out.print("Digite a data de nascimento (DDMMAAAA): ");
                        dataNascimento = entradaIncluir.nextLine();

                    }

                    System.out.print("Digite o telefone (somente números e com ddd): ");
                    String telefone = entradaIncluir.nextLine();
                    while(telefone.length() != 11){
                        System.out.println("Telefone de nascimento não pode ser menor/maior que 11 dígitos.");
                        System.out.print("Digite o telefone (somente números e com ddd): ");
                        telefone = entradaIncluir.nextLine();
                    }

                    System.out.print("Digite a nota (-1 para não aluno): ");
                    double nota = entradaIncluir.nextDouble();
                    while(nota < -1){
                        System.out.println("Nota digitida inválida.");
                        System.out.print("Digite a nota (-1 para não aluno): ");
                        nota = entradaIncluir.nextDouble();
                    }
                    incluir(nome, dataNascimento, telefone, nota);
                    break;

                case 2:
                    if(!lista.isEmpty()) {
                        System.out.println("Opção 'Alterar' selecionada.");
                        mostrarNomeId();
                        System.out.print("Digite o ID para selecionar: ");
                        Scanner entradaAlterar = new Scanner(System.in);
                        Integer idPessoa = entradaAlterar.nextInt();
                        if(lista.stream().allMatch(pessoa -> pessoa.getIdPessoa() == idPessoa)) {
                            alterar(idPessoa);
                        } else {
                            System.out.println("Cadastro não localizado.");
                        }
                    } else {
                        System.out.println("Não há cadastros registrados.");
                    }
                    break;

                case 3:
                    if(!lista.isEmpty()) {
                        System.out.println("Opção 'Excluir' selecionada.");
                        mostrarNomeId();
                        Scanner entradaExcluir = new Scanner(System.in);
                        System.out.print("Digite o ID para excluir: ");
                        Integer idPessoa = entradaExcluir.nextInt();
                        if(lista.stream().allMatch(pessoa -> pessoa.getIdPessoa() == idPessoa)) {
                            excluir(idPessoa);
                        } else {
                            System.out.println("Cadastro não localizado.");
                        }
                    } else {
                        System.out.println("Não há cadastros registrados.");
                    }
                    break;

                case 4:
                    if(!lista.isEmpty()) {
                        System.out.println("Opção 'Mostrar Todos' selecionada.");
                        mostrarTodos();
                    } else {
                        System.out.println("Não há cadastros registrados.");
                    }
                    break;

                case 0:
                    System.out.println("Fim da aplicação.");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida.");
            }
        } while(true);
    }

    public static void incluir(String nome, String dataNascimento, String telefone, double nota) {
        Date dataCriacaoCadastro = new Date();
        Date dataAlteracaoCadastro = new Date();

        if(nota == -1){
            Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, dataCriacaoCadastro, dataAlteracaoCadastro);
            lista.add(pessoa);
        } else {
            Aluno aluno = new Aluno(nome, telefone, dataNascimento, dataCriacaoCadastro, dataAlteracaoCadastro, nota);
            lista.add(aluno);
        }
    }

    public static void alterar(Integer idPessoa) {
        Scanner entrada = new Scanner(System.in);

        for (Pessoa p: lista) {

            if(p.getIdPessoa() == idPessoa){

                String nomeAtual = p.getNome();
                String telefoneAtual = p.getTelefone();
                String nascimentoAtual = p .getDataNascimento();

                Date novaDataAlteracaoCadastro = new Date();

                System.out.print("Digite o novo nome (deixe em branco para não alterar): ");
                String novoNome = entrada.nextLine();
                if (!novoNome.equals("")) {
                    p.setNome(novoNome);
                    System.out.println("Nome alterado com sucesso.");
                } else {
                    p.setNome(nomeAtual);
                    System.out.println("Nome não foi alterado.");
                }

                System.out.print("Digite a nova data de nascimento (DDMMAAAA) (deixe em branco para não alterar): ");
                String novaDataNascimento = entrada.nextLine();
                if (novaDataNascimento.length() == 8){
                    p.setDataNascimento(novaDataNascimento);
                    System.out.println("Data de nascimento alterada com sucesso.");
                } else {
                    p.setDataNascimento(nascimentoAtual);
                    System.out.println("Data de nascimento não foi alterada.");
                }

                System.out.print("Digite o novo telefone (somente números e DDD) (deixe em branco para não alterar): ");
                String novoTelefone = entrada.nextLine();
                if(novoTelefone.length() == 11) {
                    p.setTelefone(novoTelefone);
                    System.out.println("Telefone alterado com sucesso");
                } else {
                    p.setTelefone(telefoneAtual);
                    System.out.println("Telefone não foi alterado.");
                }

                if(p instanceof Aluno){
                    System.out.print("Digite a nova nota (digite -1 para não alterar): ");
                    double novaNota = entrada.nextDouble();
                    if(novaNota >= 0) {
                        ((Aluno) p).setNotaFinal(novaNota);
                        System.out.println("Nota final alterada com sucesso.");
                    } else if (novaNota == -1){
                        ((Aluno) p).setNotaFinal(((Aluno) p).getNotaFinal());
                        System.out.println("Nota final não foi alterada.");
                    } else {
                        System.out.println("Nota inválida.");
                    }
                }

                p.setUltimaAlteracao(novaDataAlteracaoCadastro);
                break;

            }

        }

    }
    public static void excluir(Integer idPessoa) {

        if (lista.removeIf(pessoa -> pessoa.getIdPessoa() == idPessoa)) {
            System.out.println("Cadastro excluído.");
        } else {
            System.out.println("Cadastro não encontrado.");
        }

    }

    public static void mostrarTodos() {
        for (Pessoa pessoa : lista) {
            System.out.println("Dados do cadastro: " + pessoa.toString());
        }
    }

    private static void mostrarNomeId(){
        System.out.println("Nome e ID das Pessoas/Alunos registrados.");
        for (Pessoa value : lista) {
            System.out.println("{ Nome: " + value.getNome() +
                    ", ID: " + value.getIdPessoa() + "}");
        }
    }

}
