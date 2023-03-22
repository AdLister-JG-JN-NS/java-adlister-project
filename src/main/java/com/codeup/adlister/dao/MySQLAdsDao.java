package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
// class for ads
public class MySQLAdsDao implements Ads {
    private Connection connection = null;
// get a list of all the ads
    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
// insert a new ad and return the new ad's id
    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }
// insert a new ad and return the new ad's id
    @Override
    public List<Ad> search(String str) {
        PreparedStatement stmt = null;
        try {
            List<Ad> output = searchTitle(str);
            syncLists(output, searchCompany(str));
            syncLists(output, searchJobType(str));
            syncLists(output, searchLocation(str));
            syncLists(output, searchDescription(str));
            return output;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

    }
    private void syncLists(List<Ad> mainList, List<Ad> comparisonList){
        for(Ad ad : comparisonList){
            if(!mainList.contains(ad)){
                mainList.add(ad);
            }
        }
    }

    private List<Ad> searchTitle(String str) throws SQLException {
        String query = "SELECT * FROM ads where title like ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "%" + str + "%");
        return createAdsFromResults(stmt.executeQuery());
    }
    private List<Ad> searchCompany(String str) throws SQLException {
        String query = "SELECT * FROM ads where company like ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "%" + str + "%");
        return createAdsFromResults(stmt.executeQuery());
    }
    private List<Ad> searchJobType(String str) throws SQLException {
        String query = "SELECT * FROM ads where job_type like ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "%" + str + "%");
        return createAdsFromResults(stmt.executeQuery());
    }
    private List<Ad> searchLocation(String str) throws SQLException {
        String query = "SELECT * FROM ads where location like ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "%" + str + "%");
        return createAdsFromResults(stmt.executeQuery());
    }
    private List<Ad> searchDescription(String str) throws SQLException {
        String query = "SELECT * FROM ads where description like ?";
        PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, "%" + str + "%");
        return createAdsFromResults(stmt.executeQuery());
    }


    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description, company, job_type, location, salary) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4, ad.getCompany());
            stmt.setString(5, ad.getJob_type());
            stmt.setString(6, ad.getLocation());
            stmt.setLong(7, ad.getSalary());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }
// delete an ad
    @Override
    public void delete(Ad ad) {
        try {
            String insertQuery = "DELETE FROM ads WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }
// edit an ad
    @Override
    public void edit(Ad ad) {
        try{
            String updateQuery = "update ads set " +
                    "title = ?, " +
                    "description = ?, " +
                    "company = ?, " +
                    "salary = ?, " +
                    "job_type = ?, " +
                    "location = ? " +
                    "where id = ?";
            PreparedStatement stmt = connection.prepareStatement(updateQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, ad.getTitle());
            stmt.setString(2, ad.getDescription());
            stmt.setString(3, ad.getCompany());
            stmt.setDouble(4, ad.getSalary());
            stmt.setString(5, ad.getJob_type());
            stmt.setString(6, ad.getLocation());
            stmt.setLong(7, ad.getId());
            stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException("Error updating ad.", e);
        }
    }
// find an ad by id
    public Ad findById(long id) {
        List<Ad> ads = DaoFactory.getAdsDao().all();
        for (Ad ad : ads){
            if(ad.getId() == id){
                return ad;
            }
        }
        return null;
    }
// find ads by user id
    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("company"),
            rs.getString("job_type"),
            rs.getString("location"),
            rs.getLong("salary")
        );
    }
// create ads from results
    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
