package victorinno.com.github

import io.micronaut.runtime.Micronaut.*

fun main(args: Array<String>) {
    build()
            .args(*args)
            .packages("victorinno.com.github")
            .start()
}

