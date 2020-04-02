package com.mindtree.watchstoremaven.dao;

import java.util.List;
import java.util.TreeSet;

import com.mindtree.watchstoremaven.entity.Type;
import com.mindtree.watchstoremaven.entity.Watch;
import com.mindtree.watchstoremaven.exception.dao.DaoException;

public interface WatchStoreDao {
	public String addType(Type type) throws DaoException ;
	public String addWatch(Watch watch) throws DaoException ;
	public List<Type> allTypes() throws DaoException;
	public TreeSet<Watch>sortedWatches() throws DaoException;
	public String deletedType(int id) throws DaoException;
}
