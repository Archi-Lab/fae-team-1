package thk.fae.ua.persistence;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;

@Repository
public class DemenziellVeraendertePersonRepoDBImpl implements DemenziellVeraendertePersonRepository {

	private final DemenziellVeraendertePersonRepoDBBase dbBase;

	public DemenziellVeraendertePersonRepoDBImpl(final DemenziellVeraendertePersonRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<DemenziellVeraendertePerson> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Iterable<DemenziellVeraendertePerson> findAll() {
		return this.dbBase.findAll();
	}

	@Override
	public DemenziellVeraendertePerson save(final DemenziellVeraendertePerson dvp) {
		return this.dbBase.save(dvp);
	}

}
