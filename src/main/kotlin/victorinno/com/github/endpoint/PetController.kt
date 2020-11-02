package victorinno.com.github.endpoint

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.MutableHttpHeaders
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import victorinno.com.github.data.Pet
import victorinno.com.github.data.PetStatus
import victorinno.com.github.data.Tag
import victorinno.com.github.repository.PetRepository
import victorinno.com.github.repository.TagRepository
import java.net.URI
import javax.inject.Inject
import javax.validation.Valid
import javax.ws.rs.FormParam
import javax.ws.rs.Path
import javax.ws.rs.PathParam

@Controller("/pet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
open class PetController {

    @Inject
    lateinit var petRepository: PetRepository

    @Inject
    lateinit var tagRepository: TagRepository

    @Post
    open fun save(@Body @Valid pet: Pet): MutableHttpResponse<Any>? {
        val petSaved = petRepository.save(pet)
        return HttpResponse
                .created<Any>(petSaved)
                .headers { headers: MutableHttpHeaders -> headers.location(location(petSaved.id)) }
    }

    @Put
    open fun update(@Body @Valid pet: Pet): MutableHttpResponse<Any>? {
        val petSaved = petRepository.update(pet)
        return HttpResponse
                .created<Any>(petSaved)
                .headers { headers: MutableHttpHeaders -> headers.location(location(petSaved.id)) }
    }

    @Delete
    @Path("/{id}")
    fun delete(@PathParam("id") id: Long): MutableHttpResponse<Any>? {
        petRepository.deleteById(id)
        return return HttpResponse.noContent()
    }

    @Post
    @Path("/{id}")
    fun updateNameStatus(@PathParam("id") id: Long, @FormParam("name") name: String, @FormParam("status") status: PetStatus): MutableHttpResponse<Any>? {
        val pet = petRepository.findById(id)
        pet.name = name
        pet.status = status
        val petSaved = petRepository.update(pet)
        return HttpResponse
                .created<Any>(petSaved)
                .headers { headers: MutableHttpHeaders -> headers.location(location(petSaved.id)) }
    }

    protected fun location(id: Long): URI? {
        return URI.create("/pet/$id")
    }

    protected fun location(pet: Pet): URI? {
        return location(pet.id)
    }

    @Get
    @Path("/tags")
    fun findAlltags(): MutableIterable<Tag> {
        return tagRepository.findAll()
    }
}