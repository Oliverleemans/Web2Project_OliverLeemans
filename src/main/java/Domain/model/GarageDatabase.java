package Domain.model;

import java.util.ArrayList;

public class GarageDatabase {
    private ArrayList<Garage> garages = new ArrayList<>();

    public GarageDatabase() {
        //this.voegToe(new Garage("Lamborghini", "Huracan EVO Spyder", "1-XRT-214", 8));
        Garage bmw = new Garage("BMW", "M4 GTS", "1-ERT-234", 8);
        Garage mercedes = new Garage("Mercedes", "C-63s", "1-kom-345", 9);
        Garage jaguar = new Garage("Jaguar", "F-Pace SVR", "1-DSP-737", 10);
        garages.add(bmw);
        garages.add(mercedes);
        garages.add(jaguar);
    }


    public void voegToe(Garage garage) {
        if (garage == null)
            throw new IllegalArgumentException("Voer een geldige auto in!");
        garages.add(garage);
    }

    public ArrayList<Garage> searchGarages(String automerk) {
        ArrayList<Garage> searchedgarages = new ArrayList<>();
        if (automerk == null || automerk.isEmpty())
            throw new IllegalArgumentException("automerk mag niet leeg zijn");
        for (Garage garage : garages) {
            if (garage.getAutomerk().equals(automerk))
                searchedgarages.add(garage);
        }
        return searchedgarages;
    }

    public void removeGarage(String merk) {
        garages.remove(findGarage(merk));
    }

    public Garage findGarage(String merk) {
        if (merk == null || merk.trim().isEmpty())
            throw new IllegalArgumentException("Voer een geldige naam in!");
        for (Garage garage : this.garages) {
            if (garage.getAutomerk().equals(merk))
                return garage;
        }
        return null;
    }

    public Garage findNummerplaat(String nummerplaat) {
        for (Garage g : garages) {
            if (g.getNummerplaat().equalsIgnoreCase(nummerplaat)) {
                return g;
            }
        }
        return null;
    }

    public ArrayList<Garage> getAlle() {
        return garages;
    }

    public void editGarage(Garage garage, String nummerplaat) {
        Garage oldGarage = this.findNummerplaat(nummerplaat);

        oldGarage.setAutomerk(garage.getAutomerk());
        oldGarage.setModel(garage.getModel());
        oldGarage.setNummerplaat(garage.getNummerplaat());
        oldGarage.setRating(garage.getRating());
    }

    public Garage getHighestRatedCar() {
        if (garages.size() == 0)
            return null;
        Garage HighestRated = garages.get(0);
        for (Garage garage : garages) {
            if (garage.getRating() > HighestRated.getRating())
                HighestRated = garage;
        }
        return HighestRated;
    }
}
