abstract class RescueTeam{
    private String teamName;

    RescueTeam(String teamName){
        this.teamName = teamName;
    }
    public String getTeamName(){
        return teamName;
    }
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    abstract void rescueOperation();
}
class BoatRescueTeam extends RescueTeam{

    BoatRescueTeam(String teamName){
        super(teamName);
    }

    @Override
    void rescueOperation(){
        System.out.println(getTeamName() + " is rescuing victims using boats.");
    }

    void sendAlert(){
        System.out.println("Alert: Boat team is ready for rescue!");
    }
}
class FloodEmergency{
    private double waterLevel;
    private int totalVictims = 0;

    FloodEmergency(double waterLevel){
        this.waterLevel = waterLevel;
    }
    public double getWaterLevel(){
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel){
        this.waterLevel = waterLevel;
    }

    public int getTotalVictims(){
        return totalVictims;
    }

    public void setTotalVictims(int totalVictims){
        this.totalVictims = totalVictims;
    }

    void addVictim(){
        totalVictims++;
    }

    void showWaterLevel(){
        System.out.println("Water Level: " + getWaterLevel() + " feet");
    }

    void checkDangerZone(){
        if (getWaterLevel() > 10){
            System.out.println("Danger Zone! Immediate rescue required.");
        } else {
            System.out.println("Safe Zone");
        }
    }

    void showTotalPeople(){
        System.out.println("Total People: " + getTotalVictims());
    }

    void calculateBoats(){
        int boats = getTotalVictims() / 4;

        if (getTotalVictims() % 4 != 0){
            boats++;
        }

        System.out.println("Boats Required: " + boats);
    }

    void assignShelter(){
        System.out.println("Shelter Assigned: DIU Shelter Camp");
    }

    void showFullReport(BoatRescueTeam team){

        showWaterLevel();
        checkDangerZone();
        showTotalPeople();
        calculateBoats();

        team.sendAlert();

        assignShelter();
        team.rescueOperation();
    }
}
public class Main{
    public static void main(String[] args){

        FloodEmergency flood = new FloodEmergency(12.5);
        BoatRescueTeam boatTeam = new BoatRescueTeam("Boat Rescue Team");

        flood.addVictim();
        flood.addVictim();
        flood.addVictim();
        flood.addVictim();
        flood.addVictim();

        flood.showFullReport(boatTeam);
    }
}
