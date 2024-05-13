package it.prova.gestionefilm.service;

import it.prova.gestionefilm.dao.FilmDAO;
import it.prova.gestionefilm.dao.FilmDAOImpl;
import it.prova.gestionefilm.dao.RegistaDAO;
import it.prova.gestionefilm.dao.RegistaDAOImpl;

public class MyServiceFactory {
	// implementiamo il singleton in modo da evitare
	// proliferazione di riferimenti
	private static RegistaService REGISTA_SERVICE_INSTANCE = null;
	private static RegistaDAO REGISTADAO_INSTANCE = null;
	private static FilmService FILM_SERVICE_INSTANCE = null;
	private static FilmDAO FILMDAO_INSTANCE = null;

	public static RegistaService getRegistaServiceInstance() {
		if (REGISTA_SERVICE_INSTANCE == null)
			REGISTA_SERVICE_INSTANCE = new RegistaServiceImpl();

		if (REGISTADAO_INSTANCE == null)
			REGISTADAO_INSTANCE = new RegistaDAOImpl();

		REGISTA_SERVICE_INSTANCE.setRegistaDao(REGISTADAO_INSTANCE);
		;

		return REGISTA_SERVICE_INSTANCE;
	}

	public static FilmService getFilmServiceInstance() {
		if (FILM_SERVICE_INSTANCE == null)
			FILM_SERVICE_INSTANCE = new FilmServiceImpl();

		if (FILMDAO_INSTANCE == null)
			FILMDAO_INSTANCE = new FilmDAOImpl();

		FILM_SERVICE_INSTANCE.setFilmDao(FILMDAO_INSTANCE);

		return FILM_SERVICE_INSTANCE;
	}

}
