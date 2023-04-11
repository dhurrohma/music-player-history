package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Song {
    private Integer id;
    private String title;
    private Integer singerId;
    private Integer genreId;
    private Integer songWriterId;
    private String releaseYear;

    public Song() {
    }
}
