package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.Ort;

import java.util.Optional;
import java.util.UUID;

public interface OrtRepository {
	Optional<Ort> findById(UUID id);
	Ort save(final Ort ort);
}
