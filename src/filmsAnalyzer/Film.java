package filmsAnalyzer;

import java.util.List;
import java.util.Map;

public class Film {
    private double budget;
    private Map<Long,String> genres;
    private Map<Long,String> keywords;
    private String original_language;
    private String original_title;
    private float popularity;
    private Map<Long,String> production_companies;
    private String release_date;
    private double revenue;
    private String status;
    private float vote_average;
    private double vote_count;

    public Film(double budget, Map<Long,String> genres, Map<Long,String> keywords, String original_language, String original_title, float popularity, Map<Long,String> production_companies, String release_date, double revenue, String status, float vote_average, double vote_count) {
        this.budget = budget;
        this.genres = genres;
        this.keywords = keywords;
        this.original_language = original_language;
        this.original_title = original_title;
        this.popularity = popularity;
        this.production_companies = production_companies;
        this.release_date = release_date;
        this.revenue = revenue;
        this.status = status;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public Map<Long,String> getGenres() {
        return genres;
    }

    public void setGenres(Map<Long,String> genres) {
        this.genres = genres;
    }

    public Map<Long,String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Map<Long,String> keywords) {
        this.keywords = keywords;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public Map<Long,String> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(Map<Long,String> production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public double getVote_count() {
        return vote_count;
    }

    public void setVote_count(double vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "Film{" +
                "budget='" + budget + '\'' +
                ", genres='" + genres + '\'' +
                ", keywords='" + keywords + '\'' +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", popularity='" + popularity + '\'' +
                ", production_companies='" + production_companies + '\'' +
                ", release_date='" + release_date + '\'' +
                ", revenue='" + revenue + '\'' +
                ", status='" + status + '\'' +
                ", vote_average='" + vote_average + '\'' +
                ", vote_count='" + vote_count + '\'' +
                '}';
    }
}
