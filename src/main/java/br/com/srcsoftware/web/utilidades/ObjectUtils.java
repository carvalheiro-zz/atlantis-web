package br.com.srcsoftware.web.utilidades;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class ObjectUtils {

	public static boolean isAllFieldsNull(Object object) {
        if (object == null) {
            return true;
        }

        // Navega pela hierarquia de herança até a classe Object
        Class<?> currentClass = object.getClass();
        
        while (currentClass != null && currentClass != Object.class) {
            for (Field field : currentClass.getDeclaredFields()) {
                if (field.isSynthetic()) {
                    continue;
                }

                field.setAccessible(true);
                try {
                    Object value = field.get(object);

                    if (value == null) {
                        continue;
                    }

                    Class<?> type = field.getType();

                    if (type.isPrimitive()) {
                        if (isDefaultPrimitiveValue(value, type)) continue;
                        return false;
                    }

                    if (isPrimitiveWrapperOrString(type)) {
                        if (type == String.class && ((String) value).isBlank()) continue;
                        return false;
                    }

                    if (value instanceof Collection<?> col) {
                        if (col.isEmpty()) continue;
                        return false;
                    }
                    
                    if (value instanceof Map<?, ?> map) {
                        if (map.isEmpty()) continue;
                        return false;
                    }

                    // Chamada recursiva para objetos complexos
                    if (!isAllFieldsNull(value)) {
                        return false;
                    }

                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Erro ao acessar campo durante verificação", e);
                }
            }
            
            // Sobe para a superclasse na próxima iteração
            currentClass = currentClass.getSuperclass();
        }

        return true;
    }

    private static boolean isPrimitiveWrapperOrString(Class<?> type) {
        return type == String.class ||
               type == Integer.class || type == Long.class || 
               type == Double.class || type == Float.class ||
               type == Boolean.class || type == Byte.class || 
               type == Short.class || type == Character.class;
    }

    private static boolean isDefaultPrimitiveValue(Object value, Class<?> primitiveType) {
        if (primitiveType == boolean.class) return Boolean.FALSE.equals(value);
        if (primitiveType == char.class) return (Character) value == '\0';
        if (primitiveType == byte.class || primitiveType == short.class || 
            primitiveType == int.class || primitiveType == long.class) {
            return ((Number) value).longValue() == 0L;
        }
        if (primitiveType == float.class || primitiveType == double.class) {
            return ((Number) value).doubleValue() == 0.0;
        }
        return false;
    }
    
    
    public static boolean isNuloOuVazio(Object value) {
        return switch (value) {
            case null -> true;
            case String s -> s.isBlank(); // Considera null, "" ou apenas espaços em branco
            case Collection<?> c -> c.isEmpty();
            case Map<?, ?> m -> m.isEmpty();
            case Optional<?> o -> o.isEmpty();
            case Object[] arr -> arr.length == 0;
            default -> {
                // Suporte a arrays de primitivos (ex: int[], byte[])
                if (value.getClass().isArray()) {
                    yield Array.getLength(value) == 0;
                }
                yield false;
            }
        };
    }
}