import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
                System.out.print("Informe o nome da pessoa: ");
                String filtro = sc.nextLine();
                List<Pessoa> listaFiltrada = i.listaPessoas()
                        .stream()
                        .filter(pessoa -> pessoa.getNome().toLowerCase().contains(filtro.toLowerCase()))
                        .toList();
                if (listaFiltrada.isEmpty()) {
                    System.out.println("Não há pessoas com esse nome.");
                    continue;
                }
                System.out.println("Escolha uma das pessoas abaixo para visualizar:");
                for (int j = 1; j <= listaFiltrada.size(); j++) {
                    System.out.printf("%d- %s\n", j, listaFiltrada.get(j-1).getNome());
                }
                int opcaoPessoa = sc.nextInt();
                if (opcaoPessoa > 0 && opcaoPessoa <= listaFiltrada.size()) System.out.println(listaFiltrada.get(opcaoPessoa-1));
                else System.out.println("Opção inválida.");
            } else if (opcao == 2) {
                System.out.print("Nome completo: ");
                String nome = sc.nextLine();
                System.out.print("Data de nascimento: ");
                String dataNascimento = sc.nextLine();
                System.out.print("Média final: ");
                double mediaFinal = sc.nextDouble();

                i.adicionarPessoa(new Pessoa(nome, formatter.parse(dataNascimento), mediaFinal));
            } else {
                System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}
