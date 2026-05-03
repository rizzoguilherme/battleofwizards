package battleofwizards;

public class BattleOfWizards {

    public static void main(String[] args) {
        Wizards w[] = new Wizards[2];
        
        w[0] = new Wizards("Harry", "Expelliarmus", 5, "Protego", 50);
        w[1] = new Wizards("Draco", "Expelliarmus", 4, "Protego", 55);
        
        Duel duel = new Duel();
        
        duel.setDuelistOne(w[0]);
        duel.setDuelistTwo(w[1]);
        
        duel.duel();
    }
}