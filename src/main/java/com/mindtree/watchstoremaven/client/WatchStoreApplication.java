package com.mindtree.watchstoremaven.client;

import java.util.InputMismatchException;
import java.util.List;
import java.util.TreeSet;

import com.mindtree.watchstoremaven.entity.Type;
import com.mindtree.watchstoremaven.entity.Watch;
import com.mindtree.watchstoremaven.exception.ApplicationException;
import com.mindtree.watchstoremaven.service.WatchStoreService;
import com.mindtree.watchstoremaven.service.impl.WatchStoreServiceImpl;
import com.mindtree.watchstoremaven.utility.UtilityClass;

public class WatchStoreApplication {

	public static void main(String[] args) {
		WatchStoreService service=new WatchStoreServiceImpl();
		boolean flag=true;
		do {
			
			System.out.println("1. for add Type");
			System.out.println("2. for Show all Types");
			System.out.println("3. for add Watch");
			System.out.println("4. for Show all watches sort accoding price");
			System.out.println("5. for deleted type");
			System.out.println("6. for Exit");
			int choice=UtilityClass.getInt();
			switch (choice) {
			case 1:
				try {
					System.out.println(service.addTypeService(addType()));
				} catch (ApplicationException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 2:
				try {
					displayTypes(service.allTypesService());
				} catch (ApplicationException e1) {
					System.err.println(e1.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println(service.addWathService(addWatch()));
				} catch (ApplicationException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				try {
					displayWatches(service.allWatchesService());
				} catch (ApplicationException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter the Id of the Type you want to deleted");
				int id=UtilityClass.getInt();
				try {
					System.out.println(service.deletedtpeService(id));
				} catch (ApplicationException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 6:
				flag=false;
				break;

			default:
				System.err.println("Enter the correct Input");
				break;
			}
			
		} while (flag);

	}
	public static Type addType() throws ApplicationException {
		Type type=new Type();
		try {
		System.out.println("Enter the Id of the Type");
		type.setTypeId(UtilityClass.getInt());
		System.out.println("Enter the Name of the Type");
		type.setTypeName(UtilityClass.getString());
		}catch(InputMismatchException e) {
			throw new ApplicationException("Input is Not correct");
		}
		return type;
	}
	public static Watch addWatch() throws ApplicationException {
		Watch watch=new Watch();
		try {
		System.out.println("Enter the Id of the Watch");
		watch.setWatchid(UtilityClass.getInt());
		System.out.println("Enter the Model number of the watch");
		watch.setModelNumber(UtilityClass.getString());
		System.out.println("Enter the price of the watch");
		watch.setPrice(UtilityClass.getFloat());
		System.out.println("Enter the id of the Type");
		watch.setTypeId(UtilityClass.getInt());
		}catch(InputMismatchException e) {
			throw new ApplicationException("Input is Not correct");
		}
		return watch;
	}
	public static void displayWatches(TreeSet<Watch> allWatches) {
		if(allWatches.size()==0) {
			System.err.println("No any Watch is Present");
		}
		for (Watch watch : allWatches) {
			System.out.println(watch.toString());
		}
		
	}
	public static void displayTypes(List<Type> allTypes) {
		if(allTypes.size()==0) {
			System.err.println("No any Type is Present");
		}
		for (Type type : allTypes) {
			System.out.println(type.toString());
		}
	}

}
