package ClinicaVeterinaria;

public class Cachorro extends Animal{

 private String raca;

 private static int totalCachorros = 0;

 public static int getTotalCachorros() {
  return totalCachorros;
 }

 public static void setTotalCachorros(int totalCachorros) {
  Cachorro.totalCachorros = totalCachorros;
 }
	
 Cachorro(String nome,String raca, int idade) {
  super(nome, idade);
  this.raca = raca;
  totalCachorros += 1;
 }

 @Override
 public String exibirDados() {
  return
    super.exibirDados() + "\nRa�a: " + raca;
 }

 @Override
 public void emitirSom() {
  System.out.println("\n" + nome + " diz: Auau!");
 }

}
