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
    }

    @Override
    public void saque(double valor) {

        if (this.getSaldo() - this.getLimite() >= this.getLimite()) {
            this.setSaldo((this.getSaldo() - valor));
        } else {
            System.out.println("Valor indisponível");
        }
    }

   
    @Override
    public void transferencia(double valor, Conta ct) {
        if (this.getSaldo() <= 0) {
            if (this.getLimite() > 0 && this.getLimite()<valor) {
                this.setLimite((this.getLimite() - valor));
                ct.deposito(valor);
            }else{
                System.out.println("=================");
                System.out.println("TRANSFERÊNCIA NÃO AUTORIZADA!!!!");
                System.out.println("=================");
            }
        }else if(this.getSaldo()< valor){
            this.setSaldo((this.getSaldo()-valor));
            ct.deposito(valor);
        }else{
                System.out.println("=================");
                System.out.println("TRANSFERÊNCIA NÃO AUTORIZADA!!!!");
                System.out.println("=================");
            }

    
        
    
}
@Override
        public String toString(){
        String forLimeti = String.format("%,.2f", this.getLimite());
        return "  \tCORRENTE:::"+"\n\nLimite Disponível R$: "+forLimeti;
    }
}
