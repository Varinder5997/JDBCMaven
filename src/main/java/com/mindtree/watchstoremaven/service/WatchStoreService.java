package com.mindtree.watchstoremaven.service;

import java.util.List;
import java.util.TreeSet;

import com.mindtree.watchstoremaven.entity.Type;
import com.mindtree.watchstoremaven.entity.Watch;
import com.mindtree.watchstoremaven.exception.service.ServiceException;

public interface WatchStoreService {
	public String addTypeService(Type type) throws ServiceException ;
	public List<Type> allTypesService() throws ServiceException;
	public String addWathService(Watch watch) throws ServiceException ;
	public TreeSet<Watch> allWatchesService() throws ServiceException;
	public String deletedtpeService(int id) throws ServiceException ;

}
