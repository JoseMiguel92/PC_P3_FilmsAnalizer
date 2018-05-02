package filmsAnalyzer;

import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ParseException {
        final String database = "resources/movies_db.csv";
        double min = 237000000;
        double max = 237000000;
        Map<Long,String> genres = new HashMap<>();
        long key = 28l;
        FilmsAnalyzer filmsAnalizer = null;

        // Ejercicio 1
        try {
            filmsAnalizer = new FilmsAnalyzer(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //filmsAnalizer.printFilms();

        // Ejercicio 2
        //filmsAnalizer.maxMin(min,max);

        //Ejercicio 3
        genres.put(28L,"Action");
        genres.put(12L,"Adventure");
        genres.put(14L,"Factasy");
        genres.put(878L,"Science Fiction");
        //filmsAnalizer.filmsWithGenres(genres);

        //Ejercicio 4
        filmsAnalizer.getMaxRevenueFromKey(key);

        //Ejercicio 5

        //Ejercicio 6

        //Ejercicio 7

        //Ejercicio 8

        System.out.println("Total peliculas: "+filmsAnalizer.getFilms().size());
    }
}
