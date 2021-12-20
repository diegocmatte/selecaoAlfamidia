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
        System.out.print("Opcao: ");
    }

    public static void main(String[] args) {
        int opcao;
        Scanner entrada = new Scanner(System.in);

        do{
            menu();
            opcao = entrada.nextInt();

            switch(opcao){
                case 1:
                    incluir();
                    break;

                case 2:
                    alterar();
                    break;

                case 3:
                    excluir();
                    break;

                case 4:
                    mostrarTodos();
                    break;

                default:
                    System.out.println("Fim da aplicação.");
            }
        } while(opcao != 0);
    }

    private static void incluir() {
        Date dataCriacaoCadastro = new Date();
        Date dataAlteracaoCadastro = new Date();

        System.out.println("Opção 'Incluir' selecionada.");
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = entrada.nextLine();

        System.out.print("Digite a data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = entrada.nextLine();

        System.out.print("Digite o telefone (somente numeros): ");
        Integer telefone = entrada.nextInt();

        System.out.print("Digite a nota (-1 para não aluno): ");
        double nota = entrada.nextDouble();
        if(nota == -1){
            Pessoa pessoa = new Pessoa(nome, telefone, dataNascimento, dataCriacaoCadastro, dataAlteracaoCadastro);
            lista.add(pessoa);
        } else {
            Aluno aluno = new Aluno(nome, telefone, dataNascimento, dataCriacaoCadastro, dataAlteracaoCadastro, nota);
            lista.add(aluno);
        }
    }

    private static void alterar() {
        System.out.println("Opção 'Alterar' selecionada.");
    }

    private static void excluir() {
        System.out.println("Opção 'Excluir' selecionada.");
    }

    private static void mostrarTodos() {
        System.out.println("Opção 'Mostrar Todos' selecionada.");
        for (Pessoa pessoa : lista) {
            System.out.println("Dados do cadastro: " + pessoa.toString());
        }
    }


}
