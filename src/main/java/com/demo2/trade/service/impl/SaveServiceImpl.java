package com.demo2.trade.service.impl;

import java.util.List;

import com.demo2.support.dao.BasicDao;
import com.demo2.support.entity.Entity;
import com.demo2.trade.service.SaveService;

public class SaveServiceImpl implements SaveService<Entity<?>> {

	private BasicDao dao;

	/**
	 * @return the dao
	 */
	public BasicDao getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(BasicDao dao) {
		this.dao = dao;
	}

	@Override
	public void create(Entity<?> t) {
		dao.insert(t);
	}

	@Override
	public void update(Entity<?> t) {
		dao.update(t);
	}

	@Override
	public void delete(Entity<?> t) {
		dao.delete(t);
	}

	@Override
	public Entity<?> check(Long id) {
		Entity<Long> entity = new Entity<Long>() {

			@Override
			public Long getId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setId(Long id) {
				// TODO Auto-generated method stub

			}

		};
		return dao.load(id, entity);
	}

	@Override
	public List<Entity<?>> listOf() {
		Entity<Long> entity = new Entity<Long>() {

			@Override
			public Long getId() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setId(Long id) {
				// TODO Auto-generated method stub

			}

		};
		return dao.loadAll(entity);
	}

}
