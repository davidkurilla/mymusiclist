package edu.greenriver.sdev.music.services;

import edu.greenriver.sdev.music.models.Playlist;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

/**
 * This class is a playlist service to perform CRUD operations on playlists.
 * @author David Kurilla
 * @version 1.0
 */
@Service
public class PlaylistService {

    private final List<Playlist> playlistList;

    /**
     * This constructor create a new instance of the PlaylistService and loads example data.
     */
    public PlaylistService() {
        playlistList = new ArrayList<>();
        loadPlaylists();
    }

    private void loadPlaylists() {
        playlistList.add(new Playlist("My Music", "David Kurilla", true, new ArrayList<>()));
    }

    /**
     * This method determines if an index is invalid.
     * @param index int index to check for
     * @return true if index is invalid and false if it is not invalid
     */
    public boolean isInvalid(int index) {
        return index < 0 || index > playlistList.size();
    }

    /**
     * This method adds a new playlist to the list of playlists.
     * @param playlist Playlist to be added to the list
     */
    public void add(Playlist playlist) {
        playlistList.add(playlist);
    }

    /**
     * This method returns the list of playlists.
     * @return List of Playlists
     */
    public List<Playlist> getAll() {
        return playlistList;
    }

    /**
     * This method returns a playlist by its index.
     * @param index int index of playlist
     * @return Playlist
     */
    public Playlist get(int index) {
        return playlistList.get(index);
    }

    /**
     * This method updates a playlist in the list.
     * @param index int index of the playlist to be updated
     * @param newPlayList Playlist to replace the old playlist with
     * @return Playlist
     */
    public Playlist update(int index, Playlist newPlayList) {
        return playlistList.set(index, newPlayList);
    }

    /**
     * This method deletes a playlist from the list.
     * @param index int index of playlist to be deleted
     */
    public void delete(int index) {
        playlistList.remove(index);
    }
}
