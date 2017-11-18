package serdeser.serdeser.dzejson;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DzejsonEntity {
    private String name;
    private String surname;
    private Stuff stuff;
    private Integer gunweight;
}
