package victorinno.com.github.repository

import io.micronaut.data.jpa.repository.JpaRepository
import victorinno.com.github.data.Tag

interface TagRepository : JpaRepository<Tag, Long>