public class Cliente {
 private String nome;
 private int telefone;
	
 Cliente(String nome, int telefone){
  this.nome = nome;
  this.telefone = telefone;
 }
	
 public String exibirInfo() {
 return " Nome: " + nome + "\n Telefone: " + telefone;
 }
}



