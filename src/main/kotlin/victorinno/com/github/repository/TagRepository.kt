package victorinno.com.github.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import victorinno.com.github.data.Tag

@Repository
interface TagRepository : CrudRepository<Tag, Long>