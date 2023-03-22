package ItauBanco;



import Utilitarios.Utils;

public class Conta {
	
	private static int contadordeContas = 1;

 private int numeroConta;
 private Usuario pessoa;
 private Double saldo = 0.0;
 
 
public Conta(Usuario pessoa) {
	this.numeroConta = contadordeContas;
	this.pessoa = pessoa;
	contadordeContas += 1;
		
}

public int getNumeroConta() {
	return numeroConta;
}

public void setNumeroConta(int numeroConta) {
	this.numeroConta = numeroConta;
}

public Usuario getPessoa() {
	return pessoa;
}

public void setPessoa(Usuario pessoa) {
	this.pessoa = pessoa;
}

public Double getSaldo() {
	return saldo;
}

public void setSaldo(Double saldo) {
	this.saldo = saldo;
}

public String toString() {
		
	return "\nNumero da conta:" + this.getNumeroConta() +
			"\nNome "+ this.pessoa.getNome()+
			"\nCPF:" + this.pessoa.getCPF() +
			"\nEmail"+ this.pessoa.getEmail()+
			"\nSaldo" + Utils.doubleToString(this.saldo)+
			"\n";
}

public void depositar(Double valor) {
	
	if(valor > 0) {
	    
		setSaldo(getSaldo()+ valor);
		System.out.println("Seu deposito foi realizado com sucesso");
	} else {
		System.out.println("Seu Deposito não foi realizado");
	}
	
	
}

	public void sacar(Double valor) {
	
	if(valor > 0 && this.getSaldo() >= valor) {
		setSaldo(getSaldo()- valor);
		System.out.println("Saque realizado com sucesso");
	}else {
		System.out.println("Não foi possivel realizar seu saque");
	}
	
	 }
	public void transferir(Conta contaParaDeposito, Double valor){
		if(valor > 0  && this.getSaldo() >= valor){
			setSaldo(getSaldo()- valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo()+valor;
			System.out.println("Transferencia realizada com sucesso");
		} else {
			
			System.out.println("Transferencia não realizada");
		}

}
}