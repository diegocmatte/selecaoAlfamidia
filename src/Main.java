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
        System.out.print("Opção: ");
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
                    if(nome.equals("")){
                        System.out.println("Nome não pode ser vazio.");
                        break;
                    }

                    System.out.print("Digite a data de nascimento (DDMMAAAA): ");
                    String dataNascimento = entradaIncluir.nextLine();
                    if(dataNascimento.equals("")){
                        System.out.println("Data de nascimento não pode ser vazio.");
                        break;
                    }

                    System.out.print("Digite o telefone (somente números e com ddd): ");
                    String telefone = entradaIncluir.nextLine();
                    if(telefone.equals("")){
                        System.out.println("Telefone de nascimento não pode ser vazio.");
                        break;
                    }

                    System.out.print("Digite a nota (-1 para não aluno): ");
                    double nota = entradaIncluir.nextDouble();
                    if(nota == -1 || nota >= 0) {
                        incluir(nome, dataNascimento, telefone, nota);
                    } else {
                        System.out.println("Nota digitida inváilda.");
                        break;
                    }
                    break;

                case 2:
                    if(!lista.isEmpty()) {
                        System.out.println("Opção 'Alterar' selecionada.");
                        System.out.print("Digite o nome para buscar: ");
                        Scanner entradaAlterar = new Scanner(System.in);
                        String buscarNome = entradaAlterar.nextLine();
                        if(lista.stream().allMatch(pessoa -> pessoa.getNome().equalsIgnoreCase(buscarNome))) {
                            alterar(buscarNome);
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
                        Scanner entradaExcluir = new Scanner(System.in);
                        System.out.print("Digite o nome do cadastro que deseja excluir: ");
                        String nomeExclusao = entradaExcluir.nextLine();
                        if(lista.stream().allMatch(pessoa -> pessoa.getNome().equalsIgnoreCase(nomeExclusao))) {
                            excluir(nomeExclusao);
                            break;
                        } else {
                            System.out.println("Cadastro não localizado.");
                            break;
                        }
                    } else {
                        System.out.println("Não há cadastros registrados.");
                        break;
                    }

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

    private static void incluir(String nome, String dataNascimento, String telefone, double nota) {
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

    private static void alterar(String nome) {
        Scanner entrada = new Scanner(System.in);

        for (Pessoa p: lista) {

            if(p.getNome().equals(nome)){

                String nomeAtual = p.getNome();
                String telefoneAtual = p.getTelefone();
                String nascimentoAtual = p .getDataNascimento();

                Date novaDataAlteracaoCadastro = new Date();

                System.out.print("Digite o novo nome (deixe em branco para não alterar): ");
                String novoNome = entrada.nextLine();
                if (!novoNome.equals("")) {
                    p.setNome(novoNome);
                } else {
                    p.setNome(nomeAtual);
                }

                System.out.print("Digite a nova data de nascimento (DDMMAAAA) (deixe em branco para não alterar): ");
                String novaDataNascimento = entrada.nextLine();
                if (!novaDataNascimento.equals("")){
                    p.setDataNascimento(novaDataNascimento);
                } else {
                    p.setDataNascimento(nascimentoAtual);
                }

                System.out.print("Digite o novo telefone (somente números) (deixe em branco para não alterar): ");
                String novoTelefone = entrada.nextLine();
                if(!novoTelefone.equals("")) {
                    p.setTelefone(novoTelefone);
                } else {
                    p.setTelefone(telefoneAtual);
                }

                if(p instanceof Aluno){
                    System.out.print("Digite a nova nota: ");
                    double novaNota = entrada.nextDouble();
                    if(novaNota >= 0) {
                        ((Aluno) p).setNotaFinal(novaNota);
                    } else {
                        System.out.println("Nota deve ser maior ou igual à zero.");
                    }
                }

                p.setUltimaAlteracao(novaDataAlteracaoCadastro);
                break;

            }

        }

    }


    private static void excluir(String nome) {

        if (lista.removeIf(pessoa -> pessoa.getNome().equals(nome))) {
            System.out.println("Cadastro excluído.");
        } else {
            System.out.println("Cadastro não encontrado.");
        }

    }

    private static void mostrarTodos() {
        for (Pessoa pessoa : lista) {
            System.out.println("Dados do cadastro: " + pessoa.toString());
        }
    }

}
