package edu.pupr.musiclibrary;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import java.awt.Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * Description: This class enables the connection with the database using the URL, USERNAME, and PASSWORD.
 * Date: 03/17/2018
 * 
 * @author Edwin
 * @author Jonathan
 * @author Wilfredo
 * @author Cristian
 */

public class MusicQuery     
{

    private static final String URL = "jdbc:derby://localhost:1527/sample;create=true"; //
    private static final String USERNAME = "";	// Left this on Blank for the sake of privacy. Yes, In reality, there is a username and password.
    private static final String PASSWORD = "";	// In order to test the program, you need to start up the connection.

    private Connection connection = null; // manages connection //
    private PreparedStatement selectAllAlbum = null;	//
    private PreparedStatement selectAlbumByUPC = null; //
    private PreparedStatement selectAlbumName = null; //
    private PreparedStatement insertNewAlbum = null;	//
    private PreparedStatement updateAlbum = null;	//

    private PreparedStatement endVisit = null;
    private PreparedStatement todaysReport = null;
    //private PreparedStatement logInQuery = null;
    private PreparedStatement totalPrice = null;
	
    //---------Completada-------------------------------------------------------------
  // constructor
    
    /**
     * MAIN
     * @param args
     */
    public static void main (String [] args) 
    {
    	MusicQuery musicQuery = new MusicQuery();
    	List<Music> albums = musicQuery.getAllAlbum();
    	int i = albums.size();
    	for(Music a: albums) 
    	{
    		System.out.println("Album: "+ a.getAlbumName());
    	}
    }
    
   /**
    * DEFAULT CONSTRUCTOR
 * 
 */
public MusicQuery()     //AutoPartsQuery()
   { 
        try 
        {
            connection
                    = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // create query that selects all entries in the Authors table
            selectAllAlbum
                    = connection.prepareStatement("SELECT * FROM ALBUMS.MUSIC"); //FROM AUTOPART

            // create query that selects entries with a specific author's id
            selectAlbumByUPC = connection.prepareStatement(
                    "SELECT * FROM ALBUMS.MUSIC WHERE UPC = ?");

            // create query that selects entries with a specific author's last name
            selectAlbumName = connection.prepareStatement(
                    "SELECT * FROM ALBUMS.MUSIC WHERE ALBUM_NAME = ?");


            // create insert that adds a new entry into the database
            insertNewAlbum = connection.prepareStatement(
                    "INSERT INTO ALBUMS.MUSIC "
                    + "( UPC, ALBUM_NAME, ARTIST,"
                    + " image_name, GENRE, RELEASE_DATE, RANK,"
                    + " FORMAT, PRICE) "
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            updateAlbum = connection.prepareStatement(
                    "UPDATE ALBUMS.MUSIC "
                    + " SET UPC = ?, "
                    + "     ALBUM_NAME = ? ,"
                    + "     ARTIST = ? ,"
                    + "     image_name = ?, "
                    + "     GENRE = ? ,"
                    + "     RELEASE_DATE = ? ,"
                    + "     RANK = ?,"
                    + "     FORMAT = ?,"
                    + "     PRICE = ?"
                    + " WHERE UPC = ?");
                        
            /*logInQuery = connection.prepareStatement(
                    "SELECT * "
                            + "FROM LogIn "
                            + "WHERE user_name = ? AND password=?");
	      */
            
        } // end try                  
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
            System.exit(1);
        } // end catch
    } //end MusicQuery constructor

//------------------COMPLETED------------------------------------------------------------------------

    // select all of the parts in the database
/**
 * SELECT ALL OF THE PARTS IN THE DATABASE
 * @return results
 */
public List< Music> getAllAlbum() {
       List< Music> results = null;
       ResultSet resultSet = null;

       try {
           // executeQuery returns ResultSet containing matching entries
           resultSet = selectAllAlbum.executeQuery();
           results = new ArrayList<>();

           while (resultSet.next()) {
               results.add(new Music(
                       resultSet.getString("UPC"),
                       resultSet.getString("ALBUM_NAME"),
                       resultSet.getString("ARTIST"),
                       resultSet.getString("IMAGE_NAME"),
                       resultSet.getString("GENRE"),
			resultSet.getString("RELEASE_DATE"),
                       resultSet.getInt("RANK"),
                       resultSet.getString("FORMAT"),
                       resultSet.getDouble("PRICE")
                       ));
           } // end while
       } // end try // end try
       catch (SQLException sqlException) {
           sqlException.printStackTrace();
       } // end catch
       finally {
           try {
               resultSet.close();
           } // end try
           catch (SQLException sqlException) {
               sqlException.printStackTrace();
               close();
           } // end catch
       } // end finally

       return results;
   } 
   
//----------------COMPLETED---------------------------------------------------------------------------------

    // select author by last name  
    /**
     * SELECT AUTHOR BY LAST NAME
     * @param upc
     * @return results
     */
    public List< Music> getAlbumByUPC(String upc) 
    {
        List< Music> results = null;
        ResultSet resultSet = null;

        try 
        {
            selectAlbumByUPC.setString(1, upc); // specify last name

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAlbumByUPC.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) 
            {
                results.add(new Music(resultSet.getString("UPC"),
                        resultSet.getString("ALBUM_NAME"),
                        resultSet.getString("ARTIST"),
                        resultSet.getString("IMAGE_NAME"),
                        resultSet.getString("GENRE"),
                        resultSet.getString("RELEASE_DATE"),
                        resultSet.getInt("RANK"),
                        resultSet.getString("FORMAT"),
                        resultSet.getDouble("PRICE")));
            } // end while
        } // end try 
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        } // end catch
        finally 
        {
            try 
            {
                resultSet.close();
            } // end try
            catch (SQLException sqlException) 
            {
                sqlException.printStackTrace();
                close();
            } // end catch
        } // end finally

        return results;
    }    

 //--------------COMPLETED------------------------------------------------------------------   
    // select author by PartName 
  					
    /**
     * SELECT AUTHOR BY NAME
     * @param name
     * @return result
     */
    public List< Music> getAlbumName(String name) 
    {
        List< Music> results = null;
        ResultSet resultSet = null;

        try 
        {
            selectAlbumName.setString(1, name); // specify last name

            // executeQuery returns ResultSet containing matching entries
            resultSet = selectAlbumName.executeQuery();

            results = new ArrayList<>();

            while (resultSet.next()) 
	       {
             results.add(new Music(resultSet.getString("UPC"),
                        resultSet.getString("ALBUM_NAME"),
                        resultSet.getString("ARTIST"),
                        resultSet.getString("IMAGE_NAME"),
                        resultSet.getString("GENRE"),
                        resultSet.getString("RELEASE_DATE"),
                        resultSet.getInt("RANK"),
                        resultSet.getString("FORMAT"),
                        resultSet.getDouble("PRICE")));
            } // end while
        } // end try // end try
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        } // end catch
        finally 
	    {
            try 
	        {
                resultSet.close();
            } // end try
            catch (SQLException sqlException) 
            {
                sqlException.printStackTrace();
                close();
            } // end catch
        } // end finally

        return results;
    } //end method getAlbumName


//-----------------------COMPLETED---------------------------------------------------------------------------

    // add an entry
    /**
     * ADD ENTRIES
     * @param UPC - UPC
     * @param albumName - NAME
     * @param artist - ARTIST
     * @param albumImageName - NAME
     * @param genre - GENRE
     * @param releaseDate - DATE
     * @param rank - RANK
     * @param format - FORMAT
     * @param price - PRICE
     * @return result
     * @throws SQLException
     */
    public int addAlbums(String UPC, String albumName, String artist, String albumImageName, 
             String genre, String releaseDate, int rank, String format, Double price) throws SQLException 
    {
        int result = 0;
        boolean success = true;
        MusicQuery query =new MusicQuery();//---------------------
        if (!query.getAlbumByUPC(UPC).isEmpty()) {
            throw new SQLIntegrityConstraintViolationException();
        }
        
        // set parameters, then execute insertNewAuthors
            insertNewAlbum.setString(1, UPC);
            insertNewAlbum.setString(2, albumName);
	        insertNewAlbum.setString(3, artist);
            insertNewAlbum.setString(4, albumImageName);
            insertNewAlbum.setString(5, genre);
            insertNewAlbum.setString(6, releaseDate);
            insertNewAlbum.setInt(7, rank);
            insertNewAlbum.setString(8, format);
            insertNewAlbum.setDouble(9, price);
            
            
            // insert the new entry; returns # of rows updated
            result = insertNewAlbum.executeUpdate();// end try

        return result;
    } 

    // modify an entry
    /**
     * MODIFY AN ENTRY
     * @param UPC - UPC
     * @param albumName - NAME
     * @param artist - ARTIST
     * @param albumImageName - NAME
     * @param genre - GENRE
     * @param releaseDate - DATE
     * @param rank - RANK
     * @param format - FORMAT
     * @param price - PRICE
     * @param originalID - ID
     * @return result
     */
    public int modifyAlbum(String UPC, String albumName, String artist, String albumImageName,
            String genre, String releaseDate, int rank, String format, Double price, String originalID) 
    {
        int result = 0;

        // set parameters, then execute insertNewAuthors
        try {
		
            updateAlbum.setString(1, UPC);
            updateAlbum.setString(2, albumName);
            updateAlbum.setString(3, artist);
            updateAlbum.setString(4, albumImageName);
            updateAlbum.setString(5, genre);
            updateAlbum.setString(6, releaseDate);
            updateAlbum.setInt(7, rank);
            updateAlbum.setString(8, format);
            updateAlbum.setDouble(9, price);
            updateAlbum.setString(10, originalID);
            // insert the new entry; returns # of rows updated
            result = updateAlbum.executeUpdate();
        } // end try // end try
        catch (SQLException sqlException) 
	{
            sqlException.printStackTrace();
            close();
        } // end catch

        return result;
    } 
    
//------------------------COMPLETED AND VERIFIED--------------------------------------

    /**
     * REPORT
     * @param today
     * @return resluts
     */
    public List< Music> getReport(String today) {
        List< Music> results = null;
        ResultSet resultSet = null;

        try {
            // executeQuery returns ResultSet containing matching entries
            todaysReport.setString(1, today);
            resultSet = todaysReport.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()) {
             results.add(new Music(resultSet.getString("UPC"),
                        resultSet.getString("ALBUM_NAME"),
                        resultSet.getString("ARTIST"),
                        resultSet.getString("IMAGE_NAME"),
                        resultSet.getString("GENRE"),
			resultSet.getString("RELEASE_DATE"),
                        resultSet.getInt("RANK"),
                        resultSet.getString("FORMAT"),
                        resultSet.getDouble("PRICE")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch
        finally {
            try {
                resultSet.close();
            } // end try
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            } // end catch
        } // end finally

        return results;
    } 

    public void close() 
    {
        try 
        {
            connection.close();
        } // end try
        catch (SQLException sqlException) 
        {
            sqlException.printStackTrace();
        } // end catch
     } // end method close 
    

}