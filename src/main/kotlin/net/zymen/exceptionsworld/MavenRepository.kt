package net.zymen.exceptionsworld

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MavenRepositoryInfo (
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var url: String = ""
)

fun main(args: Array<String>) {
    println("Hello world")
}