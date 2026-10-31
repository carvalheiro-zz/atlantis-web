package br.com.srcsoftware.web.utilidades;

import java.lang.reflect.Type;
import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializer;

/**
 * Exemplos de uso:
 * 1 - Convertendo para um objeto simples:
 * TelaDTO tela = JsonUtils.fromJson(jsonStr, TelaDTO.class);
 * 
 * 2 - Convertendo para uma estrutura genérica / lista (usando Type):
 * ApiResponse<List<TelaDTO>> response = JsonUtils.fromJson(jsonStr, new TypeToken<ApiResponse<List<TelaDTO>>>(){}.getType());
 */
public class JsonUtils {

	private static final Gson GSON_COM_NULOS = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .registerTypeAdapter(Instant.class, (JsonSerializer<Instant>) (src, typeOfSrc, context) -> 
                src == null ? null : new JsonPrimitive(src.toString()))
            .registerTypeAdapter(Instant.class, (JsonDeserializer<Instant>) (json, typeOfT, context) -> 
                json == null ? null : Instant.parse(json.getAsString()))
            .create();

    public static String toJson(Object objeto) {
        if (objeto == null) {
            return "{}";
        }
        return GSON_COM_NULOS.toJson(objeto);
    }

    /**
     * Converte uma String JSON para uma instância de uma classe específica.
     * 
     * @param json String contendo a estrutura JSON
     * @param classe Class do objeto de destino
     * @return Objeto populado correspondente ao JSON
     */
    public static <T> T fromJson(String json, Class<T> classe) {
        if (json == null || json.trim().isEmpty()) {
            return null;
        }
        return GSON_COM_NULOS.fromJson(json, classe);
    }

    /**
     * Converte uma String JSON para um Tipo específico (útil para Collections e Generics como TypeToken).
     * 
     * @param json String contendo a estrutura JSON
     * @param typeOfT Type de destino (ex: new TypeToken<ApiResponse<List<DTO>>>(){}.getType())
     * @return Objeto populado correspondente ao JSON
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        if (json == null || json.trim().isEmpty()) {
            return null;
        }
        return GSON_COM_NULOS.fromJson(json, typeOfT);
    }

    public static Gson getGson() {
        return GSON_COM_NULOS;
    }
}