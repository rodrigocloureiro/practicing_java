import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {
    private String nome;
    private Date dataNascimento;
    private int idade;
    private boolean maiorIdade;
    private double mediaFinal;

    public Pessoa(String nome, Date dataNascimento, double mediaFinal) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.mediaFinal = mediaFinal;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return String.format("Nome: %s\n" +
                "Data de nascimento: %s\n" +
                "Idade: %d\n" +
                "Maior de idade: %b\n" +
                "%s\n", this.nome, formatter.format(this.dataNascimento), this.idade, this.maiorIdade,
                mediaFinal >= 8.5 ? "Você pode fazer uma festa." : "Você não pode fazer uma festa.");
    }
}
