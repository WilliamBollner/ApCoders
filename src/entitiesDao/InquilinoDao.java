package entitiesDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Inquilino;
import utils.Conexao;

public class InquilinoDao implements InterfaceDao<Inquilino> {

	EntityManagerFactory emf;
	EntityManager em;

	public InquilinoDao() {
		emf = Persistence.createEntityManagerFactory("JPAPU");
		em = emf.createEntityManager();
	}

	@Override
	public boolean inserir(Inquilino t) {
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean alterar(Inquilino t) {
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public boolean excluir(int id) {
		Inquilino inquilino = em.find(Inquilino.class, id);
		em.getTransaction().begin();
		em.remove(inquilino);
		em.getTransaction().commit();
		em.close();
		return true;
	}

	@Override
	public Inquilino pesquisarId(int id) {
		Inquilino inquilino = em.find(Inquilino.class, id);
		return inquilino;
	}

	@Override
	public List<Inquilino> pesquisar() {
		List<Inquilino> inquilino = new ArrayList<>();
		String sql = "select * from inquilino";
		try {
			PreparedStatement stm = Conexao.conectar().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				inquilino.add(new Inquilino(rs.getInt("id_inquilino"), rs.getString("nome"),
						rs.getInt("idade"), rs.getString("sexo"), rs.getString("telefone"), rs.getString("email")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return inquilino;
	}

	

}
