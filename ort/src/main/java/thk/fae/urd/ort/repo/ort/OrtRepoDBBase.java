package thk.fae.urd.ort.repo.ort;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import thk.fae.urd.ort.domain.ort.Ort;

@RepositoryRestResource(path = "orte", collectionResourceRel = "orte", itemResourceRel = "ort")
public interface OrtRepoDBBase extends CrudRepository<Ort, UUID> {
}
