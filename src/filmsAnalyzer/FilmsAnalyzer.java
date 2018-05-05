package filmsAnalyzer;

import com.sun.deploy.util.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class FilmsAnalyzer {
    private List<Film> films;

    private static final String SEPARATOR = ";";
    private static final int COL_NUMBER = 12;

    public FilmsAnalyzer(String filename) throws IOException {
        JSONParser parser = new JSONParser();
        films = new ArrayList<>();
        //return null
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            films = bf.lines()
                    .skip(1)
                    .map(line -> line.split(SEPARATOR))
                    .filter(line -> line.length == COL_NUMBER)
                    .map(col -> {
                        Film film = null;
                        try {
                            film = new Film(
                                    Long.parseLong(col[0]),
                                    getSet(col[1]),
                                    getSet(col[2]),
                                    col[3],
                                    col[4],
                                    Float.parseFloat(col[5]),
                                    getSet(col[6]),
                                    col[7],
                                    Long.parseLong(col[8]),
                                    col[9],
                                    Float.parseFloat(col[10]),
                                    Integer.parseInt(col[11]));
                        } catch (ParseException e) {
                            return null;
                        }
                        return film;
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
    }

    public Set<String> getSet(String json) throws ParseException {
        String jsonReplaced = json.replaceAll("\"\"", "\"");
        String jsonSubString = jsonReplaced.substring(1, jsonReplaced.length() - 1);
        Set<String> setJson = new HashSet<>();
        JSONParser parser = new JSONParser();
        if(!jsonSubString.equals("[]") || !jsonSubString.equals("")){
            JSONArray array = (JSONArray) parser.parse(jsonSubString);
            for (Object o : array) {
                JSONObject jsonObject = (JSONObject) o;
                setJson.add((String) jsonObject.get("name"));
            }
        }
        return setJson;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    //Ej1
    public void printFilms() {
        this.films.forEach(System.out::println);
    }

    //Ej2
    public void maxMin(double min, double max) {
        this.films.parallelStream()
                .filter(film -> !(film.getBudget() > max))
                .filter(film -> !(film.getBudget() < min))
                .map(film -> film.getOriginal_title())
                .forEach(System.out::println);
    }

    //Ej3
    public void filmsWithGenres(Set<String> genres) {
        this.films.parallelStream()
                .filter(film -> !Collections.disjoint(film.getGenres(), genres))
                .forEach(film -> System.out.println(film.getOriginal_title() + " : " + film.getGenres()));
    }

    //Ej4
    public void getMaxRevenueFromKeyword(String keyword) {
        this.films.parallelStream()
                .filter(film -> film.getKeywords().contains(keyword))
                .map(film -> film.getRevenue())
                .reduce(Math::max)
                .ifPresent(System.out::println);
    }

    //Ej5
    public List<Film> getListWithLanguagePopularity(String language, double popularity) {
        return this.films.parallelStream()
                .filter(film -> film.getOriginal_language().equalsIgnoreCase(language))
                .filter(film -> film.getPopularity() >= popularity)
                .collect(Collectors.toList());
    }

    //Ej6
    public long getYearRevenue(String year) {
        return this.films.parallelStream()
                .filter(film -> film.getRelease_date().contains(year))
                .map(film -> film.getRevenue())
//                .reduce(Long::sum).orElse(-1l);
                .reduce(0l, (x, y) -> x + y);
    }

    //Ej7
    public int getVotes(float voteMin, float voteMax) {
        return this.films.parallelStream()
                .filter(film -> !(film.getVote_average() > voteMax))
                .filter(film -> !(film.getVote_average() < voteMin))
                .map(film -> film.getVote_count())
                .reduce(0, (x, y) -> x + y);
    }

    //Ej8
    public Map<String, Set<String>> getProductionAndFilms(){
        return films.parallelStream()
                .flatMap(film-> film.getProduction_companies().stream()
                        .map(company -> new AbstractMap.SimpleEntry<>(company,film.getOriginal_title())))
                .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey,Collectors.mapping(AbstractMap.SimpleEntry::getValue,Collectors.toSet())));
    }

}