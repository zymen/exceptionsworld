package net.zymen.exceptionsworld.services;

import net.zymen.exceptionsworld.models.PackageInfo;
import net.zymen.exceptionsworld.repositories.PackageInfoRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PackageAnalyzeScheduler {

    private static final Logger log = getLogger(PackageAnalyzeScheduler.class);

    private final PackageAnalyzer packageAnalyzer;
    private final PackageInfoRepository packageInfoRepository;

    @Autowired
    public PackageAnalyzeScheduler(PackageAnalyzer packageAnalyzer, PackageInfoRepository packageInfoRepository) {
        this.packageAnalyzer = packageAnalyzer;
        this.packageInfoRepository = packageInfoRepository;
    }

    @Scheduled(fixedDelay = 5000)
    public void analyzeWaitingPackages() {
        log.info("Processing not analyzed packages");

        List<PackageInfo> packageInfoList = packageInfoRepository.findByIsAnalyzed(false, new PageRequest(0, 5));

        packageInfoList.forEach(packageAnalyzer::analyzePackage);
    }
}
