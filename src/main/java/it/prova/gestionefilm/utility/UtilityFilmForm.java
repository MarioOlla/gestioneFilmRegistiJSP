package it.prova.gestionefilm.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.model.Film;

public class UtilityFilmForm {

	public static Film createFilmFromParams(String titoloInputParam, String genereInputParam, String dataPubblicazioneInputParam,
			String minutiDurataInputParam, String createDateTimeInputParam, String updateDateTimeInputParam) {
		
		Film result = new Film(titoloInputParam, genereInputParam); 
		
		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		
		result.setDataPubblicazione(parseDataPubblicazioneFromString(dataPubblicazioneInputParam));
		result.setCreateDateTime(parseCreateDateTimeFromString(createDateTimeInputParam));
		result.setUpdateDateTime(parseUpdateDateFromString(updateDateTimeInputParam));
		
		return result; 
	}
	
	public static Film updateFilmFromParams(String titoloInputParam, String genereInputParam, String dataPubblicazioneInputParam,
			String minutiDurataInputParam, String updateDateTimeInputParam) {
		
		Film result = new Film(titoloInputParam, genereInputParam); 
		
		if (NumberUtils.isCreatable(minutiDurataInputParam)) {
			result.setMinutiDurata(Integer.parseInt(minutiDurataInputParam));
		}
		
		result.setDataPubblicazione(parseDataPubblicazioneFromString(dataPubblicazioneInputParam));
		result.setUpdateDateTime(parseUpdateDateFromString(updateDateTimeInputParam));
		
		return result; 
	}
	
	public static boolean validateFilmBean(Film filmToBeValidate) {
		if (StringUtils.isBlank(filmToBeValidate.getTitolo())
			|| StringUtils.isBlank(filmToBeValidate.getGenere())
			|| filmToBeValidate.getDataPubblicazione() == null
			|| filmToBeValidate.getMinutiDurata()<=0 
			|| filmToBeValidate.getCreateDateTime() == null
			|| filmToBeValidate.getUpdateDateTime() == null){
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
	
	public static LocalDateTime parseCreateDateTimeFromString(String createDateTimeInputParam) {
		if (StringUtils.isBlank(createDateTimeInputParam))
			return null;

		try {
			return LocalDateTime.parse(createDateTimeInputParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	public static LocalDateTime parseUpdateDateFromString(String updateDateInputParam) {
		if (StringUtils.isBlank(updateDateInputParam))
			return null;

		try {
			return LocalDateTime.parse(updateDateInputParam);
		} catch (DateTimeParseException e) {
			return null;
		}
	}
	
	
}
