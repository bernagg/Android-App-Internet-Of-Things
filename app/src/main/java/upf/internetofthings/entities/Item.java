package upf.internetofthings.entities;

public class Item {
    private Integer id;
    private String description;
    private String tag;

    public Item(Integer id, String description, String tag) {
        this.id = id;
        this.description = description;
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
