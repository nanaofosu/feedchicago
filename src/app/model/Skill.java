package app.model;

public class Skill {
    private String skillname;
    private String skillDescription;

    public Skill(String name, String desccription) {
        this.skillname = name;
        this.skillDescription = desccription;
    }

    public Skill(String setSkillname) {
    }

    public String getSkillname() {
        return skillname;
    }

    public void setSkillname(String skillname) {
        this.skillname = skillname;
    }

    public String getSkillDescription() {
        return skillDescription;
    }

    public void setSkillDescription(String skillDescription) {
        this.skillDescription = skillDescription;
    }
}
