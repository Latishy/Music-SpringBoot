package com.example.song.service;

import java.util.*;


import com.example.song.model.*;
import com.example.song.repository.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SongService implements SongRepository{
    private HashMap<Integer,Song> hmap=new HashMap<>();
    int uniqueSongId = 3;

    
    public SongService(){
        Song s1=new Song(1,"a","aa","aaa","aaaa");
        Song s2=new Song(2,"b","bb","bbb","bbbb");
        
        hmap.put(s1.getSongId(),s1);
        hmap.put(s2.getSongId(),s2);

    }

    @Override
	public ArrayList<Song> getSongs(){
        Collection<Song> SongCollection=hmap.values();
        ArrayList<Song> SongArr= new ArrayList<>(SongCollection);
        return SongArr;
        

        
    }
    @Override
    public Song getSongById(int WantedInfosongid) {
        Song song = hmap.get(WantedInfosongid);
        if(song == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return song;
        }

    @Override
    public Song addSong(Song song) {
        song.setSongId(uniqueSongId);
        hmap.put(uniqueSongId, song);
        uniqueSongId += 1;

        return song;
    }

    @Override
    public Song updateSong(int songId, Song song) {
        Song existingSong=hmap.get(songId);

        if(existingSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if (song.getSongName() != null) {
            existingSong.setSongName(song.getSongName());
        }
        
        if (song.getLyricist() != null) {
            existingSong.setLyricist(song.getLyricist());
        }
        return existingSong;
    }

    @Override
    public void deleteSong(int songId){
        Song song=hmap.get(songId);

        if(song == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else{
            hmap.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }
}