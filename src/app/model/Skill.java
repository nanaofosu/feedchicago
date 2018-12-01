package app.model;

public class Skill {
    private String name;
    private String desccription;

    public Skill(String name, String desccription) {
        this.name = name;
        this.desccription = desccription;
    }

    public Skill() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesccription() {
        return desccription;
    }

    public void setDesccription(String desccription) {
        this.desccription = desccription;
    }
}
