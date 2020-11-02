package victorinno.com.github.repository

import io.micronaut.transaction.annotation.ReadOnly
import victorinno.com.github.data.Pet
import javax.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.CriteriaQuery
import javax.persistence.criteria.Root
import javax.transaction.Transactional


@Singleton
open class PetRepository(@field:PersistenceContext val entityManager: EntityManager) {
    @Transactional
    open fun save(pet: Pet): Pet {
        return entityManager.merge(pet)
    }

    @Transactional
    open fun update(pet: Pet): Pet {
        return entityManager.merge(pet)
    }

    @Transactional
    open fun deleteById(id: Long) {
        val pet = findById(id)
        entityManager.remove(pet)
    }

    @ReadOnly
    open fun findById(id: Long): Pet {
        val cb: CriteriaBuilder = entityManager.criteriaBuilder
        val cr: CriteriaQuery<Pet> = cb.createQuery(Pet::class.java)
        val root: Root<Pet> = cr.from(Pet::class.java)
        cr.select(root).where(cb.gt(root.get("id"), id))
        val query: Query = entityManager.createQuery(cr)
        return query.singleResult as Pet
    }

}

