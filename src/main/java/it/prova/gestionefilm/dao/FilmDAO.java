package it.prova.gestionefilm.dao;

import it.prova.gestionefilm.model.Film;

public interface FilmDAO extends IBaseDAO<Film>{
	
	public void deleteFilmRegistaAssociazione(Film film) throws Exception; 

}
