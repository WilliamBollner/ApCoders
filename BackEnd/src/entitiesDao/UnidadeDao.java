package entitiesDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import entities.Unidade;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Unidade> pesquisar() {
		List<Unidade> unidades = null;
		try {

			unidades = em.createQuery("from Unidade u").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return unidades;

	}

	@SuppressWarnings("unchecked")
	public List<Unidade> pesquisarUnidadesDoInquilino(int inquilinoId) {
		List<Unidade> unidades = null;
		try {

			unidades = em.createQuery("from Unidade where id_inquilino = " + inquilinoId).getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}
		return unidades;
	}

}
