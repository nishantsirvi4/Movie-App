package org.example.movielist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.List;

public class MovieUtils {


    public static List<Movie> readMovies(String path) {
        JsonReader reader = null;
        try {
            reader = new JsonReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        return gson.fromJson(reader, new TypeToken<List<Movie>>(){}.getType());
    }

    public static void saveMovie(String jsonFilePath, List<Movie> movieList) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            Writer writer = new FileWriter(jsonFilePath);
            gson.toJson(movieList, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
