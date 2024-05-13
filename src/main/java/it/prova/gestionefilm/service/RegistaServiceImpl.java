package it.prova.gestionefilm.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestionefilm.dao.RegistaDAO;
import it.prova.gestionefilm.model.Regista;
import it.prova.gestionefilm.web.listener.LocalEntityManagerFactoryListener;

public class RegistaServiceImpl implements RegistaService{

	private RegistaDAO registaDao; 
	
	@Override
	public void setRegistaDao(RegistaDAO registaDao) {
		this.registaDao = registaDao; 
	}

	@Override
	public void create(Regista input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			registaDao.setEntityManager(entityManager);
			registaDao.create(input);
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public Regista read(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			registaDao.setEntityManager(entityManager);
			return registaDao.read(id);
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public List<Regista> readAll() throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			registaDao.setEntityManager(entityManager);
			return registaDao.readAll(); 
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Regista input) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			registaDao.setEntityManager(entityManager);
			registaDao.update(input);
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

	@Override
	public void delete(Long id) throws Exception {
		EntityManager entityManager = LocalEntityManagerFactoryListener.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			registaDao.setEntityManager(entityManager);
			registaDao.delete(registaDao.read(id));
			entityManager.getTransaction().commit();
		} catch (Exception e){
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			LocalEntityManagerFactoryListener.closeEntityManager(entityManager);
		}
	}

}
