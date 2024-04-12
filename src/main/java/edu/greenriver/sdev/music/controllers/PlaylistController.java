package edu.greenriver.sdev.music.controllers;

import edu.greenriver.sdev.music.models.Playlist;
import edu.greenriver.sdev.music.services.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

/**
 * This class is a controller for the playlists endpoints.
 *
 * @author David Kurilla
 * @version 1.0
 */
@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService service;

    /**
     * This constructor constructs a new instance of PlaylistController.
     */
    public PlaylistController() {
        service = new PlaylistService();
    }

    /**
     * This method handles exceptions in the class.
     * @param ex Exception
     * @return ResponseEntity
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> exceptionHandler(Exception ex) {
        String message = "Invalid index. Index must be an integer.";
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    /**
     * This method handles exceptions in the class.
     * @param ex Exception
     * @return ResponseEntity
     */
    @ExceptionHandler({IndexOutOfBoundsException.class})
    public ResponseEntity<Object> notFoundExceptionHandler(Exception ex) {
        String message = "404: Element not found at index!";
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }

    /**
     * This method gets all playlists.
     * @return List of Playlists
     */
    @GetMapping
    public List<Playlist> getAll() {
        return service.getAll();
    }

    /**
     * This method adds a playlist.
     * @param playlist Playlist to be added
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Playlist playlist) {
        if (playlist == null) {
            return new ResponseEntity<>("Invalid song submitted", HttpStatus.BAD_REQUEST);
        } else {
            service.add(playlist);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    /**
     * This method returns a playlist by index.
     * @param index int index of playlist
     * @return ResponseEntity
     */
    @GetMapping("/{index}")
    public ResponseEntity<Object> get(@PathVariable("index") Integer index) {
        if (service.isInvalid(index)) {
            return new ResponseEntity<>("Invalid index", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.get(index), HttpStatus.OK);
        }
    }

    /**
     * This method updates a playlist.
     * @param index int index of playlist
     * @param newPlaylist Playlist to replace old playlist
     * @return ResponseEntity
     */
    @PutMapping("/{index}")
    public ResponseEntity<Object> update(@PathVariable("index") Integer index, @RequestBody Playlist newPlaylist) {
        if (service.isInvalid(index)) {
            return new ResponseEntity<>("Invalid index", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.update(index, newPlaylist), HttpStatus.OK);
        }
    }

    /**
     * This method deletes a playlist.
     * @param index int index of playlist
     * @return ResponseEntity
     */
    @DeleteMapping("/{index}")
    public ResponseEntity<Object> delete(@PathVariable("index") Integer index) {
        if (service.isInvalid(index)) {
            return new ResponseEntity<>("Invalid index", HttpStatus.BAD_REQUEST);
        } else {
            service.delete(index);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
