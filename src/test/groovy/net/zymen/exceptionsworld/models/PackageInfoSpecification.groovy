package net.zymen.exceptionsworld.models

import spock.lang.Specification

class PackageInfoSpecification extends Specification{

    def "should correctly build jar url" () {
        given:
        def packageInfo = new PackageInfo()
        packageInfo.artifactId = "mysql-connector-java"
        packageInfo.groupId = "mysql"
        packageInfo.version = "6.0.3"

        when:
        def jarUrl = packageInfo.getJarUrl()

        then:
        jarUrl.endsWith("/mysql/mysql-connector-java/6.0.3/mysql-connector-java-6.0.3.jar")
    }
}
