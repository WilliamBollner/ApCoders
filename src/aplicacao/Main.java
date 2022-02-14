package aplicacao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;

import entities.Unidade;
import entitiesDao.UnidadeDao;
import utils.Conexao;

public class Main {

	public static void main(String[] args) {

		if (Conexao.conectar() != null) {
			System.out.println("Conectou ao banco");
		} else {
			System.out.println("Erro ao conectar");
		}

		Menu.menuPrincipal();

	}
	
	// MÉTODOS CRUD UNIDADES ----------------------------------

	static void inserirUnidade() {
		try {
			UnidadeDao unidadeD = new UnidadeDao();
			int escolha = JOptionPane.showConfirmDialog(null, "Quer inserir uma unidade?");
			if (escolha == 0) {
				String nome = JOptionPane.showInputDialog("Digite o proprietário: ");
				String condominio = JOptionPane.showInputDialog("Digite o condomínio: ");
				String endereco = JOptionPane.showInputDialog("Digite o endereço: ");
				Unidade unidade = new Unidade(nome, condominio, endereco);
					if (unidadeD.inserir(unidade)) {
						System.out.println("Unidade salva com sucesso");
					} else {
						System.out.println("Erro ao salvar");
					}
			}
		}

		catch (ConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "O proprietário não pode ser nulo");
		}

	}

	static void listarUnidades() {
		try {
			List<Unidade> unidade = new UnidadeDao().pesquisar();
			String lista = "";
			for (Unidade d : unidade) {
				lista += d.toString() + "\n";
			}

			JOptionPane.showMessageDialog(null, lista);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
			e.printStackTrace();
		}

	}

	static void alterarUnidade() {

		try {
			int escolha = JOptionPane.showConfirmDialog(null, "Quer alterar uma unidade?");
			if (escolha == 0) {
				listarUnidades();
				String id = JOptionPane.showInputDialog("Digite o ID que quer alterar: ");
				int idN = Integer.parseInt(id);
				Unidade unidade = new UnidadeDao().pesquisarId(idN);
				String nome = JOptionPane.showInputDialog("Digite o proprietário: ");
				unidade.setProprietario(nome);
				String condominio = JOptionPane.showInputDialog("Digite o condomínio: ");
				unidade.setCondominio(condominio);
				String endereco = JOptionPane.showInputDialog("Digite o endereço: ");
				unidade.setEndereco(endereco);
				if (new UnidadeDao().alterar(unidade)) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					Menu.menuUnidade();
				}
			} else {
				Menu.menuUnidade();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
			Menu.menuUnidade();
			e.printStackTrace();
		}
	}

	static void deletarUnidade() {
		try {
			listarUnidades();
			String id = JOptionPane.showInputDialog("Digite o ID que quer deletar: ");
			int idN = Integer.parseInt(id);
			UnidadeDao unidadeDao = new UnidadeDao();
			Unidade unidade = new UnidadeDao().pesquisarId(idN);
			JOptionPane.showMessageDialog(null, unidade.toString());
			int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir essa unidade?");
			if (opcao == 0) {
				if (unidadeDao.excluir(idN)) {
					JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				}
			} else {
				Menu.menuUnidade();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
		}

	}

	static void pesquisarId() {
		try {
			String id = JOptionPane.showInputDialog("Digite o ID que quer pesquisar: ");
			int idN = Integer.parseInt(id);
			Unidade unidade = new UnidadeDao().pesquisarId(idN);
			JOptionPane.showMessageDialog(null, unidade.toString());
			Menu.menuUnidade();
		} catch (NullPointerException e) {
			Menu.menuUnidade();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Comunique o suporte técnico");
		}
	}

	// MÉTODOS CRUD INQUILINOS --------------------------------
	
	static void inserirInquilinos() {
		
	}
	
	static void listarInquilinos() {
		
	}
	
	static void alterarInquilinos() {
		
	}
	
	static void deletarInquilino() {
		
	}
	
	static void pesquisarIdInquilino() {
		
	}
	
	
	// MÉTODOS CRUD DESPESAS ----------------------------------
	
	static void inserirDespesa() {
		
	}
	
	static void listarDespesas() {
		
	}
	
	static void alterarDespesa() {
		
	}
	
	static void deletarDespesa() {
		
	}
	
	static void pesquisarIdDespesa() {
		
	}

	
	
	//---------------------------------------------------------
	static void sair() {
	}
}
