package thk.fae.ua.persistence;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.ua.core.domain.entities.Ort;

@RepositoryRestResource(path = "orte", collectionResourceRel = "orte", itemResourceRel = "ort")
public interface OrtRepoDBBase extends CrudRepository<Ort, UUID> {
}
