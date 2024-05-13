package it.prova.gestionefilm.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionefilm.model.Regista;

public class UtilityRegistaForm {

	public static Regista createRegistaFromParams(String nomeInputParam, String cognomeInputParam,
			String nicknameInputParam, String dataDiNascitaInputParam, String createDateTimeInputParam,
			String updateDateTimeInputParam) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nicknameInputParam);

		result.setDataDiNascita(parseDataDiNascitaFromString(dataDiNascitaInputParam));
		result.setCreateDateTime(parseCreateDateTimeFromString(createDateTimeInputParam));
		result.setUpdateDateTime(parseUpdateDateFromString(updateDateTimeInputParam));

		return result;
	}

	public static boolean validateRegistaBean(Regista registaToBeValidate) {
		if (StringUtils.isBlank(registaToBeValidate.getNome()) || StringUtils.isBlank(registaToBeValidate.getCognome())
				|| StringUtils.isBlank(registaToBeValidate.getNickname())
				|| registaToBeValidate.getDataDiNascita() == null || registaToBeValidate.getCreateDateTime() == null
				|| registaToBeValidate.getUpdateDateTime() == null) {
			return false;
		}
		return true;
	}

	public static LocalDate parseDataDiNascitaFromString(String dataDiNascitaInputParam) {
		if (StringUtils.isBlank(dataDiNascitaInputParam))
			return null;

		try {
			return LocalDate.parse(dataDiNascitaInputParam);
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
