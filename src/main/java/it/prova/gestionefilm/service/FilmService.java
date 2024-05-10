package it.prova.gestionefilm.service;

import java.util.List;

import it.prova.gestionefilm.dao.FilmDAO;
import it.prova.gestionefilm.model.Film;

public interface FilmService {

	public void create(Film film) throws Exception;

	public Film read(Long id) throws Exception;

	public List<Film> readAll() throws Exception;

	public void update(Film film) throws Exception;

	public void delete(Long idFilm) throws Exception;

	public void setFilmDao(FilmDAO filmDao);

}
