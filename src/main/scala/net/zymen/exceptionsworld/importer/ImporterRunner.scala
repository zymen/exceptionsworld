package net.zymen.exceptionsworld.importer

import org.springframework.boot.SpringApplication

object ImporterRunner {
  def main(args: Array[String]): Unit = {
    SpringApplication run classOf[ImporterCommandLine]
  }
}
