package serdeser.serdeser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.Before;
import org.junit.Test;
import serdeser.serdeser.dzejson.DzejsonEntity;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DzejsonTest {
    ObjectMapper objectMapper;
    String fileContent;

    @Before
    public void setup() throws Exception {
        this.objectMapper = new ObjectMapper();

        URI uri = getClass().getClassLoader().getResource("dzejson.json").toURI();
        List<String> lines = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        StringBuffer sb = new StringBuffer();

        for (String line : lines) {
            sb.append(line);
        }

        this.fileContent = sb.toString();
    }

    @Test
    public void checkJsonDeserialization() throws Exception {
        DzejsonEntity entity = objectMapper.readValue(fileContent, DzejsonEntity.class);
        assertEquals(entity.getStuff().getGunweight().longValue(), 5L);
        assertEquals(entity.getName(), "dzejk");
        assertEquals(entity.getSurname(), "henderson");
    }

    @Test
    public void checkNodeReplacement() throws Exception {
        JsonNode jsonNode = objectMapper.readTree(fileContent);
        JsonNode gunNode = jsonNode.get("gunweight");
        JsonNode stuffNode = jsonNode.get("stuff");
        ((ObjectNode) stuffNode).put("gunweight", gunNode);

        DzejsonEntity entity = objectMapper.readValue(jsonNode.toString(), DzejsonEntity.class);
        assertEquals(entity.getStuff().getGunweight().longValue(), 5L);
        assertEquals(entity.getName(), "dzejk");
        assertEquals(entity.getSurname(), "henderson");
    }
}
