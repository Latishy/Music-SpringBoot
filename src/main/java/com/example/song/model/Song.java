package com.example.song.model;

 import javax.persistence.*;


@Entity
@Table(name="songlist")

public class Song{
 

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "songid")
  private int songId;

  @Column(name = "songname")
  private String songName;

@Column(name = "lyricist")
  private String lyricist;


@Column(name = "singer")
  private String singer;

  @Column(name = "musicdirector")
  private String musicDirector;


  public Song(){}

    public Song(int songIdValue,String songNameValue, String lyricistValue, String singerValue,String musicDirectorValue){
        this.songId=songIdValue;
        this.songName=songNameValue;
        this.lyricist=lyricistValue;
        this.singer=singerValue;
        this.musicDirector=musicDirectorValue;

    }

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId1) {
		this.songId = songId1;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName1) {
		this.songName = songName1;
	}

	public String getLyricist() {
		return lyricist;
	}

	public void setLyricist(String lyricist1) {
		this.lyricist = lyricist1;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer1) {
		this.singer = singer1;
	}

	public String getMusicDirector() {
		return musicDirector;
	}

	public void setMusicDirector(String musicDirector1) {
		this.musicDirector = musicDirector1;
	}

    
}
