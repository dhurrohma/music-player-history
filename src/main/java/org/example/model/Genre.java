package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Genre {
    private Integer id;
    private String genreName;

    public Genre() {

    }
}
