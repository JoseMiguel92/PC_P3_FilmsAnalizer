package filmsAnalyzer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        films = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))) {
            films = bf.lines()
                    .skip(1)
                    .map(line -> line.split(SEPARATOR))
                    .filter(line -> line.length == COL_NUMBER)
                    .map(col -> {
                        Film film = new Film(
                                col[0],
                                getListMap(col[1]),
                                getListMap(col[2]),
                                col[3],
                                col[4],
                                Float.parseFloat(col[5]),
                                getListMap(col[6]),
                                col[7], col[8],
                                col[9],
                                Float.parseFloat(col[10]),
                                col[11]);
                        return film;
                    })
                    .collect(Collectors.toList());
        }
    }

    public List<Film> getFilms() {
        return films;
    }

    public void printFilms(List<Film> films) {
        films.parallelStream()
                .forEach(System.out::println);
    }

    public List<Map<Long,String>> getListMap(String json){
        String jsonReplaced = json.replaceAll("\"\"","\"");
        String jsonString = jsonReplaced.substring(1, jsonReplaced.length()-1);
        List<Map<Long,String>> tempList = null;
        try {
            JSONParser parser = new JSONParser();
            JSONArray arrayGenre = (JSONArray) parser.parse(jsonString);
            tempList = new ArrayList<>();
            for (Object o : arrayGenre) {
                Map<Long, String> item = new HashMap<>();
                JSONObject jsonObject = (JSONObject) o;
                item.put((Long) jsonObject.get("id"), (String) jsonObject.get("name"));
                tempList.add(item);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        return tempList;
    }
}