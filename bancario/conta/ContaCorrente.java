/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.faculdade.unicesumar.bancario.conta;

/**
 *
 * @author Ricardo_Santiago
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(int a, int n, int d, double s) {
        super(a, n, d, s);
        double v = this.getSaldo();
        this.setLimite(v);
    }
    // atributo privado da classe
    private double limite;

    //getters e setters do atributo privado da classe
    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        double v = this.getSaldo();
        this.limite = (v + (v * 0.03));
        if(this.getLimite()<this.getSaldo())
            this.setSaldo(this.getLimite());
    }

    @Override
    public void saque(double valor) {
        if (this.getSaldo()>=0&&this.getSaldo()>=valor) {
            this.setSaldo( (this.getSaldo()- valor) );
        } else if (this.getSaldo() <= 0 && this.getLimite() >= valor) {
            this.setSaldo((this.getLimite() - valor));
        } else  {
            System.out.println("======================");
            System.out.println("SEM SALDO DISPONÍVEL");
            System.out.println("======================");
        }
    }

    @Override
    public void transferencia(double valor, Conta ct) {
        if(this.getSaldo()>= valor || this.getLimite()>=valor && this.getLimite()-valor>=0 ){
            this.setSaldo( (this.getSaldo()-valor));            
            ct.deposito(valor);           
        }
        System.out.println("==========================");
        System.out.println("TRANSFERÊNCIA NÃO REALIZADA");
        System.out.println("==========================");
    }

    @Override
    public String toString() {
        String forLimeti = String.format("%,.2f", this.getLimite());
        return "  \tCORRENTE:::" + "\n\nLimite Disponível R$: " + forLimeti;
    }
}
