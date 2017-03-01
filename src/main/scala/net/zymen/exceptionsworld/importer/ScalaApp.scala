package net.zymen.exceptionsworld.importer

object ScalaApp {

  def main(args: Array[String]): Unit = {
    val importer = new PackageImportService()
    importer.run(() => "onet.pl")
  }

}
