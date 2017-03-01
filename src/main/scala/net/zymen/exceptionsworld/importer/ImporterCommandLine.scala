package net.zymen.exceptionsworld.importer

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ImporterCommandLine {

  @Bean
  def init(packageImportService: PackageImportService): CommandLineRunner = {
    return new CommandLineRunner {
      override def run(args: String*) = {
        packageImportService.run(() => "onet.pl")
      }
    }
  }
}
