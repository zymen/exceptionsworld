package net.zymen.exceptionsworld.services;

import net.zymen.exceptionsworld.models.PackageInfo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
//import org.xeustechnologies.jcl.JarClassLoader;
//import org.xeustechnologies.jcl.JclObjectFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PackageAnalyzer {

    private static final Logger log = getLogger(PackageAnalyzer.class);

    public void analyzePackage(PackageInfo packageInfo) {
        log.info("Analyzing package {}", packageInfo);
//
//        JarClassLoader jarClassLoader = new JarClassLoader();
//        try {
//            jarClassLoader.add(new URL("https://repo.maven.apache.org/maven2/org/apache/maven/plugins/maven-compiler-plugin/3.6.0/maven-compiler-plugin-3.6.0.jar"));
//        } catch (MalformedURLException e) {
//            log.error("Error during class loading");
//        }
//
//        JclObjectFactory jclObjectFactory = JclObjectFactory.getInstance();
//
//        log.info("REsult {} ", jarClassLoader.getLoadedClasses());
    }
}
