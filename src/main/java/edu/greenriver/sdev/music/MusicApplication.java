package edu.greenriver.sdev.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class is the entry point to my Spring Boot Music Application.
 * @author David Kurilla
 * @version 1.0
 */
@SpringBootApplication
public class MusicApplication {

    /**
     * This method is the entry point to my Spring Boot Music Application.
     * @param args String[] command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

}
