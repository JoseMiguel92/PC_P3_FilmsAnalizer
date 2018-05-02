package filmsAnalyzer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilmsAnalyzer {
    private List<Film> films;

    private static final String SEPARATOR = ";";
    private static final int COL_NUMBER = 12;

    public FilmsAnalyzer(String filename) throws IOException {
        JSONParser parser = new JSONParser();
        films = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            films = bf.lines()
                    .skip(1)
                    .map(line -> line.split(SEPARATOR))
                    .filter(line -> line.length == COL_NUMBER)
                    .map(col -> {
                        Film film = new Film(
                                Double.parseDouble(col[0]),
                                getListMap(col[1],parser),
                                getListMap(col[2],parser),
                                col[3],
                                col[4],
                                Float.parseFloat(col[5]),
                                getListMap(col[6],parser),
                                col[7],
                                Double.parseDouble(col[8]),
                                col[9],
                                Float.parseFloat(col[10]),
                                Double.parseDouble(col[11]));
                        return film;
                    })
                    .collect(Collectors.toList());
        }
    }

    public Map<Long,String> getListMap(String json, JSONParser parser){
        String jsonReplaced = json.replaceAll("\"\"","\"");
        String jsonString = jsonReplaced.substring(1, jsonReplaced.length()-1);
        Map<Long,String> tempMap = null;
        try {
            JSONArray array = (JSONArray) parser.parse(jsonString);
            tempMap = new HashMap<>();
            for (Object o : array) {
                JSONObject jsonObject = (JSONObject) o;
                tempMap.put((Long) jsonObject.get("id"), (String) jsonObject.get("name"));
            }
        }catch(ParseException e){
        }
        return tempMap;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public void printFilms() {
        this.films.forEach(System.out::println);
    }

    public void maxMin(double min,double max) {
        this.films.parallelStream()
                .filter(film -> !(film.getBudget() > max) && !(film.getBudget() < min))
                .map(film -> film.getOriginal_title())
                .forEach(System.out::println);
    }

    public void getMaxRevenueFromKey(long key) {
        System.out.println(key);
        this.films.stream()
               .map(film -> film.getGenres())
                .forEach(System.out::println);
//        this.films.parallelStream()
//                .filter(film -> film.getGenres().containsKey(key))
//                .map(film -> film.getRevenue())
//                .reduce(Math::max)
//                .ifPresent(System.out::println);
    }

//    public void filmsWithGenres(Map<Long,String> genres) {
//        this.films.parallelStream()
//                .filter(film -> film.getGenres().forEach())
//    }
}