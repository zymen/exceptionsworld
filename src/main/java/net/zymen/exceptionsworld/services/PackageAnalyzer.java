package net.zymen.exceptionsworld.services;

import net.zymen.exceptionsworld.models.PackageInfo;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PackageAnalyzer {

    private static final Logger log = getLogger(PackageAnalyzer.class);

    public void analyzePackage(PackageInfo packageInfo) {
        log.info("Analyzing package {}", packageInfo);

        List<String> classNames = new ArrayList<>();
        ZipInputStream zip = null;

        try {
            try(InputStream data = new URL(packageInfo.getJarUrl()).openStream()) {
                zip = new ZipInputStream(data);
                for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) {
                    if (!entry.isDirectory() && entry.getName().endsWith(".class")) {
                        // This ZipEntry represents a class. Now, what class does it represent?
                        String className = entry.getName().replace('/', '.'); // including ".class"
                        classNames.add(className.substring(0, className.length() - ".class".length()));
                    }
                }
            }
        } catch (IOException e) {
            log.error("Error during analyzing package {}", packageInfo, e);
        }
    }
}
