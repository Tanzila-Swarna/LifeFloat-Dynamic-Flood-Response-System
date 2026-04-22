import java.util.ArrayList;
abstract class RescueTeam{
    String teamName;

    RescueTeam(String teamName){
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
        System.out.println(teamName + " is rescuing victims using boats.");
    }
}
class Victim{
    private String name;
    private int priorityLevel;

    Victim(String name, int priorityLevel){
        this.name = name;
        setPriorityLevel(priorityLevel);
    }

    public String getName(){
        return name;
    }

    public int getPriorityLevel(){
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel){
        if (priorityLevel >= 1 && priorityLevel <= 5){
            this.priorityLevel = priorityLevel;
        } else {
            this.priorityLevel = 1;
        }
    }
}

class FloodEmergency{
    private double waterLevel;
    private String shelterName;
    private ArrayList<Victim> victims = new ArrayList<>();

    FloodEmergency(double waterLevel){
        this.waterLevel = waterLevel;
    }

    void addVictim(Victim v){
        victims.add(v);
    }

    void showTotalPeople(){
        System.out.println("Total People: " + victims.size());
    }

    void calculateBoats(){
        int people = victims.size();
        int boats = people / 4;

        if (people % 4 != 0){
            boats++;
        }
        System.out.println("Boats Required: " + boats);
    }

    void showWaterLevel(){
        System.out.println("Water Level: " + waterLevel + " feet");
    }

    void checkDangerZone(){
        if (waterLevel > 10){
            System.out.println("Danger Zone! Immediate rescue required.");
        } else {
            System.out.println("Safe Zone");
        }
    }

    void assignShelter(String shelterName){
        this.shelterName = shelterName;
        System.out.println("Shelter Assigned: " + shelterName);
    }
    void showFullReport(RescueTeam team){

        showWaterLevel();
        checkDangerZone();
        showTotalPeople();
        calculateBoats();
        assignShelter("DIU Shelter Camp");

        team.rescueOperation();
    }
}
public class Main{
    public static void main(String[] args){

        FloodEmergency flood = new FloodEmergency(12.5);
        RescueTeam boatTeam = new BoatRescueTeam("Boat Rescue Team");

            Victim v1 = new Victim("A", 5);
            Victim v2 = new Victim("B", 3);
            Victim v3 = new Victim("C", 4);
            Victim v4 = new Victim("D", 2);
            Victim v5 = new Victim("E", 1);
            
            flood.addVictim(v1);
            flood.addVictim(v2);
            flood.addVictim(v3);
            flood.addVictim(v4);
            flood.addVictim(v5);

        flood.showFullReport(boatTeam);
    }
}
