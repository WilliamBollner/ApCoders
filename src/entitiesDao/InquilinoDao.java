package entitiesDao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Inquilino;

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
		// TODO Auto-generated method stub
		return null;
	}

	

}
