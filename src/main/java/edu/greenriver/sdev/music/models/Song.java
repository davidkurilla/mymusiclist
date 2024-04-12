package edu.greenriver.sdev.music.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song {

    private String title;
    private String artist;
    private int year;
    private boolean isExplicit;
}
