package victorinno.com.github.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Photo(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,
        var name: String,
        var url: String
)