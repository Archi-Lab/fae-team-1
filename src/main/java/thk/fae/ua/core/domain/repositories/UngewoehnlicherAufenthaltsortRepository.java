package thk.fae.ua.core.domain.repositories;

import thk.fae.ua.core.domain.entities.UngewoehnlicherAufenthaltsort;

import java.util.Optional;
import java.util.UUID;

public interface UngewoehnlicherAufenthaltsortRepository {
    Optional<UngewoehnlicherAufenthaltsort> findById(UUID id);
    UngewoehnlicherAufenthaltsort save(final UngewoehnlicherAufenthaltsort route);
}
