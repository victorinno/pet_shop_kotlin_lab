package victorinno.com.github.repository

import io.micronaut.data.jpa.repository.JpaRepository
import victorinno.com.github.data.Order

interface CategoryRepository: JpaRepository<Order, Long> {}