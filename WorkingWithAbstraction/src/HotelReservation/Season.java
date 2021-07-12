package HotelReservation;

public enum Season {
    AUTUMN(),
    SPRING(),
    WINTER(),
    SUMMER();

    private int multiplier;
    Season (){
        this.multiplier = this.ordinal()+1;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
