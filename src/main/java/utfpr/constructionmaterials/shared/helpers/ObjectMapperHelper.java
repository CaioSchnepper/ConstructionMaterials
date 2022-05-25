package utfpr.constructionmaterials.shared.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import utfpr.constructionmaterials.events.EventDTO;
import utfpr.constructionmaterials.shared.constants.EventNames;

import java.io.IOException;

import static utfpr.constructionmaterials.shared.constants.ErrorMessages.*;

public class ObjectMapperHelper {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);

    public static <T extends EventDTO> T mapFromJson(byte[] message, Class<T> type) {
        try {
            return objectMapper.readValue(message, type);
        } catch (IOException ex) {
            throw new RuntimeException(EVENT_MESSAGE_INVALID, ex);
        }
    }

    public static String mapToJson(EventDTO eventDTO) {
        try {
            return objectMapper.writeValueAsString(eventDTO);
        } catch (JsonProcessingException ex) {
            throw new RuntimeException(EVENT_PARSE_ERROR, ex);
        }
    }

    public static <T> T map(Object from, Class<T> toType) {
        return objectMapper.convertValue(from, toType);
    }

    public static String getEventName(byte[] message) {
        try {
            return objectMapper.readTree(message).fields().next().getKey();
        } catch (Exception ex) {
            throw new RuntimeException(EVENT_NAME_INVALID, ex);
        }
    }

    public static boolean isErrorMessage(byte[] message) {
        try {
            return objectMapper.readTree(message).elements().next().has(EventNames.ERROR);
        } catch (Exception ex) {
            throw new RuntimeException(EVENT_MESSAGE_INVALID, ex);
        }
    }

}
