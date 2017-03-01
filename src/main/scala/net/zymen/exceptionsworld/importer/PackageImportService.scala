package net.zymen.exceptionsworld.importer

import net.zymen.exceptionsworld.models.PackageInfo
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service

import scala.xml.XML

@Service
class PackageImportService {

  val log: Logger = LoggerFactory.getLogger(getClass)

  def run(urlBuilder: () => String) : Unit = {
    val url = urlBuilder()

    log.info(s"Downloading '$url'")

    val xmlData = XML.loadFile("/tmp/archetype-catalog.xml")

    //val xmlData = Source.fromURL("https://repo.maven.apache.org/maven2/archetype-catalog.xml")


   // val xmlData = Source.fromFile("/tmp/archetype-catalog.xml")
    val content = xmlData \\ "archetype"

    for(archetype <- content) {
      val packageInfo = new PackageInfo(
        (archetype \\ "artifactId").text,
        (archetype \\ "groupId").text,
        (archetype \\ "version").text
      )
      println(archetype)
      //packageInfo.setArtifactId( archetype. \ "artifactId" )
    }
  }
}