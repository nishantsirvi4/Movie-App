package org.example;

import com.google.gson.Gson;
import org.example.movielist.Movie;
import org.example.movielist.MovieHandler;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        MovieHandler movieHandler = new MovieHandler();
        displayHomePage(movieHandler);
    }


    private static void displayHomePage(MovieHandler movieHandler) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- Movie List Application ----");
            System.out.println("1. Show all Movies");
            System.out.println("2. Add a New Movie");
            System.out.println("3. Filter Movies");
            System.out.println("4. Search for a Movie");
            System.out.println("5. Update a Movie's Details");
            System.out.println("6. Delete a Movie");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    movieHandler.displayAllMovies();
                    break;
                case 2:
                    addNewMovie(movieHandler);
                    break;
                case 3:
                    filterMovies(movieHandler);
                    break;
                case 4:
                    searchMovies(movieHandler);
                    break;
                case 5:
                    updateMovieDetails(movieHandler);
                    break;
                case 6:
                    deleteMovie(movieHandler);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addNewMovie(MovieHandler movieHandler) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Adding a New Movie. Please provide below details ----");
        System.out.print("Enter Movie Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Director: ");
        String director = scanner.nextLine();
        System.out.print("Enter Release Year: ");
        int releaseYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Language: ");
        String language = scanner.nextLine();
        System.out.print("Enter Rating: ");
        double rating = scanner.nextDouble();
        System.out.print("Enter Rating Type: ");
        scanner.nextLine();
        String ratingType = scanner.nextLine();
        System.out.print("Enter genres (comma-separated if multiple genres): ");
        String[] genres = scanner.nextLine().split(",");
        Movie newMovie = new Movie();
        newMovie.setId(movieHandler.getMoviesDataSize()+1);
        newMovie.setTitle(name);
        newMovie.setDirectorName(director);
        newMovie.setLanguage(language);
        newMovie.setGenres(genres);
        newMovie.setReleaseYear(releaseYear);
        newMovie.setRating(rating);
        newMovie.setRatingType(ratingType);
        movieHandler.addMovie(newMovie);
        System.out.println("Movie added successfully!");
    }

    private static void updateMovieDetails(MovieHandler movieHandler) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Update a Movie's Details ----");
        System.out.print("Enter the id of the movie to update: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        movieHandler.updateMovie(movieId);
    }

    private static void deleteMovie(MovieHandler movieHandler) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Delete a Movie ----");
        System.out.print("Enter the id of the movie to delete: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        movieHandler.deleteMovie(movieId);
    }

    private static void filterMovies(MovieHandler movieHandler) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> filteredMovieList = null;
        int filterChoice;
        do {
            System.out.println("---- Filter Movies ----");
            System.out.println("1. Filter by Name");
            System.out.println("2. Filter by Director");
            System.out.println("3. Filter by Release Year");
            System.out.println("4. Filter by Language");
            System.out.println("5. Filter by Rating");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            filterChoice = scanner.nextInt();
            scanner.nextLine();
            switch (filterChoice) {
                case 1:
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    filteredMovieList = movieHandler.searchMovieByTitle(title);
                    break;
                case 2:
                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    filteredMovieList = movieHandler.searchMovieByDirector(director);
                    break;
                case 3:
                    System.out.print("Enter Release Year: ");
                    int releaseYear = scanner.nextInt();
                    scanner.nextLine();
                    filteredMovieList = movieHandler.searchMovieByReleaseYear(releaseYear);
                    break;
                case 4:
                    System.out.print("Enter Language: ");
                    String language = scanner.nextLine();
                    filteredMovieList = movieHandler.searchMovieByLanguage(language);
                    break;
                case 5:
                    System.out.print("Enter Minimum Rating: ");
                    double minRating = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Maximum Rating: ");
                    double maxRating = scanner.nextDouble();
                    scanner.nextLine();
                    filteredMovieList = movieHandler.searchMovieByRating(minRating, maxRating);
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    displayHomePage(movieHandler);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            if (filterChoice >=1 && filterChoice <= 5 && filteredMovieList != null) {
                displayMovieList(filteredMovieList);
            } else {
                System.out.println("No Movie found with above filters");
            }
        } while (filterChoice != 0);

    }

    private static void searchMovies(MovieHandler movieHandler){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---- Search Movie ----");
        System.out.print("Enter Movie id: ");
        int movieId = scanner.nextInt();
        scanner.nextLine();
        Movie resultMovie = movieHandler.searchMovieById(movieId);
        if (resultMovie != null) {
            System.out.println(resultMovie);
        } else {
            System.out.println("No movie found with Id: " + movieId);
        }

    }

    private static void displayMovieList(List<Movie> movieList){
        for (Movie movie : movieList) {
            System.out.println(movie.toString());
        }
    }
}