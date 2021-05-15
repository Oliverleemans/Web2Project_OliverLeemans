package Domain.model;

public class Garage {
    private String automerk, model;
    private String nummerplaat;
    private int rating;

    public Garage(String automerk, String model, String nummerplaat, int rating) {
        setAutomerk(automerk);
        setModel(model);
        setNummerplaat(nummerplaat);
        setRating(rating);
    }

    public Garage(){}

    public static boolean isValidString(String input) {
        return (input != null) && !(input.trim().isEmpty());
    }

    public String getAutomerk() {
        return automerk;
    }

    public void setAutomerk(String automerk) {
        if (isValidString(automerk))
            this.automerk = automerk;
        else throw new IllegalArgumentException("No valid automerk");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (isValidString(model))
            this.model = model;
        else throw new IllegalArgumentException("No valid model");
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
       if(nummerplaat.trim().isEmpty()) throw new IllegalArgumentException("No valid nummerplaat");
       this.nummerplaat = nummerplaat;
    }

    public int getRating() {
        return rating;
    }

    public static boolean isValidRating(int rating) {
        return rating > 0;
    }

    public void setRating(int rating) {
        if (isValidRating(rating))
            this.rating = rating;
        else throw new IllegalArgumentException("No valid Rating");
    }
}
