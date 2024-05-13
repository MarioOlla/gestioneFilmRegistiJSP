package it.prova.gestionefilm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.Query;

import it.prova.gestionefilm.model.Film;

public class FilmDAOImpl implements FilmDAO {

	EntityManager entityManager;

	@Override
	public void create(Film film) throws Exception {
		entityManager.persist(film);

	}

	@Override
	public Film read(Long id) throws Exception {
		TypedQuery<Film> query = entityManager
				.createQuery("SELECT f FROM Film f LEFT JOIN FETCH f.regista WHERE f.id = :id", Film.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	@Override
	public List<Film> readAll() throws Exception {
		return entityManager.createQuery("SELECT DISTINCT f FROM Film f LEFT JOIN FETCH f.regista ", Film.class)
				.getResultList();
	}

	@Override
	public void update(Film film) throws Exception {
		entityManager.merge(film);
	}

	@Override
	public void delete(Film film) throws Exception {
		entityManager.remove(entityManager.merge(film));

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public void deleteFilmRegistaAssociazione(Film film) throws Exception {
		Query query = entityManager.createNativeQuery("DELETE FROM regista_film WHERE id_film = :idFilm ");
		query.setParameter("idFilm", film.getId());
		query.executeUpdate();

	}

}
