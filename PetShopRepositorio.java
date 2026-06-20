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

  return null;
 }

 /**
  * Remove o animal com o nome informado.
  * 
  * @return true se encontrou e removeu, false caso contr�rio.
  */
 public boolean remover(String nome) {
  return true;
 }

 /** Retorna a lista completa de animais cadastrados (c�pia defensiva). */
 public ArrayList<Animal> listarTodos() {
  return animais;
 }

 /** Quantidade de animais cadastrados no reposit�rio. */
 public int quantidade() {
  return 0;
 }
}
