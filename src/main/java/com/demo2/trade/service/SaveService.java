package com.demo2.trade.service;

import java.util.List;

public interface SaveService<T> {
	/**
	 * @param t
	 */
	public void create(T t);

	/**
	 * @param t
	 */
	public void update(T t);

	/**
	 * @param t
	 */
	public void delete(T t);

	/**
	 * @param id
	 * @return
	 */
	public T check(Long id);

	/**
	 * @return
	 */
	public List<T> listOf();
}
