package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.DemenziellVeraendertePerson;

import java.util.Optional;
import java.util.UUID;

public interface DemenziellVeraendertePersonRepo {
	Optional<DemenziellVeraendertePerson> findById(UUID id);

	DemenziellVeraendertePerson create(final DemenziellVeraendertePerson dvp);
}
