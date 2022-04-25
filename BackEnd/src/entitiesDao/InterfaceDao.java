package entitiesDao;

import java.util.List;

import org.postgresql.util.PSQLException;


public interface InterfaceDao<T> {

	public boolean inserir(T t) throws PSQLException;
	public boolean alterar(T t);
	public boolean excluir(int id);
	public T pesquisarId(int id);
	public List<T> pesquisar();
	
}
