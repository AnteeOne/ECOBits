package tech.anteeone.ecobits.models;

public class Achievement {

    private Integer id;
    private String title;
    private String description;

    public Achievement(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
