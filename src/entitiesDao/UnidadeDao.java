package entitiesDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Unidade;
import utils.Conexao;

public class UnidadeDao implements InterfaceDao<Unidade> {

	EntityManagerFactory emf;
	EntityManager em;

	public UnidadeDao() {
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}

	@Override
	public Unidade pesquisarId(int id) {
		Unidade unidade = em.find(Unidade.class, id);
		return unidade;
	}

	@Override
	public boolean inserir(Unidade unidade) {
		em.getTransaction().begin();
		em.persist(unidade);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean alterar(Unidade unidade) {
		em.getTransaction().begin();
		em.merge(unidade);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean excluir(int id) {
		Unidade unidade = em.find(Unidade.class, id);
		em.getTransaction().begin();
		em.remove(unidade);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public List<Unidade> pesquisar() {
		
		List<Unidade> unidade = new ArrayList<>();
		String sql = "select * from unidade";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				unidade.add(new Unidade(rs.getInt("id_unidade"),rs.getString("proprietario"),
						rs.getString("condominio") , rs.getString("endereco")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unidade;
	}

}
