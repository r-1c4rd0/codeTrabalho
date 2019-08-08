/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.faculdade.unicesumar.bancario.conta;
import java.time.LocalDate;
/**
 *
 * @author Ricardo_Santiago
 */
public class Conta {
    protected int agencia;
    protected int numero;
    protected int digito;
    protected double saldo;
    
    
    public Conta(){
        this(0,0,0,0);
    }
    
    public Conta(Conta cp){
        this(cp.agencia, cp.digito, cp.numero, cp.saldo);
    }
    
    public Conta(int a, int n, int d, double s){
        this.setAgencia(a);
        this.setNumero(n);
        this.setDigito(d);
        this.setSaldo(s);
    }
   

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void deposito(double valor){
        this.setSaldo(this.getSaldo()+valor);
    }
    public void transferencia(double valor, Conta ct){
        if(valor>0){   
            if(this.getSaldo()<=0){
                System.out.println("Conta sem saldo!!!");
            }else{
                
                this.saque(valor);
                //this.setSaldo();
                ct.deposito(valor);
                //ct.setSaldo();
                
                System.out.println("Dinheiro transferido\n\n");
            }
        }    
        
   }
    public void saque(double valor){
        if(this.getSaldo() >= 0.0&&this.getSaldo() - valor>0){            
            this.setSaldo((this.getSaldo() - valor));
            System.out.println("SAQUE REALIZADO COM SUCESSO!!!");            
        }else{
            
            System.out.println("LIMITE NÃO DISPONIVEL!!! ");
        }
        
    }
    
    public void saldo(){
        System.out.println("\t\n\n_________________________________");
        System.out.println("=================================");
        System.out.println(":::CONTA       "+toString());
        System.out.println("=================================");
        
        System.out.println(" |Agência:     "+this.getAgencia()+"\n |Conta:    "+ this.getNumero()+"-"+this.getDigito());
        System.out.printf(" |Saldo: " + String.format("R$%,.2f", this.getSaldo())+"\n");
        System.out.println("=================================\n\n\t");
    }
    
    
   
    
}
