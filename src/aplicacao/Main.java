package aplicacao;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;

import entities.Inquilino;
import entities.Unidade;
import entitiesDao.InquilinoDao;
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
				String opcao = JOptionPane
						.showInputDialog("Deseja associar um inquilino a essa unidade?\n 1 - Sim \n 2 - Não");
				int idN = Integer.parseInt(opcao);
				Unidade unidade;
				if (idN == 1) {
					listarInquilinos();
					String idInquilino = JOptionPane.showInputDialog("Digite o id do inquilino: ");
					Integer IdI = Integer.parseInt(idInquilino);
					Inquilino inquilino = new InquilinoDao().pesquisarId(IdI);
					unidade = new Unidade(nome, condominio, endereco, inquilino);
				} else {
					unidade = new Unidade(nome, condominio, endereco);
				}
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
				}
			} else {
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

	static void pesquisarId() 
{
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

	static String listarUnidadesDoInquilino(int idInquilino) {
		String lista = "";
		try {
			List<Unidade> unidade = new UnidadeDao().pesquisarUnidadesDoInquilino(idInquilino);
			for (Unidade d : unidade) {
				lista += d.toString() + "\n";
			}

			JOptionPane.showMessageDialog(null, lista);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
			e.printStackTrace();
		}
		
		return lista;
	}

	// MÉTODOS CRUD INQUILINOS --------------------------------

	static void inserirInquilinos() {

		try {
			InquilinoDao inquilinoD = new InquilinoDao();
			int escolha = JOptionPane.showConfirmDialog(null, "Quer inserir um Inquilino?");
			if (escolha == 0) {
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				String idade = JOptionPane.showInputDialog("Digite a idade: ");
				int idN = Integer.parseInt(idade);
				String sexo = JOptionPane.showInputDialog("Digite o sexo: ");
				String telefone = JOptionPane.showInputDialog("Digite o telefone: ");
				String email = JOptionPane.showInputDialog("Digite o email: ");
				Inquilino inquilino = new Inquilino(nome, idN, sexo, telefone, email);
				if (inquilinoD.inserir(inquilino)) {
					System.out.println("Unidade salva com sucesso");
				} else {
					System.out.println("Erro ao salvar");
				}
			}

		} catch (ConstraintViolationException e) {
			JOptionPane.showMessageDialog(null, "O proprietário não pode ser nulo");
		}
	}

	static void listarInquilinos() {

		try {
			List<Inquilino> inquilino = new InquilinoDao().pesquisar();
			String lista = "";
			for (Inquilino d : inquilino) {
				lista += d.toString() + "\n" + listarUnidadesDoInquilino(d.getIdInquilino());
				
			}

			JOptionPane.showMessageDialog(null, lista);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
			e.printStackTrace();
		}

	}

	static void alterarInquilinos() {

		try {
			int escolha = JOptionPane.showConfirmDialog(null, "Quer alterar um inquilino?");
			if (escolha == 0) {
				listarInquilinos();
				String id = JOptionPane.showInputDialog("Digite o ID que quer alterar: ");
				int idN = Integer.parseInt(id);
				Inquilino inquilino = new InquilinoDao().pesquisarId(idN);
				String nome = JOptionPane.showInputDialog("Digite o nome: ");
				inquilino.setNome(nome);
				String idade = JOptionPane.showInputDialog("Digite a idade: ");
				int idadeP = Integer.parseInt(idade);
				inquilino.setIdade(idadeP);
				String sexo = JOptionPane.showInputDialog("Digite o sexo: ");
				inquilino.setSexo(sexo);
				String telefone = JOptionPane.showInputDialog("Digite o telefone: ");
				inquilino.setTelefone(telefone);
				String email = JOptionPane.showInputDialog("Digite o email: ");
				inquilino.setEmail(email);
				if (new InquilinoDao().alterar(inquilino)) {
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				}
			} else {
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Informe o suporte técnico");
			Menu.menuInquilino();
			e.printStackTrace();
		}

	}

	static void deletarInquilino() {

	}

	static void pesquisarIdInquilino() {

		try {
			String id = JOptionPane.showInputDialog("Digite o ID do inquilino: ");
			int idN = Integer.parseInt(id);
			Inquilino inquilino = new InquilinoDao().pesquisarId(idN);
			JOptionPane.showMessageDialog(null, inquilino.toString());
		} catch (NullPointerException e) {
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Comunique o suporte técnico");
		}
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

	// ---------------------------------------------------------
	static void sair() {
	}
}
