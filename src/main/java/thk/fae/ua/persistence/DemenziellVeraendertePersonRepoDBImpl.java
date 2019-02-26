package thk.fae.ua.persistence;

import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;
import thk.fae.ua.core.domain.repositories.DemenziellVeraendertePersonRepository;
import thk.fae.ua.infrastructure.kafka.listener.DvpListener;

@Repository
@RequiredArgsConstructor
public class DemenziellVeraendertePersonRepoDBImpl implements DemenziellVeraendertePersonRepository {

	private static final Logger LOGGER = LoggerFactory.getLogger(DvpListener.class);
	private final DemenziellVeraendertePersonRepoDBBase dbBase;

	@Override
	public Optional<DemenziellVeraendertePerson> findById(final UUID id) {
		return this.dbBase.findById(id);
	}

	@Override
	public Optional<DemenziellVeraendertePerson> findByTrackerId(UUID trackerId) {
		return this.dbBase.findOneDemenziellVeraendertePersonByTrackerTrackerId(trackerId);
	}

	@Override
	public Iterable<DemenziellVeraendertePerson> findAll() {
		return this.dbBase.findAll();
	}

	@Override
	public DemenziellVeraendertePerson save(final DemenziellVeraendertePerson dvp) {
		LOGGER.info("SAVING DVP with id: {}", dvp.getId());
		return this.dbBase.save(dvp);
	}

	@Override
	public void deleteById(UUID id) {
		LOGGER.info("DELETING DVP with id: {}", id);
		this.dbBase.deleteById(id);
	}

	@Override
	public boolean existsById(UUID id) {
		return  this.dbBase.existsById(id);
	}

}
