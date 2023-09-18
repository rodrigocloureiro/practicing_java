import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Pessoa p = new Pessoa("Rodrigo Loureiro", formatter.parse("04/06/2001"), 8.5);

        System.out.println(p);
    }
}
