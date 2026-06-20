package ClinicaVeterinaria;

abstract class Animal {
 protected String nome;
 protected int idade;
 protected Cliente dono;
 protected static int totalAnimal = 0;

 public static int getTotalAnimal() {
  return totalAnimal;
 }

 public static void setTotalAnimal(int totalAnimal) {
  Animal.totalAnimal = totalAnimal;
 }

 Animal(String nome, int idade) {
  this.nome = nome;
  
  if(idade<0) {
   System.out.println("Idade inv�lida.");
  }else {
   this.idade = idade;
  }
  
  totalAnimal++;
  
 }

 Animal(String nome, int idade,Cliente dono){
  this(nome, idade);
  this.dono = dono;
  
 }

 public abstract void emitirSom();

 public String exibirDados() {
  if (dono != null) {
   
   return ("\nNome: " + nome + "\nIdade: " + idade + " Anos" + "\nTutor: " + dono.exibirInfo());
  } else {
   return ("\nNome: " + nome + "\nIdade: " + idade + " Anos" + "\nTutor: O animal n�o tem dono.\n");
  }

 }

}
