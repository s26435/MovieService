package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Film {
    private int id;
    private String name;
    private String category;
    private String description;

    public Film(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = "";
    }
}
