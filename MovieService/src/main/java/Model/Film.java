package Model;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
public class Film {
    private Long id;
    private String name;
    private String category;
    private String description;
    @NotNull
    private Boolean isAvailable;

    public Film(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = "";
        this.isAvailable = false;
    }

}
