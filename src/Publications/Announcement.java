package Publications;

class Announcement extends Publication {

    private int daysToExpire;

    public Announcement(String title, int daysToExpire) {
        super(title);
        this.daysToExpire = daysToExpire;
    }

    public String getType() {
        return "Announcement";
    }

    public String getDetails() {
        return " (days to expire - " + daysToExpire + "): ";
    }

}
