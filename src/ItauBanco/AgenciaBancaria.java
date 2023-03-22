package ItauBanco;


import java.util.Scanner;
import java.util.ArrayList;

public class AgenciaBancaria {

	static Scanner teclado = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;

	public static void main(String[] args) {

		contasBancarias = new ArrayList<Conta>();
		operacoes();

	}

	public static void operacoes() {

		System.out.println("------------------------------------------------");
		System.out.println("------------Bem vindo a nossa Agência-----------");
		System.out.println("------------------------------------------------");
		System.out.println("***** Selecione uma operação que deseja realizar");
		System.out.println("------------------------------------------------");
		System.out.println("|   Opção 1 - Criar conta    |");
		System.out.println("|   Opção 2 - Depositar      |");
		System.out.println("|   Opção 3 - Sacar          |");
		System.out.println("|   Opção 4 - Transferir     |");
		System.out.println("|   Opção 5 - Listar         |");
		System.out.println("|   Opção 6 - Sair           |");

		int operacoes = teclado.nextInt();
		switch (operacoes) {
		case 1:
			criarConta();
			break;
		case 2:
			depositar();
			break;
		case 3:
			sacar();
			break;
		case 4:
			transferir();
			break;
		case 5:
			listarContas();
			break;
		case 6:
			System.out.println("Obrigado por usar nosso banco");
			System.exit(0);
			break;

		default:
			System.out.println("Opção invalida, digita a opção correta");
			operacoes();
			break;
		}

	}

	public static void criarConta() {
		System.out.println("\nNome: ");
		String nome = teclado.next();

		System.out.println("\nCPF: ");
		String cpf = teclado.next();

		System.out.println("\nEmail: ");
		String email = teclado.next();

		Usuario cliente = new Usuario(nome, cpf, email);

		Conta conta = new Conta(cliente);

		contasBancarias.add(conta);
		System.out.println("Conta Criada com Sucesso!!!!" + "");

		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (contasBancarias.size() > 0) {
			for (Conta c : contasBancarias) {
				if (c.getNumeroConta() == numeroConta)
					;
				conta = c;
			}
		}

		return conta;
	}

	public static void depositar() {
		System.out.println("Numero da conta: ");
		int numeroConta = teclado.nextInt();

		Conta conta = encontrarConta(numeroConta);
		if (conta != null) {
			System.out.println("Qual valor deseja depositar");
			Double valorDeposito = teclado.nextDouble();
			conta.depositar(valorDeposito);
			System.out.println("O valor foi depositado com sucesso!!");
		} else {
			System.out.println("A conta para deposito não foi encontrada!!");
		}
		operacoes();

	}

	public static void sacar() {
		System.out.println("Digite o valor que deseja sacar");
		int numeroConta = teclado.nextInt();

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {
			System.out.println("Qual valor deseja sacar?");
			Double valorSaque = teclado.nextDouble();
			conta.sacar(valorSaque);
			System.out.println("Valor sacado com sucesso!!");
		} else {
			System.out.println("Saldo insuficiente!!");
		}
		operacoes();
	}

	public static void transferir() {
		System.out.println("Digite sua conta ");
		int numeroContaRemetente = teclado.nextInt();

		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		if (contaRemetente != null) {
			System.out.println("Digite a conta para a transferencia");
			int numeroContaDestinatario = teclado.nextInt();

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			if (contaDestinatario != null) {
				System.out.println("Qual valor da transferencia");
				Double valor = teclado.nextDouble();

				contaRemetente.transferir(contaDestinatario, valor);
					
			}else {
				
				System.out.println("Conta para deposito não encontrada!");
			}

		}else {
			System.out.println("Conta para transferencia não encontrada!");
		}
		operacoes();

	}

	public static void listarContas() {
		if (contasBancarias.size() > 0) {
			for (Conta conta : contasBancarias) {
				System.out.println(conta);
			}
		} else {
			System.out.println("Conta não cadastada");
		}
		operacoes();
	}
}
