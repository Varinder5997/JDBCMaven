package com.mindtree.watchstoremaven.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import com.mindtree.watchstoremaven.dao.WatchStoreDao;
import com.mindtree.watchstoremaven.dao.impl.WatchStoreDaoImpl;
import com.mindtree.watchstoremaven.entity.Type;
import com.mindtree.watchstoremaven.entity.Watch;
import com.mindtree.watchstoremaven.exception.dao.DaoException;
import com.mindtree.watchstoremaven.exception.service.ServiceException;
import com.mindtree.watchstoremaven.exception.service.ThisIdISnotPresent;
import com.mindtree.watchstoremaven.service.WatchStoreService;

public class WatchStoreServiceImpl implements WatchStoreService {
	WatchStoreDao daoImpl=new WatchStoreDaoImpl();
	
	public String addTypeService(Type type) throws ServiceException {
		try {
			return daoImpl.addType(type);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public List<Type> allTypesService() throws ServiceException{
		try {
			return daoImpl.allTypes();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	public String addWathService(Watch watch) throws ServiceException {
		List<Type>allType=new ArrayList<Type>();
		int count=0;
		try {
			allType=daoImpl.allTypes();
		} catch (DaoException e1) {
			throw new ServiceException(e1.getMessage());
		}
		for (Type type : allType) {
			if(type.getTypeId()==watch.getTypeId()) {
				count++;
			}
		}
		if(count>0) {
		try {
			return daoImpl.addWatch(watch);
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
		}
		else {
			throw new ThisIdISnotPresent("This Id Is not present");
		}
	}
	
	public TreeSet<Watch> allWatchesService() throws ServiceException{
		try {
			return daoImpl.sortedWatches();
		} catch (DaoException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	public String deletedtpeService(int id) throws ServiceException {
		try {
			return daoImpl.deletedType(id);
		} catch (DaoException e) {
			throw new ServiceException();
		}
	}

}
