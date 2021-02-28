/* 
 * Created by 2019年1月30日
 */
package com.demo2.trade.service;

import java.util.List;

import com.demo2.support.entity.Entity;
import com.demo2.trade.entity.Supplier;

/**
 * The service of suppliers.
 * 
 * @author fangang
 */
public interface SupplierService {
	/**
	 * @param id
	 * @return the supplier
	 */
	public Supplier loadSupplier(long id);

	/**
	 * @param ids
	 * @return
	 */
	public List<Entity<?>> loadSuppliers(List<Long> ids);

	/**
	 * @return the list of supplier
	 */
	public List<Entity<?>> listOfSuppliers();
}
