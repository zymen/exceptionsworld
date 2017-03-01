package net.zymen.exceptionsworld.endpoints;

import net.zymen.exceptionsworld.MavenRepositoryInfo;
import net.zymen.exceptionsworld.MavenRepositoryInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/rest/mavenrepositoryinfo")
public class MavenRepositoryInfoEndpoint {

    private MavenRepositoryInfoRepository mavenRepositoryInfoRepository;

    @Autowired
    public MavenRepositoryInfoEndpoint(
            MavenRepositoryInfoRepository mavenRepositoryInfoRepository) {
        this.mavenRepositoryInfoRepository = mavenRepositoryInfoRepository;
    }

    Random r = new Random();

    @RequestMapping(method = RequestMethod.GET)
    public List<MavenRepositoryInfo> getListOfMavenRepositoryInfo() {
        MavenRepositoryInfo test = new MavenRepositoryInfo(r.nextInt(), "test-" + r.nextInt());
        mavenRepositoryInfoRepository.save(test);

        List<MavenRepositoryInfo> output = new LinkedList<>();

        mavenRepositoryInfoRepository
                .findAll()
                .forEach(output::add);

        return output;
    }

}
