package battleofwizards;

import java.util.Random;

public class Wizards {
    // Atributos
    private String name; // O nome do bruxo
    private String spell; // O nome do feitiço
    private int dano; // Dano do feitiço
    private int xp; // Aumenta o dano do feitiço. Para cada 1 XP, 0.5 a 1 de dano adicional
    private String defensiveSpell; // Nome do feitiço defensivo
    private int defesa; // Defesa do feitiço
    private int cloak; // Vida de um bruxo

    private Random random = new Random();

    // Métodos Especiais
    // Construtor
    public Wizards(String name, String spell, int xp, String defensiveSpell, int cloak) {
        this.name = name;
        this.spell = spell;
        this.xp = xp;
        this.defensiveSpell = defensiveSpell;
        this.cloak = cloak;
    }

    // Getter e Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpell() {
        return spell;
    }

    public void setSpell(String spell) {
        this.spell = spell;
    }

    public int getDano() {
        return dano;
    }

    private void setDano() {
        if ("Expelliarmus".equals(this.getSpell())) {
            this.dano = random.nextInt(5) + 1; // Gera um dano de 1 a 5
        } else {
            this.dano = 1;
        }
        double bonusXP = this.xp * (0.5 + (random.nextDouble() * 0.5));
        this.dano += (int) Math.round(bonusXP);

    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getDefensiveSpell() {
        return defensiveSpell;
    }

    public void setDefensiveSpell(String defensiveSpell) {
        this.defensiveSpell = defensiveSpell;
    }

    public int getDefesa() {
        return defesa;
    }

    private void setDefesa() {
        if ("Protego".equals(this.getDefensiveSpell())) {
            this.defesa = random.nextInt(5) + 1;
        } else {
            this.defesa = 1;
        }
    }

    public int getCloak() {
        return cloak;
    }

    public void setCloak(int cloak) {
        this.cloak = cloak;
    }

    // Métodos Comuns
    public void castOffensiveSpell() {
        this.setDano();
        System.out.println(this.name + " casts " + this.spell + " inflicting " + this.dano + " of damage.");
    }

    public void castDefensiveSpell() {
        this.setDefesa();
        System.out.println(this.name + " casts " + this.defensiveSpell + " protecting himself.");
    }

    public void danoRecebido(int danoOponente) {
        // Calcula o dano real subtraindo a defesa
        int danoReal = danoOponente - this.defesa;

        // Se a defesa for maior que o dano, o dano real deve ser 0
        if (danoReal < 0) {
            danoReal = 0;
        }

        this.cloak -= danoReal;

        // Impede que o HP fique abaixo de zero
        if (this.cloak < 0) {
            this.cloak = 0;
        }

        System.out.println(this.name + " absorbed " + this.defesa + " damage and lost " + danoReal + " (Remaining HP: "
                + this.cloak + ")");
    }

    public void bow() {
        System.out.println(this.name + " bows before the duel.");
    }
}
