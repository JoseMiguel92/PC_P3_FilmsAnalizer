package filmsAnalyzer;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParseException {
        final String database = "resources/movies_db.csv";
        FilmsAnalyzer filmsAnalizer = null;
        try {
            filmsAnalizer = new FilmsAnalyzer(database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filmsAnalizer.printFilms(filmsAnalizer.getFilms());
        System.out.println(filmsAnalizer.getFilms().size());
    }
}
