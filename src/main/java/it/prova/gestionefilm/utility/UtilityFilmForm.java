package it.prova.gestionefilm.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.model.Film;

public class UtilityFilmForm {

	public static Film createFilmFromParams(String titoloInputParam, String genereInputParam, String dataPubblicazioneInputParam,
			String minutiDurataInputParam) {
		
		Film result = new Film(titoloInputParam, genereInputParam); 
		
		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		
		result.setDataPubblicazione(parseDataPubblicazioneFromString(dataPubblicazioneInputParam));

		return result;
	}

	public static Film updateFilmFromParams(String idInputParam,String titoloInputParam, String genereInputParam, String dataPubblicazioneInputParam,
			String minutiDurataInputParam) {

		Film result = new Film(titoloInputParam, genereInputParam);

		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		if (NumberUtils.isCreatable(idInputParam)) {
			result.setId(Long.parseLong(idInputParam));
		}

		result.setDataPubblicazione(parseDataPubblicazioneFromString(dataPubblicazioneInputParam));
		
		return result; 
	}
	
	public static boolean validateFilmBean(Film filmToBeValidate) {
		if (StringUtils.isBlank(filmToBeValidate.getTitolo())
			|| StringUtils.isBlank(filmToBeValidate.getGenere())
			|| filmToBeValidate.getDataPubblicazione() == null
			|| filmToBeValidate.getMinutiDurata()<=0 
			){
			return false;
		}
		return true; 
	}
	
	public static LocalDate parseDataPubblicazioneFromString(String dataPubblicazioneInputParam) {
		if (StringUtils.isBlank(dataPubblicazioneInputParam))
			return null;

		try {
			return LocalDate.parse(dataPubblicazioneInputParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	
	
}
