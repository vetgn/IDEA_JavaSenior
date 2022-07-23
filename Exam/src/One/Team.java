package One;

/**
 * @author ZJJ
 * #Description Team
 * #Date: 2022/5/31 10:08
 */
public class Team {
    private String name;
    private int numberofMember;
    private String introduction;

    public Team() {
    }

    public Team(String name, int numberofMember, String introduction) {
        this.name = name;
        this.numberofMember = numberofMember;
        this.introduction = introduction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberofMember() {
        return numberofMember;
    }

    public void setNumberofMember(int numberofMember) {
        this.numberofMember = numberofMember;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
}
