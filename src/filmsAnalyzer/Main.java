package filmsAnalyzer;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        final String database = "resources/tiny.csv";
        FilmsAnalyzer filmsAnalizer = null;

        // Ejercicio 1
        try {
            filmsAnalizer = new FilmsAnalyzer(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //filmsAnalizer.printFilms();

        // Ejercicio 2
        //filmsAnalizer.maxMin(237000000,237000000);

        //Ejercicio 3
        //filmsAnalizer.filmsWithGenres(new HashSet<>(Arrays.asList("Action","Adventure")));

        //Ejercicio 4
        //filmsAnalizer.getMaxRevenueFromKeyword("culture clash");

        //Ejercicio 5
        //List<Film> ejercicio5 = filmsAnalizer.getListWithLanguagePopularity("es",0);

        //Ejercicio 6
        //long yearRevenue = filmsAnalizer.getYearRevenue("2009");

        //Ejercicio 7
//        int votes = filmsAnalizer.getVotes(1f,2f);
//        System.out.println(votes);

        //Ejercicio 8
        filmsAnalizer.getProductionAndFilms();

        System.out.println("Total peliculas: "+filmsAnalizer.getFilms().size());
    }
}
