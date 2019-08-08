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

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int a, int n, int d, double s) {
        super(a, n, d, s);        
        rendmento(0.02);
    }
   
    @Override
    public void setSaldo(double s){        
        if(this.saldo<0){
            System.out.println("Valor não permitido!!!");
        }else{
            this.saldo=s;
        }
            
    }
    @Override
    public void saque(double saque){
        if(this.getSaldo() >= 0.0 && saque <= this.getSaldo()){
            this.setSaldo(this.getSaldo() - saque);            
        }else{
            System.out.println(" Saldo insulficiente ");
        }        
    }   
    public void rendmento(double perc){ 
      double rendimento = this.getSaldo() * perc;
      this.setSaldo(this.getSaldo() + rendimento); 
      
   } 
   @Override
    public String toString(){
              return " \tPOUPANÇA:::\n";
        
    }
}
