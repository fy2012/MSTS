public class Unit {
    private int ID;
    private String carrier;
    private String tracking;
    private String name;
    private int number;
    private String condition;
    private String comment;

    public Unit(){

    }

    public Unit(int ID, String tracking, String name, int number, String condition, String comment){
        setID(ID);
        setCarrier(tracking);
        setTracking(tracking);
        setName(name);
        setNumber(number);
        setCondition(condition);
        setComment(comment);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCarrier(String tracking) {
        if(tracking.charAt(0) == '1' && tracking.charAt(1) == 'Z')
            this.carrier = "UPS";
        else
            this.carrier = "USPS";
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getID() {
        return ID;
    }

    public String getCarrier() {
        return carrier;
    }

    public String getTracking() {
        return tracking;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public String getCondition() {
        return condition;
    }

    public String getComment() {
        return comment;
    }
}
