package it.prova.gestionefilm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import it.prova.gestionefilm.model.Regista;

public class RegistaDAOImpl implements RegistaDAO{
	
	private EntityManager entityManager; 

	@Override
	public void create(Regista input) throws Exception {
		if (input == null) {
			throw new Exception("Errore valore input.");
		}
		entityManager.persist(input);
	}

	@Override
	public Regista read(Long id) throws Exception {
		return entityManager.find(Regista.class, id);
	}

	@Override
	public List<Regista> readAll() throws Exception {
		return entityManager.createQuery("FROM Regista", Regista.class).getResultList();
	}

	@Override
	public void update(Regista input) throws Exception {
		if (input == null) {
			throw new Exception("Errore valore input.");
		}
		input = entityManager.merge(input); 
	}

	@Override
	public void delete(Long id) throws Exception {
		if (id == null) {
			throw new Exception("Errore valore input.");
		}
		entityManager.remove(entityManager.merge(id));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager; 
	}
	
	@Override
	public void deleteFilmRegistaAssociazione(Regista regista) throws Exception {
		Query query = entityManager.createNativeQuery("DELETE FROM regista_film WHERE id_regista = :idRegista");
		query.setParameter("idRegista", regista.getId());
		query.executeUpdate();

	}

}