package Controller;

import Domain.model.Garage;
import Domain.model.GarageDatabase;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet("/GeneralController")
public class Servlet extends HttpServlet {
    private GarageDatabase database;
    private ArrayList<Garage> garages;
    private String commando;
    private String destination;


    @Override
    public void init() throws ServletException {
        this.database = new GarageDatabase();
        this.garages = this.database.getAlle();
        this.destination = "overzicht.jsp";
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameterMap().containsKey("Commando")) {
            this.commando = request.getParameter("Commando");
            switch (this.commando) {
                // Acties
                case "searchGarage":
                    ArrayList<Garage> newGarages = this.searchGarage(request.getParameter("automerk"));
                    request.setAttribute("garages", newGarages);
                    this.destination = "overzicht.jsp";
                    break;

                case "removeGarage":
                    this.destination = this.removeGarage(request, response);
                    break;

                case "addGarage":
                    this.destination = this.add(request, response);
                    break;

                case "editGarage":
                    this.destination = this.editGarage(request, response);
                    break;
                // Pages
                case "editPage":
                    this.destination = this.editPage(request, response);
                    break;

                case "bevestiging":
                    destination = bevesteging(request, response);
                    break;

                case "home":
                    destination = home(request, response);
                    break;

                case "overzicht":
                    destination = overzicht(request, response);
                    break;

                case "search":
                    destination = search(request, response);
                    break;

                case "tweede":
                    destination = tweede(request, response);
                    break;

                case "add":
                    destination = add(request, response);
            }

        }
        if (request.getAttribute("garages") == null) {
            request.setAttribute("garages", this.garages);
        }
        request.getRequestDispatcher(this.destination).forward(request, response);
    }

    // Paginas
    private String home(HttpServletRequest request, HttpServletResponse response) {
        Garage HighestRatedCar = database.getHighestRatedCar();
        request.setAttribute("HighestRated", HighestRatedCar);
        Cookie visitCount = getCookie(request, "visitCount");
        if (visitCount == null) {
            visitCount = new Cookie("visitCount", "1");
        } else {
            int counter = Integer.parseInt(visitCount.getValue()) + 1;
            visitCount.setValue(Integer.toString(counter));
        }
        response.addCookie(visitCount);
        request.setAttribute("visitCount", visitCount.getValue());
        return "index.jsp";
    }

    private String overzicht(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("garages", this.database.getAlle());
        return "overzicht.jsp";
    }

    private String tweede(HttpServletRequest request, HttpServletResponse response) {
        return "tweede.jsp";
    }

    private String search(HttpServletRequest request, HttpServletResponse response) {
        return "search.jsp";
    }

    private String editPage(HttpServletRequest request, HttpServletResponse response) {
        Garage oldGarage = this.database.findNummerplaat(request.getParameter("oldNummerplaat"));
        request.setAttribute("garage", oldGarage);
        request.setAttribute("nummerplaat", request.getParameter("oldNummerplaat"));
        return "editedTweede.jsp";
    }

    private String bevesteging(HttpServletRequest request, HttpServletResponse response) {
        String nummerplaat = request.getParameter("nummerplaat");
        request.setAttribute("nummerplaat", nummerplaat);
        return "bevestiging.jsp";
    }

    // Acties
    private String add(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<String>();
        Garage garage = new Garage();
        setAutomerk(garage, request, errors);
        setModel(garage, request, errors);
        setNummerplaat(garage, request, errors);
        setRating(garage, request, errors);

        if (errors.size() == 0) {
            try {
                database.voegToe(garage);
                return overzicht(request, response);
            } catch (IllegalArgumentException exception) {
                request.setAttribute("error", exception.getMessage());
                return "tweede.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "tweede.jsp";
        }
    }

    private String removeGarage(HttpServletRequest request, HttpServletResponse response) {
        Garage garage = this.database.findNummerplaat(request.getParameter("nummerplaat").trim());
        this.database.removeGarage(garage.getAutomerk());

        return this.overzicht(request, response);
    }

    private String editGarage(HttpServletRequest request, HttpServletResponse response) {

        ArrayList<String> errors = new ArrayList<>();
        Garage garage = new Garage();
        setAutomerk(garage, request, errors);
        setModel(garage, request, errors);
        setNummerplaat(garage, request, errors);
        setRating(garage, request, errors);

        if (errors.size() == 0) {
            try {
                database.editGarage(garage, request.getParameter("oldNummerplaat"));
                return this.overzicht(request, response);

            } catch (IllegalArgumentException exception) {
                errors.add(exception.getMessage());
                return this.editPage(request, response);
            }
        } else {
            request.setAttribute("errors", errors);
            return this.editPage(request, response);
        }
    }

    // Help methodes
    private void setNummerplaat(Garage garage, HttpServletRequest request, ArrayList<String> errors) {
        String nummerplaat = request.getParameter("nummerplaat");
        try {
            garage.setNummerplaat(nummerplaat);
            request.setAttribute("nummerplaatClass", "has-succes");
            request.setAttribute("nummerplaatPreviousValue", nummerplaat);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
            request.setAttribute("nummerplaatClass", "has-error");
        }
    }

    private void setRating(Garage garage, HttpServletRequest request, ArrayList<String> errors) {
        int rating;
        if (request.getParameter("rating").trim().isEmpty()) {
            rating = 0;
        } else {
            rating = Integer.parseInt(request.getParameter("rating"));
        }
        try {
            garage.setRating(rating);
            request.setAttribute("ratingClass", "has-succes");
            request.setAttribute("ratingPreviousValue", rating);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
            request.setAttribute("ratingClass", "has-error");
        }
    }

    private void setModel(Garage garage, HttpServletRequest request, ArrayList<String> errors) {
        String model = request.getParameter("model");
        try {
            garage.setModel(model);
            request.setAttribute("modelClass", "has-succes");
            request.setAttribute("modelPreviousValue", model);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
            request.setAttribute("modelClass", "has-error");
        }
    }

    private void setAutomerk(Garage garage, HttpServletRequest request, ArrayList<String> errors) {
        String automerk = request.getParameter("merk");
        try {
            garage.setAutomerk(automerk);
            request.setAttribute("automerkClass", "has-succes");
            request.setAttribute("automerkPreviousValue", automerk);
        } catch (IllegalArgumentException exception) {
            errors.add(exception.getMessage());
            request.setAttribute("automerkClass", "has-error");
        }
    }
    private ArrayList<Garage> searchGarage(String automerk) {
        return (this.database.searchGarages(automerk));
    }

    public Cookie getCookie(HttpServletRequest request, String cookie) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) return null;
        for (Cookie c : cookies) {
            if (c.getName().equals(cookie)) {
                return c;
            }
        }
        return null;
    }
}
