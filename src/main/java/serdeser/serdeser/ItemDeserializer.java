package serdeser.serdeser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.apache.commons.lang3.tuple.MutablePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemDeserializer extends StdDeserializer<List<MutablePair<String, String>>> {

    public ItemDeserializer() {
        this(null);
    }

    public ItemDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<MutablePair<String, String>> deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        ArrayNode node = jp.getCodec().readTree(jp);
        List<MutablePair<String, String>> list = new ArrayList<>();

        for (JsonNode singleNode : node) {
            Map.Entry<String, JsonNode> entry = singleNode.fields().next();

            String key = entry.getKey();
            String value = entry.getValue().textValue();
            list.add(new MutablePair<>(key, value));
        }

        return list;
    }
}