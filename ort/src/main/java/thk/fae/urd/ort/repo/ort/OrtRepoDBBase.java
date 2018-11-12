package thk.fae.urd.ort.repo.ort;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import thk.fae.urd.ort.domain.ort.Ort;

public interface OrtRepoDBBase extends CrudRepository<Ort, UUID> {
}
