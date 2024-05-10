package it.prova.gestionefilm.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionefilm.dao.FilmDAO;
import it.prova.gestionefilm.model.Film;
import it.prova.gestionefilm.web.listener.LocalEntityManagerFactoryListener;

public class FilmServiceImpl implements FilmService {

	private FilmDAO filmDaoInstance;

	@Override
	public void setFilmDao(FilmDAO filmDao) {
		this.filmDaoInstance = filmDao;
	}

	@Override
	public void create(Film film) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			filmDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			filmDaoInstance.create(film);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}

	}

	@Override
	public Film read(Long id) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			filmDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return filmDaoInstance.read(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Film> readAll() throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// uso l'injection per il dao
			filmDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return filmDaoInstance.readAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Film film) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			filmDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			filmDaoInstance.update(film);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void delete(Long idFilm) throws Exception {
		// questo è come una connection
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			filmDaoInstance.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			filmDaoInstance.delete(filmDaoInstance.read(idFilm));
			;

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
