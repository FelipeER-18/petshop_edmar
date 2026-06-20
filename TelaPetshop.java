package ClinicaVeterinaria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPetshop extends JFrame {

 private final PetShopRepositorio repositorio = new PetShopRepositorio();

 // ── Campos do formulário ───────────────────────────────
 private final JTextField campNome = new JTextField(10);
 private final JTextField campRaca = new JTextField(10);
 private final JTextField campIdade = new JTextField(10);
	
 private final JTextField TutorNome = new JTextField(10);
 private final JTextField TutorTelefone = new JTextField(10);
 // ── Área de resultado ──────────────────────────────────
 private final JTextArea areaResultado = new JTextArea(12, 50);

 // ── Botões ─────────────────────────────────────────────
 private final JButton btnCadastrar = new JButton ("Cadastrar");
 private final JButton btnBuscar = new JButton ("Buscar");
 private final JButton btnAtualizar = new JButton ("Buscar");
 private final JButton btnRemover = new JButton ("Remover");
	
 // ── Construtor ─────────────────────────────────────────
 public TelaPetshop() {
  super("Pet Shop — Gerenciador de Animais");
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  // O JFrame usa BorderLayout por padrão
  setLayout(new BorderLayout(8, 8));

  add(criarPainelFormulario(), BorderLayout.NORTH);
  add(criarAreaResultado(), BorderLayout.CENTER);
  add(criarPainelBotoes(), BorderLayout.SOUTH);

  configurarListeners();

  setSize(900, 600);
  pack();
  setLocationRelativeTo(null); // centraliza na tela

  setVisible(true);
 }

 // ── Painel Norte: formulário ───────────────────────────
 private JPanel criarPainelFormulario() {
  JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 6));
  painel.setBorder(BorderFactory.createTitledBorder("Dados do Pet e Tutor"));

  painel.add(new JLabel("Nome:"));
  painel.add(campNome);
  painel.add(new JLabel("Raça:"));
  painel.add(campRaca);
  painel.add(new JLabel("Idade:"));
  painel.add(campIdade);
  painel.add(new JLabel("Tutor:"));
  painel.add(TutorNome);
  painel.add(new JLabel("telefone"));
  painel.add(TutorTelefone);
  return painel;
 }

 // ── Centro: área de texto com scroll ──────────────────
 private JScrollPane criarAreaResultado() {
  areaResultado.setEditable(false);
  areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 13));
  areaResultado.setBorder(BorderFactory.createEmptyBorder(6, 8, 6, 8));
  exibirTexto("Bem-vindo ao sistema do Pet Shop!\n"
    + "Preencha os campos acima e use os botões para gerenciar os pets.\n");
  return new JScrollPane(areaResultado);
 }

 // ── Painel Sul: botões ─────────────────────────────────
 private JPanel criarPainelBotoes() {
  JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
  painel.add(btnCadastrar);
  painel.add(btnBuscar);
  painel.add(btnAtualizar);
  painel.add(btnRemover);
  return painel;
 }

 // ── ActionListeners ────────────────────────────────────
 private void configurarListeners() {

  // ---- CADASTRAR ----
  btnCadastrar.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    String nome = campNome.getText().trim();
    String raca = campRaca.getText().trim();
    int idade = Integer.parseInt(campIdade.getText());
    
    if (nome.isEmpty()) {
     exibirTexto("ERRO: O campo Nome é obrigatório.");
     return;
    }
    
    if (raca.isEmpty()) {
     raca = "Indefinida";
    }
    
    if (idade <= 0) {
     exibirTexto("ERRO: Idade inválida.");
     return;
    }

    Cachorro novo = new Cachorro(nome, raca, idade);

    repositorio.adicionar(novo);
    exibirTexto("Pet cadastrado com sucesso!\n\n" + novo.exibirDados());
    limparCampos();
   }
  });

 }

 // ── Métodos auxiliares ─────────────────────────────────

 /** Exibe texto na área de resultado, substituindo o conteúdo anterior. */
 private void exibirTexto(String texto) {
  areaResultado.setText(texto);
 }

 /** Limpa todos os campos do formulário. */
 private void limparCampos() {
  campNome.setText("");
  campRaca.setText("");
  campNome.requestFocus();
 }

}

