package thk.fae.urd.lh.repo;

import java.util.List;
import thk.fae.urd.lh.model.HistoricalLocation;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface HistoricalLocationRepository extends CrudRepository<HistoricalLocation, Long> {
    List<HistoricalLocation> findAllByDvpId(long dvpId);
}
