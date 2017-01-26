package net.zymen.exceptionsworld.services;

import net.zymen.exceptionsworld.models.PackageClassInfo;
import net.zymen.exceptionsworld.repositories.PackageClassInfoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class PackageClassInfoService {

    Random r = new Random();

    private final PackageClassInfoRepository packageClassInfoRepository;

    public PackageClassInfoService(PackageClassInfoRepository packageClassInfoRepository) {
        this.packageClassInfoRepository = packageClassInfoRepository;
    }

    public List<PackageClassInfo> getTopPackageClassInfoList() {
        int random = r.nextInt();

        PackageClassInfo info = new PackageClassInfo();
        info.setFullClassName("net.zymen.alfa" + random);
        info.setPackageArtifactId("artifact_id" + random);
        info.setPackageGroupId("group_id" + random);
        info.setPackageVersion("version"+random);

        packageClassInfoRepository.save(info);

        return packageClassInfoRepository.findAll(new PageRequest(0, 10)).getContent();
    }

    public PackageClassInfo getOne(String packageClassInfoKey) {
        return packageClassInfoRepository.findOne(packageClassInfoKey);
    }
}
