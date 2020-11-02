package victorinno.com.github.data

import javax.persistence.*

enum class PetStatus{
        AVAILABLE, PENDING, SOLD
}

@Entity
data class Pet(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,
        var status: PetStatus,
        @OneToMany(cascade = [CascadeType.ALL])
        var tags: List<Tag>,
        @OneToMany(cascade = [CascadeType.ALL])
        var photoUrls: List<Photo>

)