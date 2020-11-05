package tech.anteeone.ecobits.models;

public class Quest {

    private Integer id;
    private String title;
    private String description;
    private Integer bitsReward;

    public Quest(String title, String description, Integer bitsReward) {
        this.title = title;
        this.description = description;
        this.bitsReward = bitsReward;
    }


    public Quest(Integer id, String title, String description, Integer bitsReward) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.bitsReward = bitsReward;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getBitsReward() {
        return bitsReward;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", bitsReward=" + bitsReward +
                '}';
    }
}
