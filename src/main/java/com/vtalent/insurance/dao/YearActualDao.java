package com.vtalent.insurance.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.List;

import com.vtalent.insurance.model.ActualYear;
import com.vtalent.insurance.model.MakeOfCar;
import com.vtalent.insurance.model.Year;

	public class YearActualDao  {
	    Connection con;
	    PreparedStatement pst;
	    String query;
	    ResultSet rs;
	    
	    public YearActualDao(Connection con) {
	        this.con = con;
	    }
	    
	    public List<Year> getAllYear(){
	        List<Year> list  = new ArrayList<>();
	        try{
	            query = "select * from year";
	            pst = this.con.prepareStatement(query);
	            rs = pst.executeQuery();
	            while(rs.next()){
	                Year year = new Year();
	                year.setId(rs.getInt("y_id"));
	                year.setY_name(rs.getString("y_name"));
	                list.add(year);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    
	    public List<ActualYear> getStateByCountryId(int yearId){
	        List<ActualYear> list = new ArrayList<>();
	        try{
	            query = "select * from state where c_id=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, yearId);
	            rs = pst.executeQuery();
	            while(rs.next()){
	                ActualYear state = new ActualYear();
	                state.setId(rs.getInt("id"));
	                state.setId(rs.getInt("y_id"));
	                state.setName(rs.getString("name"));
	                list.add(state);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        } 
	        return list;
	    }
	    
	    
	    public List<MakeOfCar> getYearByActualYearId(int actualYearId){
	        List<MakeOfCar> list = new ArrayList<>();
	        try{
	            query = "select * from company_name where a_id=?";
	            pst = this.con.prepareStatement(query);
	            pst.setInt(1, actualYearId);
	            rs = pst.executeQuery();
	            while(rs.next()){
	            	MakeOfCar car = new MakeOfCar();
	                car.setId(rs.getInt("id"));
	                car.setY_id(rs.getInt("y_id"));
	                car.setActualYearId(rs.getInt("a_id"));
	                car.setName(rs.getString("name"));
	                list.add(car);
	            }
	        }catch(SQLException e){
	            e.printStackTrace();
	        }
	        return list;
	    }
	}

	  