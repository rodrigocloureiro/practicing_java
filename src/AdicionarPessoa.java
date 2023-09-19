import java.util.ArrayList;
import java.util.List;

public class AdicionarPessoa implements Adicionar {
    private List<Pessoa> pessoas;

    public AdicionarPessoa() {
        this.pessoas = new ArrayList<>();
    }

    @Override
    public void adicionarPessoa(Pessoa p) {
        this.pessoas.add(p);
    }

    @Override
    public List<Pessoa> listaPessoas() {
        return this.pessoas;
    }
}
