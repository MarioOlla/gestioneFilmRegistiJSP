package it.prova.gestionefilm.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface IBaseDAO<T> {
	
	public void create(T input) throws Exception; 
	
	public T read(Long id) throws Exception; 
	
	public List<T> readAll() throws Exception; 
	
	public void update(T input) throws Exception; 
	
	public void delete(Long id) throws Exception; 
	
	public void setEntityManager(EntityManager entityManager); 
	
}