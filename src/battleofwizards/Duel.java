package battleofwizards;

import java.util.Random;

public class Duel {
    // Atributos
    private Wizards duelistOne;
    private Wizards duelistTwo;
    private Wizards winner;
    private int rounds;
    private int start;

    private Random random = new Random();

    // Métodos Especiais
    // Construtor
    public Duel() {

    }

    // Getter e Setter
    public Wizards getDuelistOne() {
        return duelistOne;
    }

    public void setDuelistOne(Wizards duelistOne) {
        this.duelistOne = duelistOne;
    }

    public Wizards getDuelistTwo() {
        return duelistTwo;
    }

    public void setDuelistTwo(Wizards duelistTwo) {
        this.duelistTwo = duelistTwo;
    }

    public Wizards getWinner() {
        return winner;
    }

    public void setWinner(Wizards winner) {
        this.winner = winner;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public int getStart() {
        return start;
    }

    public void setStart() {
        this.start = random.nextInt(2) + 1; // Apenas sorteia 1 ou 2
    }

    // Métodos Públicos
    public void duel() {
        duelistOne.bow();
        duelistTwo.bow();
        setStart();
        System.out.println("\n-----Start of the Duel-----\n");
        do {
            this.rounds++;

            if (this.start == 1) {
                duelistOne.castOffensiveSpell();
                duelistTwo.castDefensiveSpell();
                duelistTwo.danoRecebido(duelistOne.getDano());

                if (duelistTwo.getCloak() <= 0)
                    break;

                duelistTwo.castOffensiveSpell();
                duelistOne.castDefensiveSpell();
                duelistOne.danoRecebido(duelistTwo.getDano());

            } else {
                duelistTwo.castOffensiveSpell();
                duelistOne.castDefensiveSpell();
                duelistOne.danoRecebido(duelistTwo.getDano());

                if (duelistOne.getCloak() <= 0)
                    break;

                duelistOne.castOffensiveSpell();
                duelistTwo.castDefensiveSpell();
                duelistTwo.danoRecebido(duelistOne.getDano());

            }
            System.out.println("----End of Round: " + this.rounds + "------\n");
        } while (duelistOne.getCloak() > 0 && duelistTwo.getCloak() > 0);

        // Define o atributo winner
        this.winner = (duelistOne.getCloak() > 0) ? duelistOne : duelistTwo;

        System.out.println("\nThe winner is: " + this.winner.getName() + " after " + this.rounds + " rounds!");
    }
}
