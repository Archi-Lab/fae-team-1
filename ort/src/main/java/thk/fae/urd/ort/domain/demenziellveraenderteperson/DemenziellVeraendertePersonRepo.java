package thk.fae.urd.ort.domain.demenziellveraenderteperson;

import java.util.Optional;
import java.util.UUID;

public interface DemenziellVeraendertePersonRepo {
	Optional<DemenziellVeraendertePerson> findById(UUID id);

	DemenziellVeraendertePerson create(final DemenziellVeraendertePerson dvp);
}
