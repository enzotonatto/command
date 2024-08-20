public class ContaBancaria {
    private String titular;
    private double saldo;

    public ContaBancaria(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double quantia) {
        saldo += quantia;
        System.out.println(titular + " depositou R$" + quantia + ". Saldo atual: R$" + saldo);
    }

    public void sacar(double quantia) {
        if (quantia <= saldo) {
            saldo -= quantia;
            System.out.println(titular + " sacou R$" + quantia + ". Saldo atual: R$" + saldo);
        } else {
            System.out.println(titular + " tentou sacar R$" + quantia + ", mas saldo insuficiente.");
        }
    }

    public void transferir(ContaBancaria destino, double quantia) {
        if (quantia <= saldo) {
            this.sacar(quantia);
            destino.depositar(quantia);
            System.out.println("Transferência de R$" + quantia + " realizada para " + destino.getTitular());
        } else {
            System.out.println("Transferência falhou. Saldo insuficiente.");
        }
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
