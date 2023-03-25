package com.example.song.controller;

/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here


import com.example.song.model.Song;
import com.example.song.service.*;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController{

    @Autowired
   public SongJpaService songServiceObj;

    @GetMapping("/songs")
    public ArrayList<Song> getSongsList(){
        return songServiceObj.getSongs();
    }

    @GetMapping("/songs/{songIdUser}")
public Song getBookById(@PathVariable("songIdUser") int songid1) {
    return songServiceObj.getSongById(songid1);
}

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song newSongDetails) {
        return songServiceObj.addSong(newSongDetails);
    }

    @PutMapping("/songs/{songIdUser}")
    public Song updateSong1(@PathVariable("songIdUser") int songId1, @RequestBody Song songupdateInfo) {
        return songServiceObj.updateSong(songId1, songupdateInfo);
    }

    @DeleteMapping("/songs/{songIdUser}")
    public void deleteSong1(@PathVariable("songIdUser") int deleteId){
        songServiceObj.deleteSong(deleteId);
    }


}