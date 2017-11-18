package serdeser.serdeser.dzejson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class DzejsonEntity {
    private String name;
    private String surname;
    private Stuff stuff;

    @JsonCreator
    public DzejsonEntity(
            @JsonProperty("stuff") Stuff stuff,
            @JsonProperty("gunweight") Long gunweight) {

        this.stuff = new Stuff();
        this.stuff.setBullet(stuff.getBullet());
        this.stuff.setGun(stuff.getGun());
        this.stuff.setGunweight(gunweight);
    }
}
