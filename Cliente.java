package ClinicaVeterinaria;

public class Cliente {
 private String nome;
 private String telefone;
	
 Cliente(String nome, String telefone, String cpf){
  this.nome = nome;
  this.telefone = telefone;
 }
	
 public String exibirInfo() {
 return " Nome: " + nome + "\n Telefone: " + telefone;
 }
}




