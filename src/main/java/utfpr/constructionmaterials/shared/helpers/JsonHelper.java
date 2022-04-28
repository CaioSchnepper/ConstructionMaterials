package utfpr.constructionmaterials.shared.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import utfpr.constructionmaterials.events.EventDTO;

import java.io.IOException;

public class JsonHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String getEventName(byte[] message) {
        try {
            return objectMapper.readTree(message).fields().next().getKey();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao ler o nome do Evento", ex);
        }
    }

    public static <T extends EventDTO> T mapFromJson(byte[] message, Class<T> type) {
        try {
            return objectMapper.readValue(message, type);
        } catch (IOException ex) {
            throw new RuntimeException("Erro ao mapear a mensagem", ex);
        }
    }

    public static String mapToJson(EventDTO eventDTO) {
        try {
            return objectMapper.writeValueAsString(eventDTO);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException("Erro ao mapear o objeto em Json", ex);
        }
    }

    public static <T> T map(Object from, Class<T> toType) {
        return objectMapper.convertValue(from, toType);
    }

}
