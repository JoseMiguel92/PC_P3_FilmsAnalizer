package filmsAnalyzer;

import java.util.Set;

public class Film {
    private long budget;
    private Set<String> genres;
    private Set<String> keywords;
    private String original_language;
    private String original_title;
    private double popularity;
    private Set<String> production_companies;
    private String release_date;
    private long revenue;
    private String status;
    private float vote_average;
    private int vote_count;

    public Film(long budget, Set<String> genres, Set<String> keywords, String original_language, String original_title, float popularity, Set<String> production_companies, String release_date, long revenue, String status, float vote_average, int vote_count) {
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

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
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

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public Set<String> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(Set<String> production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
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

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
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
