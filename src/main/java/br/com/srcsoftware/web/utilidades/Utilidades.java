package br.com.srcsoftware.web.utilidades;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public abstract class Utilidades {
	private static final Locale LOCALE_PT_BR = Locale.of("pt", "BR"); // Sinta-se à vontade para usar new Locale("pt", "BR") se preferir

	
	public static final String gerarIdentificadorTemporalUploads() {
		return String.valueOf(getLocalDateTimeInMilisegundos(LocalDateTime.now()));
	}

	public static Long getLocalDateTimeInMilisegundos(LocalDateTime now) {
		return now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
	}

	public static final String generateCodigoGrande() {// 1475038593343260475265245324832E17
		String valor = String.valueOf(getLocalDateTimeInMilisegundos(LocalDateTime.now())) + String.valueOf(Math.random() * 99L).replace(".", "");
		return valor;
	}

	public static String removerEspacosExcedentes(String texto) {
		if (texto == null) {
			return null;
		}
		// \s+ captura um ou mais caracteres de espaço (espaços, tabs, quebras de linha)
		// .trim() remove espaços no início e no final da String
		return texto.trim().replaceAll("\\s+", " ");
	}

	public static BigDecimal parseBigDecimal(String value) {
		if (value == null || value.isBlank()) {
			return null;
		}

		// 1. Remove R$, $, €, espaços comuns e não-quebráveis (\u00A0)
		String cleaned = value.replaceAll("[R$\\s\\u00A0€]", "").trim();

		if (cleaned.isEmpty()) {
			return null;
		}

		// 2. Normaliza os separadores de milhar e decimal
		if (cleaned.contains(",") && cleaned.contains(".")) {
			// Formato com milhar e decimal (ex: 1.234,56 -> 1234.56)
			cleaned = cleaned.replace(".", "").replace(",", ".");
		} else if (cleaned.contains(",")) {
			// Formato apenas com vírgula decimal (ex: 1234,56 -> 1234.56)
			cleaned = cleaned.replace(",", ".");
		}

		// 3. Converte para BigDecimal
		try {
			return new BigDecimal(cleaned);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Valor monetário/numérico inválido: " + value, e);
		}
	}
	
	public static String parseBigDecimalComMoeda(BigDecimal value) {
        if (value == null) {
            return null;
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(LOCALE_PT_BR);
        return formatter.format(value);
    }
	
	public static String parseBigDecimal(BigDecimal value) {
        if (value == null) {
            return null;
        }

        NumberFormat formatter = NumberFormat.getNumberInstance(LOCALE_PT_BR);
        formatter.setMinimumFractionDigits(2);
        formatter.setMaximumFractionDigits(2);

        return formatter.format(value);
    }
}