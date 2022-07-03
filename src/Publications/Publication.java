package Publications;

class Publication {

    private String title;

    public Publication(String title) {
        this.title = title;
    }

    public final String getInfo() {
        return  this.getType() + this.getDetails() + title;
    }

    protected String getType() {
        return "Publication";
    }

    public String getDetails() {
        return ": ";
    }

}
