package ClinicaVeterinaria;

import java.util.ArrayList;
import java.util.List;

public class PetShopRepositorio {

 private final ArrayList<Animal> animais = new ArrayList<>();

 /** Adiciona um animal � lista. */
 public void adicionar(Animal a) {
  animais.add(a);
 }

 /**
  * Busca um animal pelo nome (case-insensitive).
  * 
  * @return o Animal encontrado, ou null se n�o existir.
  */
 public Animal buscarPorNome(String nome) {
for (Animal anima: animais) {
	if (anima.getNome().equalsIgnoreCase(nome)) {
		return anima;
	}
}
  return null;
 }
 	
 
 public boolean atualizar(String nome, String raca, int idade, String dono, int telefone) {
     for (Animal anima : animais) {
         if (anima.getNome().equalsIgnoreCase(nome)) {
             
             
             anima.setIdade(idade);
             
            
             Cliente novoTutor = new Cliente(dono, telefone);
             anima.setDono(novoTutor);
             
            
             if (anima instanceof Cachorro) {
                 Cachorro cao = (Cachorro) anima;
                 cao.setRaca(raca); 
             }
             
             return true;
         }
     }
     return false; 
 }

 /**
  * Remove o animal com o nome informado.
  * 
  * @return true se encontrou e removeu, false caso contr�rio.
  */
 public boolean remover(String nome) {
	 for (Animal anima: animais) {
		 if (anima.getNome().equalsIgnoreCase(nome)) {
			 animais.remove(anima);
			 return true;
		 }
			
	 }
  return false;
 }

 /** Retorna a lista completa de animais cadastrados (cpia defensiva). */
 public ArrayList<Animal> listarTodos() {
  return animais;
  
 }

 /** Quantidade de animais cadastrados no reposit�rio. */
 public int quantidade() {
  return 0;
 }
}
