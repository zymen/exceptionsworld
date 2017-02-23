package net.zymen.exceptionsworld.repositories;

import net.zymen.exceptionsworld.models.PackageInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PackageInfoRepository extends PagingAndSortingRepository<PackageInfo, Long> {

    List<PackageInfo> findByIsAnalyzed(Boolean isAnalyzed, Pageable data);
}
