package bg.softuni.battleships.models.dtos;

public class ShipAttackDto {
    private long attacker;
    private long defender;

    public long getAttacker() {
        return attacker;
    }

    public void setAttacker(long attacker) {
        this.attacker = attacker;
    }

    public long getDefender() {
        return defender;
    }

    public void setDefender(long defender) {
        this.defender = defender;
    }
}
