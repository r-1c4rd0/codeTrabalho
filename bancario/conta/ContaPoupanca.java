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
public class ContaPoupanca extends Conta {

    public ContaPoupanca(int a, int n, int d, double s) {
        super(a, n, d, s);
        rendimento(0.02);
    }

    
    public void rendimento(double perc) {
        double rendimento = this.getSaldo() * perc;
        this.setSaldo(this.getSaldo() + rendimento);
    }

    @Override
    public String toString() {
        return " \tPOUPANÇA:::\n";

    }
}
