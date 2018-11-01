package thk.fae.urd.ort.domain.ort;

import java.util.Optional;
import java.util.UUID;

public interface OrtRepo {
	Optional<Ort> findById(UUID id);

	Ort create(final Ort ort);
}
