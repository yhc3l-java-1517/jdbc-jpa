package se.coredev.jpa.repository;

import javax.persistence.EntityManagerFactory;

import se.coredev.jpa.model.Metadata;

public final class JpaMetadataRepository extends AbstractJpaRepository<Metadata> implements MetadataRepository{

	public JpaMetadataRepository(EntityManagerFactory factory) {
		super(factory, Metadata.class);
	}

}
