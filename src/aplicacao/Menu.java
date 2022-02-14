package aplicacao;

import javax.swing.JOptionPane;

public class Menu {

	static void menuPrincipal() {

		try {
			String opcao = JOptionPane.showInputDialog(null,
					"******************MENU PRINCIPAL******************\n1 - Unidades\n2 - Inquilinos\n3 - Despesas\n4 - Sair");
			if (opcao.charAt(0) == '1') {
				menuUnidade();
			} else if (opcao.charAt(0) == '2') {
				menuInquilino();
			} else if (opcao.charAt(0) == '3') {
				menuDespesa();
			} else if (opcao.charAt(0) == '4') {
				Main.sair();
			} else {
				JOptionPane.showMessageDialog(null, "Opcão inválida");
				menuPrincipal();
			}	
		} catch(StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuPrincipal();
		}
		catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuPrincipal();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro inesperado, informe o suporte técnico");
			e.printStackTrace();
			menuPrincipal();
		}

	}

	static void menuUnidade() {
		try {
			String opcao = JOptionPane.showInputDialog(null,
					"******************MENU UNIDADES******************\n1 - Cadastrar unidade\n2 - Alterar unidade\n3 - Pesquisar unidades\n4 - Pesquisar unidades pelo ID\n5 - Deletar unidade\n6 - Voltar para o menu principal");
			if (opcao.charAt(0) == '1') {
				Main.inserirUnidade();
				menuUnidade();
			} else if (opcao.charAt(0) == '2') {
				Main.alterarUnidade();
				menuUnidade();
			} else if (opcao.charAt(0) == '3') {
				Main.listarUnidades();
				menuUnidade();
			} else if (opcao.charAt(0) == '4') {
				Main.pesquisarId();
				menuUnidade();
			} else if (opcao.charAt(0) == '5') {
				Main.deletarUnidade();
				menuUnidade();
			} else if (opcao.charAt(0) == '6') {
				menuPrincipal();
			} else {
				JOptionPane.showMessageDialog(null, "Opcão inválida");
				menuUnidade();
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuUnidade();
		}
		catch(StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuUnidade();
		}

	}

	static void menuInquilino() {

		try {
			String opcao = JOptionPane.showInputDialog(null,
					"******************MENU INQUILINOS******************\n1 - Cadastrar inquilino\n2 - Alterar inquilino\n3 - Pesquisar inquilinos\n4 - Pesquisar inquilinos pelo ID\n5 - Deletar inquilino\n6 - Voltar para o menu principal");
			if (opcao.charAt(0) == '1') {
				Main.inserirInquilinos();
				menuInquilino();
			} else if (opcao.charAt(0) == '2') {
				Main.alterarInquilinos();
				menuInquilino();
			} else if (opcao.charAt(0) == '3') {
				Main.listarInquilinos();
				menuInquilino();
			} else if (opcao.charAt(0) == '4') {
				Main.pesquisarIdInquilino();
				menuInquilino();
			} else if (opcao.charAt(0) == '5') {
				Main.deletarInquilino();
				menuInquilino();
			} else if (opcao.charAt(0) == '6') {
				menuPrincipal();
			} else {
				JOptionPane.showMessageDialog(null, "Opcão inválida");
				menuInquilino();
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuInquilino();
		}
		catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuInquilino();
		}

	}

	static void menuDespesa() {
		try {
			String opcao = JOptionPane.showInputDialog(null,
					"******************MENU DESPESA******************\n1 - Cadastrar despesa\n2 - Alterar despesa\n3 - Pesquisar despesa\n4 - Pesquisar despesa pelo ID\n5 - Deletar despesa\n6 - Voltar para o menu principal");
			if (opcao.charAt(0) == '1') {
				Main.inserirDespesa();
				menuDespesa();
			} else if (opcao.charAt(0) == '2') {
				Main.alterarDespesa();
				menuDespesa();
			} else if (opcao.charAt(0) == '3') {
				Main.listarDespesas();
				menuDespesa();
			} else if (opcao.charAt(0) == '4') {
				Main.pesquisarIdDespesa();
				menuDespesa();
			} else if (opcao.charAt(0) == '5') {
				Main.deletarDespesa();
				menuDespesa();
			} else if (opcao.charAt(0) == '6') {
				menuPrincipal();
			} else {
				JOptionPane.showMessageDialog(null, "Opcão inválida");
				menuDespesa();
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuDespesa();
		}
		catch (StringIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Digite os números indicados");
			menuDespesa();
		}	
	}
}
