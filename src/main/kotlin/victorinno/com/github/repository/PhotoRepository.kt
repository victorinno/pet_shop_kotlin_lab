package victorinno.com.github.repository

import io.micronaut.data.jpa.repository.JpaRepository
import victorinno.com.github.data.Photo

interface PhotoRepository : JpaRepository<Photo, Long>