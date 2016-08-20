package examples.com.spannablebadges;


import java.io.Serializable;

public class TagDto implements Serializable {

    private String name;
    private String colorHex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public static TagDto createWith(String name, String colorHex) {
        TagDto dto = new TagDto();
        dto.setName(name);
        dto.setColorHex(colorHex);
        return dto;
    }
}
