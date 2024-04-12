package edu.greenriver.sdev.music.services;

import edu.greenriver.sdev.music.models.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a service that allows for CRUD operations on Songs.
 * @author David Kurilla
 * @version 1.0
 */
@Service
public class SongService {

    private final List<Song> songList;

    /**
     * This constructor creates an instance of the SongService and preloads data.
     */
    public SongService() {
        songList = new ArrayList<>();
        loadSongs();
    }

    private void loadSongs() {
        songList.add(new Song("Get Got", "Death Grips", 2012, true));
        songList.add(new Song("Be Nice 2 Me", "Bladee", 2018, true));
        songList.add(new Song("flutter", "julie", 2020, false));
        songList.add(new Song("Be Quiet and Drive (Far Away)", "Deftones", 1997, false));
        songList.add(new Song("Little League", "Cap'n Jazz", 1995, false));
    }

    /**
     * This method determines if an index is invalid.
     * @param index int index to check for
     * @return true if index is invalid and false if it is not invalid
     */
    public boolean isInvalid(int index) {
        return index < 0 || index > songList.size();
    }

    /**
     * This method adds a song to the song list.
     * @param song Song to be added to the list
     */
    public Song add(Song song) {
        songList.add(song);
        return song;
    }

    /**
     * This method returns the song list.
     * @return List of Songs
     */
    public List<Song> getAll() {
        return songList;
    }

    /**
     * This method returns a song by its index.
     * @param index int index of song in list
     * @return Song
     */
    public Song get(int index) {
        return songList.get(index);
    }

    /**
     * This method updates a song in the song list.
     * @param index int index of song to be updated
     * @param newSong Song to replace the old song in the list
     * @return Song
     */
    public Song update(int index, Song newSong) {
        return songList.set(index, newSong);
    }

    /**
     * This method deletes a song from the song list.
     * @param index int index of song to be deleted
     */
    public void delete(int index) {
        songList.remove(index);
    }
}
