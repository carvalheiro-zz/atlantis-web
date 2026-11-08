package br.com.srcsoftware.web.config.resources;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.struts.util.PropertyMessageResources;
import org.apache.struts.util.PropertyMessageResourcesFactory;

public class Utf8PropertyMessageResources extends PropertyMessageResources {

	private static final long serialVersionUID = 5322698791762307152L;
	
	// Cache interno para garantir suporte a UTF-8 por Locale
    private final Map<String, Map<String, String>> customLocales = new HashMap<>();

    public Utf8PropertyMessageResources(PropertyMessageResourcesFactory factory, String config, boolean returnNull) {
        super(factory, config, returnNull);
    }

    @Override
    public synchronized String getMessage(Locale locale, String key) {
        String localeKey = (locale != null) ? locale.toString() : "";
        
        // Garante o carregamento do arquivo em UTF-8 se ainda não estiver em cache
        if (!customLocales.containsKey(localeKey)) {
            loadCustomLocale(localeKey);
        }

        Map<String, String> messages = customLocales.get(localeKey);
        if (messages != null && messages.containsKey(key)) {
            return messages.get(key);
        }

        // Fallback para o comportamento padrão caso não encontre no mapa customizado
        return super.getMessage(locale, key);
    }

    private void loadCustomLocale(String localeKey) {
        String fileName = config.replace('.', '/');
        if (!localeKey.isEmpty()) {
            fileName += "_" + localeKey;
        }
        fileName += ".properties";

        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is != null) {
                Properties props = new Properties();
                try (InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                    props.load(reader);
                }
                
                Map<String, String> messageMap = new HashMap<>();
                for (String name : props.stringPropertyNames()) {
                    messageMap.put(name, props.getProperty(name));
                }
                customLocales.put(localeKey, messageMap);
            }
        } catch (Exception e) {
            log.error("Erro ao carregar ApplicationResources em UTF-8 para o locale: " + localeKey, e);
        }
    }
}