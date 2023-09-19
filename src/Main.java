import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Adicionar i = new AdicionarPessoa(); // i de interface

        while (true) {
            System.out.println("Gerenciador de Aniversários");
            System.out.println("1- Pesquisar pessoa");
            System.out.println("2- Adicionar pessoa");
            System.out.println("3- Sair");
            int opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 3) break;
            else if (opcao == 1) {
                i.listaPessoas().forEach(System.out::println);
            } else if (opcao == 2) {
                System.out.print("Nome completo: ");
                String nome = sc.nextLine();
                System.out.print("Data de nascimento: ");
                String dataNascimento = sc.nextLine();
                System.out.print("Média final: ");
                double mediaFinal = sc.nextDouble();

                Pessoa p = new Pessoa(nome, formatter.parse(dataNascimento), mediaFinal);
                i.adicionarPessoa(p);
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
