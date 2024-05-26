package org.example.movielist;

import java.util.*;

public class MovieHandler {

    public static final String DATA_FILE_PATH = "src/main/resources/movie_data/Movies.json";

    public void addMovie(Movie newMovie) {
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        movieList.add(newMovie);
        MovieUtils.saveMovie(DATA_FILE_PATH, movieList);
        System.out.println("Added to the list : " + newMovie);
    }

    public void updateMovie(int movieId) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        Movie movieToUpdate = searchMovieById(movieId);

        if (movieId >= 1 && movieToUpdate != null) {
            int movieToUpdateIndex = -1;
            for (int i = 0; i < movieList.size(); i++) {
                if (movieToUpdate.getId() == movieList.get(i).getId()){
                    movieToUpdateIndex = i;
                    movieToUpdate = movieList.get(i);
                    break;
                }
            }
            System.out.print("Enter updated Movie Name (leave blank to keep current): ");
            String name = scanner.nextLine();
            if (!name.isEmpty()) {
                movieToUpdate.setTitle(name);
            }
            System.out.print("Enter updated Director (leave blank to keep current): ");
            String director = scanner.nextLine();
            if (!director.isEmpty()) {
                movieToUpdate.setDirectorName(director);
            }
            System.out.print("Enter updated Release Year (leave 0 to keep current): ");
            int releaseYear = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            if (releaseYear != 0) {
                movieToUpdate.setReleaseYear(releaseYear);
            }
            System.out.print("Enter updated Language (leave blank to keep current): ");
            String language = scanner.nextLine();
            if (!language.isEmpty()) {
                movieToUpdate.setLanguage(language);
            }
            System.out.print("Enter updated Rating Type (leave blank to keep current): ");
            String ratingType = scanner.nextLine();
            if (!ratingType.isEmpty()) {
                movieToUpdate.setLanguage(ratingType);
            }
            System.out.print("Enter updated Rating (leave 0.0 to keep current): ");
            double rating = scanner.nextDouble();
            scanner.nextLine();
            if (rating != 0.0) {
                movieToUpdate.setRating(rating);
            }
            System.out.print("Enter comma-separated updated Genres (leave blank to keep current): ");
            String genre = scanner.nextLine();
            if (!genre.trim().isEmpty()) {
                System.out.println("Updating the genres set");
                String[] genresList = genre.split(",");
                movieToUpdate.setGenres(genresList);
            }
            MovieUtils.saveMovie(DATA_FILE_PATH, movieList);
            System.out.println("Movie details updated successfully!");
        } else {
            System.out.println("Invalid index. No movie found for movieId: " + movieId);
        }

    }

    public void displayAllMovies() {
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
        }
    }

    public int getMoviesDataSize(){
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        return movieList.get(movieList.size()-1).getId();
    }

    public void deleteMovie(int movieId) {
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        int indexToDelete = -1;
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getId() == movieId) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete != -1) {
            movieList.remove(indexToDelete);
            MovieUtils.saveMovie(DATA_FILE_PATH, movieList);
            System.out.println("Movie deleted successfully!!");
        } else {
            System.out.println("No movie found with Id: " + movieId);
        }
    }

    public Movie searchMovieById(int movieId){
        Movie movieResult = null;
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getId() == movieId){
                movieResult = movie;
            }
        }
        return movieResult;
    }

    public List<Movie> searchMovieByTitle(String title) {
        List<Movie> movieResult = new ArrayList<>();
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getTitle().equalsIgnoreCase(title)){
                movieResult.add(movie);
            }
        }
        return movieResult;
    }

    public List<Movie> searchMovieByDirector(String director) {
        List<Movie> movieResult = new ArrayList<>();
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getDirectorName().equalsIgnoreCase(director)){
                movieResult.add(movie);
            }
        }
        return movieResult;
    }

    public List<Movie> searchMovieByReleaseYear(int releaseYear) {
        List<Movie> movieResult = new ArrayList<>();
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getReleaseYear() == releaseYear){
                movieResult.add(movie);
            }
        }
        return movieResult;
    }

    public List<Movie> searchMovieByLanguage(String language) {
        List<Movie> movieResult = new ArrayList<>();
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getLanguage().equalsIgnoreCase(language)){
                movieResult.add(movie);
            }
        }
        return movieResult;
    }

    public List<Movie> searchMovieByRating(double minRating, double maxRating) {
        List<Movie> movieResult = new ArrayList<>();
        List<Movie> movieList = MovieUtils.readMovies(DATA_FILE_PATH);
        for (Movie movie : movieList) {
            if (movie.getRating() >= minRating && movie.getRating() <= maxRating){
                movieResult.add(movie);
            }
        }
        return movieResult;
    }

}
