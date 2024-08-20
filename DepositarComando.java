public class DepositarComando implements Comando {
    private ContaBancaria conta;
    private double quantia;
    private double saldoAnterior;

    public DepositarComando(ContaBancaria conta, double quantia) {
        this.conta = conta;
        this.quantia = quantia;
    }

    @Override
    public void executar() {
        saldoAnterior = conta.getSaldo();
        conta.depositar(quantia);
    }

    @Override
    public void desfazer() {
        conta.setSaldo(saldoAnterior);
        System.out.println("Desfeita operação de depósito. Saldo atual: R$" + conta.getSaldo());
    }
}

