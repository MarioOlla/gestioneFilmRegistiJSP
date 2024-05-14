package it.prova.gestionefilm.utility;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionefilm.model.Regista;

public class UtilityRegistaForm {

	public static Regista createRegistaFromParams(String nomeInputParam, String cognomeInputParam,
			String nicknameInputParam, String dataDiNascitaInputParam) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nicknameInputParam);

		result.setDataDiNascita(parseDataDiNascitaFromString(dataDiNascitaInputParam));

		return result;
	}

	public static Regista updateRegistaFromParams(String idInputParam,String nomeInputParam, String cognomeInputParam,
			String nicknameInputParam, String dataDiNascitaInputParam) {

		Regista result = new Regista(nomeInputParam, cognomeInputParam, nicknameInputParam);
		if (NumberUtils.isCreatable(idInputParam)) {
			result.setId(Long.parseLong(idInputParam));
		}
		result.setDataDiNascita(parseDataDiNascitaFromString(dataDiNascitaInputParam));

		return result;
	}

	public static boolean validateRegistaBean(Regista registaToBeValidate) {
		if (StringUtils.isBlank(registaToBeValidate.getNome()) || StringUtils.isBlank(registaToBeValidate.getCognome())
				|| StringUtils.isBlank(registaToBeValidate.getNickname())
				|| registaToBeValidate.getDataDiNascita() == null) {
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

}
