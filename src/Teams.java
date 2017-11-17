import java.util.ArrayList;

public class Teams {

    private String teamID;
    private String teamName;
    private String teamLeader;
    private ArrayList<User> users = new ArrayList<>();

    public Teams(String teamID, String teamName, String teamLeader){

        this.teamID = teamID;
        this.teamName=teamName;
        this.teamLeader=teamLeader;
        this.users=new ArrayList<>();

    }
    //Her laves get og set metoder for "teamid"
    public String getTeamID(){ return teamID; }
    public void setTeamID(){this.teamID=teamID;}

    // Her laves get og set metoder for "teamname"
    public String getTeamName(){return teamName;}
    public void setTeamName(){this.teamName=teamName;}

    // Her laves get og set metoder for "teamleader"
    public String getTeamLeader(){return teamLeader;}
    public void setTeamLeader(){this.teamLeader=teamLeader;}


}
