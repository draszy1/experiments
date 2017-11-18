package serdeser.serdeser;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.tuple.MutablePair;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class Encja {
    private String id;

    @JsonDeserialize(using = ItemDeserializer.class)
    private List<MutablePair<String, String>> listapar;
}
