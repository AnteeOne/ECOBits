package tech.anteeone.ecobits.models;

public class Quest {

    private String title;
    private String description;
    private Integer bitsReward;

    public Quest(String title, String description, Integer bitsReward) {
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
}
