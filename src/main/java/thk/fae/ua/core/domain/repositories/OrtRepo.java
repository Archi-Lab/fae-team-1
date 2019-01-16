package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.Ort;

import java.util.Optional;
import java.util.UUID;

public interface OrtRepo {
	Optional<Ort> findById(UUID id);

	Ort create(final Ort ort);
}
