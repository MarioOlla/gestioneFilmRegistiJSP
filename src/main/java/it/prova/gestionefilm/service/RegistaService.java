package it.prova.gestionefilm.service;

import java.util.List;

import it.prova.gestionefilm.dao.RegistaDAO;
import it.prova.gestionefilm.model.Regista;

public interface RegistaService {

	public void setRegistaDao(RegistaDAO registaDao);
	
	public void create(Regista input) throws Exception;

	public Regista read(Long id) throws Exception;

	public List<Regista> readAll() throws Exception;

	public void update(Regista input) throws Exception;

	public void delete(Long id) throws Exception;
}
