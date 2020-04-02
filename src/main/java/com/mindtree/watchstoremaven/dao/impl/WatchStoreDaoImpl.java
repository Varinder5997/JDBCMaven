package com.mindtree.watchstoremaven.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.mindtree.watchstoremaven.dao.WatchStoreDao;
import com.mindtree.watchstoremaven.entity.Type;
import com.mindtree.watchstoremaven.entity.Watch;
import com.mindtree.watchstoremaven.exception.dao.DaoException;
import com.mindtree.watchstoremaven.utility.UtilityClass;

public class WatchStoreDaoImpl implements WatchStoreDao {
	
	
	public String addType(Type type) throws DaoException {
		try {
		String sql="Insert into WatchType(TypeId,Typename) value(?,?)";
		PreparedStatement statement= UtilityClass.getConnection().prepareStatement(sql);
		statement.setInt(1, type.getTypeId());
		statement.setString(2, type.getTypeName());
		statement.executeUpdate();
		statement.close();
		
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	
		return "Data is added Succesfully";
		
	}
	public String addWatch(Watch watch) throws DaoException {
		try {
		String sql="Insert into Watch(WatchId,WatchModalNumber,price,TypeId) value(?,?,?,?)";
		PreparedStatement statement= UtilityClass.getConnection().prepareStatement(sql);
		statement.setInt(1, watch.getWatchid());
		statement.setString(2, watch.getModelNumber());
		statement.setFloat(3, watch.getPrice());
		statement.setInt(4, watch.getTypeId());
		statement.executeUpdate();
		statement.close();
		
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
	
		return "Watch is added succesfully";
		
	}
	public List<Type> allTypes() throws DaoException{
		List<Type>allType=new ArrayList<Type>();
		try {
		String sql="Select * from WatchType";
		PreparedStatement statement;
		statement = UtilityClass.getConnection().prepareStatement(sql);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			Type type=new Type();
			type.setTypeId(rs.getInt(1));
			type.setTypeName(rs.getString(2));
			allType.add(type);
		}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage());
		}
		return allType;
		
	}
	public TreeSet<Watch>sortedWatches() throws DaoException{
		TreeSet<Watch> allWatches=new TreeSet<Watch>();
		try {
		String sql="Select * from Watch";
		PreparedStatement statement;
		statement = UtilityClass.getConnection().prepareStatement(sql);
		ResultSet rs=statement.executeQuery();
		while(rs.next()) {
			Watch watch=new Watch();
			watch.setWatchid(rs.getInt(1));
			watch.setModelNumber(rs.getString(2));
			watch.setPrice(rs.getFloat(3));
			watch.setTypeId(rs.getInt(4));
			allWatches.add(watch);
			
		}
		
	}catch (SQLException e) {
		throw new DaoException(e.getMessage());
	}
		return allWatches;

}
	public String deletedType(int id) throws DaoException {
		try {
			String sql="Delete from Watch Where TypeId=?";
			PreparedStatement statement= UtilityClass.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
			
			String sql1="Delete from WatchType where TypeId=?";
			PreparedStatement statement1= UtilityClass.getConnection().prepareStatement(sql1);
			statement1.setInt(1, id);
			statement1.executeUpdate();
			statement1.close();
			} catch (SQLException e) {
				throw new DaoException(e.getMessage());
			}
		return "Type id deleted";
	}
	
	
}
