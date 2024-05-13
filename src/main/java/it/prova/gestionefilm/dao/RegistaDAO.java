package it.prova.gestionefilm.dao;

import it.prova.gestionefilm.model.Regista;

public interface RegistaDAO extends IBaseDAO<Regista>{

	public void deleteFilmRegistaAssociazione(Regista regista) throws Exception;
}
