package Publications;

class Article extends Publication {

    private String author;

    public Article(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getType() {
        return "Article";
    }

    public String getDetails() {
        return " (author - " + this.author + "): ";
    }

}
