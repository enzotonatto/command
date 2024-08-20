import java.util.Stack;

public class Banco {
    private Stack<Comando> historico = new Stack<>();

    public void executarComando(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazer() {
        if (!historico.isEmpty()) {
            Comando ultimoComando = historico.pop();
            ultimoComando.desfazer();
        }
    }
}
