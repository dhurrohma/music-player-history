package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Setter @Getter
@ToString
public class History {
    private Integer id;
    private LocalDate datePlay;
    private Integer songId;

    public History() {
    }
}
