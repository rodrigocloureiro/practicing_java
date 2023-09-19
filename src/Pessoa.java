import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
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
        this.idade = calculaIdade();
        this.maiorIdade = idade >= 18;
    }

    private int calculaIdade() {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);

        /*Calendar c = Calendar.getInstance();
        c.setTime(dataNascimento);
        int anoNascimento = c.get(Calendar.YEAR);
        System.out.println(anoAtual - anoNascimento);*/

        LocalDate date = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anoNascimento = date.getYear();

        return anoAtual - anoNascimento;
    }

    private int diasFaltantes() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate nascimento = dataNascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate proxAniversario = LocalDate.of(dataAtual.getYear() + 1, nascimento.getMonthValue(), nascimento.getDayOfMonth());

        return (int) ChronoUnit.DAYS.between(dataAtual, proxAniversario);
    }

    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        return String.format("Nome: %s\n" +
                "Data de nascimento: %s\n" +
                "Idade: %d\n" +
                "Maior de idade: %s\n" +
                "Faltam %d dias para o seu aniversário.\n" +
                "%s\n", this.nome, formatter.format(this.dataNascimento), this.idade, this.maiorIdade ? "Sim" : "Não", diasFaltantes(),
                mediaFinal >= 8.5 ? "Você pode fazer uma festa.\n" : "Você não pode fazer uma festa.");
    }
}
