public class Cliente {
    public static void main(String[] args) {
        ContaBancaria conta1 = new ContaBancaria("João", 1000.0);
        ContaBancaria conta2 = new ContaBancaria("Maria", 500.0);
        Banco banco = new Banco();

        // Comandos
        Comando deposito = new DepositarComando(conta1, 200.0);
        Comando saque = new SacarComando(conta1, 150.0);
        Comando transferencia = new TransferirComando(conta1, conta2, 300.0);

        // Executando comandos
        banco.executarComando(deposito);
        banco.executarComando(saque);
        banco.executarComando(transferencia);

        // Desfazendo comandos
        banco.desfazer();  // Desfaz transferência
        banco.desfazer();  // Desfaz saque
    }
}
