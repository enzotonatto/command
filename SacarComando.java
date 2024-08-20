public class SacarComando implements Comando {
    private ContaBancaria conta;
    private double quantia;
    private double saldoAnterior;

    public SacarComando(ContaBancaria conta, double quantia) {
        this.conta = conta;
        this.quantia = quantia;
    }

    @Override
    public void executar() {
        saldoAnterior = conta.getSaldo();
        conta.sacar(quantia);
    }

    @Override
    public void desfazer() {
        conta.setSaldo(saldoAnterior);
        System.out.println("Desfeita operação de saque. Saldo atual: R$" + conta.getSaldo());
    }
}
