package edu.greenriver.sdev.music.controllers;

import edu.greenriver.sdev.music.models.Song;
import edu.greenriver.sdev.music.services.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

/**
 * This class is a controller for the Songs endpoints.
 * @author David Kurilla
 * @version 1.0
 */
@RestController
@RequestMapping("/songs")
@Validated
public class SongController {

    private final SongService service;

    /**
     * This constructor creates an instance of the SongController class
     */
    public SongController() {
        service = new SongService();
    }

    /**
     * This method handles exceptions in the class.
     * @param ex Exception
     * @return ResponseEntity
     */
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> methodArgumentExceptionHandler(Exception ex) {
        String message = "400: Index must be an integer.";
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
     * This method gets all songs.
     * @return List of Songs
     */
    @GetMapping
    public List<Song> getAll() {
        return service.getAll();
    }

    /**
     * This method adds a new song.
     * @param song Song to be added
     * @return ResponseEntity
     */
    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Song song) {
        if (song == null) {
            return new ResponseEntity<>("Invalid song submitted", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.add(song), HttpStatus.OK);
        }
    }

    /**
     * This method gets a song by index.
     * @param index int index of song
     * @return ResponseEntity
     */
    @GetMapping("/{index}")
    public ResponseEntity<Object> get(@PathVariable("index") Integer index) {
        if (service.isInvalid(index)) {
            return new ResponseEntity<>("400: Invalid index", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.get(index), HttpStatus.OK);
        }
    }

    /**
     * This method updates a song.
     * @param index int index of song
     * @param newSong Song to replace old song
     * @return ResponseEntity
     */
    @PutMapping("/{index}")
    public ResponseEntity<Object> update(@PathVariable("index") Integer index, @RequestBody Song newSong) {
        if (service.isInvalid(index) || newSong == null) {
            return new ResponseEntity<>("400: Invalid index or song submission", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.update(index, newSong), HttpStatus.OK);
        }
    }

    /**
     * This method deletes a song.
     * @param index int index of song
     * @return ResponseEntity
     */
    @DeleteMapping("/{index}")
    public ResponseEntity<Object> delete(@PathVariable("index") Integer index) {
        if (service.isInvalid(index)) {
            return new ResponseEntity<>("400: Invalid index", HttpStatus.BAD_REQUEST);
        } else {
            service.delete(index);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
