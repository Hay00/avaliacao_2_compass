package avaliacao2.questao10.model;

public class Emoticons {
    private int id;
    private String sentiment;

    public Emoticons(String sentiment) {
        this.sentiment = sentiment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }
}
