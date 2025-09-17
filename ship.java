public class ship {

    public String shipName;
    public String CaptName;

    public ship(String shipName, String CaptainName) {
        this.shipName = shipName;
        this.CaptName = CaptainName;
    }
    @Override
    public String toString() {
        return shipName + " | Capt. " + CaptName; 
    }
}
