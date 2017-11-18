package serdeser.serdeser.dzejson;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Stuff {
    private String gun;
    private String bullet;

    @JsonIgnore
    private Long gunweight;
}
