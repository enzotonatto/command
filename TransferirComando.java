public class TransferirComando implements Comando {
    private ContaBancaria origem;
    private ContaBancaria destino;
    private double quantia;
    private double saldoAnteriorOrigem;
    private double saldoAnteriorDestino;

    public TransferirComando(ContaBancaria origem, ContaBancaria destino, double quantia) {
        this.origem = origem;
        this.destino = destino;
        this.quantia = quantia;
    }

    @Override
    public void executar() {
        saldoAnteriorOrigem = origem.getSaldo();
        saldoAnteriorDestino = destino.getSaldo();
        origem.transferir(destino, quantia);
    }

    @Override
    public void desfazer() {
        origem.setSaldo(saldoAnteriorOrigem);
        destino.setSaldo(saldoAnteriorDestino);
        System.out.println("Desfeita operação de transferência. Saldos atuais: " +
                origem.getTitular() + " R$" + origem.getSaldo() + ", " +
                destino.getTitular() + " R$" + destino.getSaldo());
    }
}

