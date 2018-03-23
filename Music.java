package edu.pupr.musiclibrary;

/**
 * Description: This class is the base of the program that allows the creation of objects of type Music.
 * Date: 03/17/2018
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo
 * @author Cristian 
 */
public class Music 
{
	private String UPC;
	private String albumName;
	private String artist;
	private String albumImageName;
	private String genre;
	private String releaseDate;
	private int rank;
	private String format;
	private double price;
	
	/**
	 * DEFAULT CONSTRUCTOR
	 */
	public Music() 
	{
		
	}
	
	/**
	 * @param uPC - UPC
	 * @param albumName - NAME
	 * @param artist - ARTIST
	 * @param albumImageName - IMAGE
	 * @param genre - GENRE
	 * @param releaseDate - DATE
	 * @param rank - RANK
	 * @param format - FORMAT
	 * @param price - PRICE
	 * PARAMETER CONSTRUCTOR
	 */
	public Music(String uPC, String albumName, String artist, String albumImageName, String genre, String releaseDate,
			int rank, String format, double price) {
		super();
		UPC = uPC;
		this.albumName = albumName;
		this.artist = artist;
		this.albumImageName = albumImageName;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.rank = rank;
		this.format = format;
		this.price = price;
	}
	/**
	 * SETTER
	 * @param uPC - UPC
	 */
	public void setUPC(String uPC) 
	{
		UPC = uPC;
	}
	/**
	 * SETTER
	 * @param albumName - NAME
	 */
	public void setAlbumName(String albumName) 
	{
		this.albumName = albumName;
	}
	/**
	 * SETTER
	 * @param artist - ARTIST
	 */
	public void setArtist(String artist) 
	{
		this.artist = artist;
	}
	
	/**
	 * SETTER
	 * @param albumImageName - IMAGE
	 */
	public void setAlbumImageName(String albumImageName) 
	{
		this.albumImageName = albumImageName;
	}
	
	/**
	 * SETTER
	 * @param genre - GENRE
	 */
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	/**
	 * SETTER
	 * @param releaseDate - DATE
	 */
	public void setReleaseDate(String releaseDate) 
	{
		this.releaseDate = releaseDate;
	}
	/**
	 * SETTER
	 * @param rank - RANK
	 */
	public void setRank(int rank) 
	{
		this.rank = rank;
	}
	
	/**
	 * SETTER
	 * @param format - FORMAT
	 */
	public void setFormat(String format) 
	{
		this.format = format;
	}
	/**
	 * SETTER
	 * @param price - PRICE
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	/**
	 * @return UPC
	 */
	public String getUPC()
	{
		return UPC;
	}
	
	/**
	 * @return ALUM_NAME
	 */
	public String getAlbumName() 
	{
		return albumName;
	}
	
	/**
	 * @return ARTIST
	 */
	public String getArtist()
	{
		return artist;
	}
	
	/**
	 * @return IMAGE
	 */
	public String getAlbumImageName()
	{
		return albumImageName;
	}
	
	/**
	 * @return GENRE
	 */
	public String getGenre()
	{
		return genre;
	}
	/**
	 * @return DATE
	 */
	public String getReleaseDate() 
	{
		return releaseDate;
	}
	/**
	 * @return RANK
	 */
	public int getRank() 
	{
		return rank;
	}
	/**
	 * @return FORMAT
	 */
	public String getFormat() 
	{
		return format;
	}
	/**
	 * @return PRICE
	 */
	public double getPrice()
	{
		return price;
	}
	/**
	 * SETS ALL
	 * @param uPC
	 * @param albumName
	 * @param artist
	 * @param albumImageName
	 * @param genre
	 * @param releaseDate
	 * @param rank
	 * @param format
	 * @param price
	 */
	public void setMusic(String uPC, String albumName, String artist, 
			String albumImageName, String genre,
			String releaseDate, int rank, String format, double price) {
		setUPC(uPC);
		setAlbumName(albumName);
		setArtist(artist);
		setAlbumImageName(albumImageName);
		setGenre(genre);
		setReleaseDate(releaseDate);
		setRank(rank);
		setFormat(format);
		setPrice(price);
	}
	
	
	
	
} // end Music Class