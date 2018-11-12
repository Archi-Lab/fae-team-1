package thk.fae.urd.ort.repo;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePerson;
import thk.fae.urd.ort.domain.demenziellveraenderteperson.DemenziellVeraendertePersonRepo;

@Repository
public class DemenziellVeraendertePersonRepoDBImpl implements DemenziellVeraendertePersonRepo {

	private final DemenziellVeraendertePersonRepoDBBase dbBase;

	public DemenziellVeraendertePersonRepoDBImpl(final DemenziellVeraendertePersonRepoDBBase dbBase) {
		this.dbBase = dbBase;
	}

	@Override
	public Optional<DemenziellVeraendertePerson> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public DemenziellVeraendertePerson create(final DemenziellVeraendertePerson dvp) {
		return this.dbBase.save(dvp);
	}

}
