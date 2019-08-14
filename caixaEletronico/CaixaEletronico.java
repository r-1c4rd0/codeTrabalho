/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.faculdade.unicesumar.caixaEletronico;

import trabalho.faculdade.unicesumar.bancario.conta.ContaCorrente;
import trabalho.faculdade.unicesumar.bancario.conta.ContaPoupanca;

/**
 *
 * @author Ricardo_Santiago
 */
public class CaixaEletronico {

    public static void main(String[] args) {

        // 'Criando as duas contas:
        ContaCorrente CC = new ContaCorrente(1234, 1111, 3, 500.00);
        ContaCorrente CC1 = new ContaCorrente(12345, 2222, 6, 500.00);
        ContaPoupanca cp = new ContaPoupanca(78910, 5555, 1, 500.00);
        ContaPoupanca cp1 = new ContaPoupanca(8910, 6666, 7, 500.00);

        // 'Um saque e imprimi saldo de duas contas:
        System.out.println("====PRIMEIRO=SAQUE==");
        cp.saque(500);//sacando R$ 500, 00, sobra R$520.00 --> R$20,00 de rendimento
        cp.saldo();
        System.out.println("=====================");
        System.out.println("====SEGUNDO=SAQUE====");
        CC.saque(500);
        CC.saldo();
        System.out.println("====================");

        /* 'Transferindo de duas contas e mostrando os valores 
        da contas envolvidas*/
        System.out.println("OCORRÊNCIA DAS DUAS TRANSFERÊNCIAS:: DA CONTA"
                + "POUPANÇA\n:: E DA CONTA CORRENTE");

        cp.transferencia(500.00, CC1);
        CC.transferencia(500.00, cp1);
        cp.saldo();
        CC1.saldo();
        CC.saldo();
        cp1.saldo();

        System.out.println(""
                + "/* 'Realiazando tentativa de saque e uma transfência que\n "
                + "não tenha saldo suficiente mesmo com limite */");
        CC.saque(20000);
        CC.saldo();
        System.out.println(".......conta CC acima");
        CC.transferencia(20000, CC1);
        System.out.println(".......conta CC transferiu?");
        CC1.saldo();
        CC.saldo();
        System.out.println("TESTE CONTROLADO DOS METODOS SACAR E TRANSFERIR");
        CC1.transferencia(100000, CC);
        CC.saldo();
        CC1.saldo();

    }

}
