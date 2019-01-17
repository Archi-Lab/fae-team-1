package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

import java.util.Optional;
import java.util.UUID;

public interface DemenziellVeraendertePersonRepository {
	Optional<DemenziellVeraendertePerson> findById(UUID id);
	Iterable<DemenziellVeraendertePerson> findAll();
	DemenziellVeraendertePerson save(final DemenziellVeraendertePerson dvp);
}