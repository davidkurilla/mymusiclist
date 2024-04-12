package edu.greenriver.sdev.music.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {

    private String title;
    private String author;
    private boolean isExplicit;
    private List<Song> songList;
}
