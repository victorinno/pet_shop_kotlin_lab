package victorinno.com.github.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import victorinno.com.github.data.Order

@Repository
interface OerderRepository : JpaRepository<Order, Long> {}