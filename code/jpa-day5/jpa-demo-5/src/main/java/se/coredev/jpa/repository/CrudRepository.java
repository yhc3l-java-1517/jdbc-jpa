package se.coredev.jpa.repository;

import se.coredev.jpa.model.AbstractEntity;

public interface CrudRepository <E extends AbstractEntity>{

	 E saveOrUpdate(E entity);
	 E remove(E entity);
	 E findById(Long id);	
}
