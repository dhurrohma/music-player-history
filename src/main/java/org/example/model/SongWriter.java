package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class SongWriter {
    private Integer id;
    private String name;

    public SongWriter() {
    }
}
