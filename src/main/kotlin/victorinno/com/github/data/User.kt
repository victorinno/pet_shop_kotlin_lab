package victorinno.com.github.data


import javax.persistence.*

@Entity
@Table(name = "pet_user")
data class User(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var username: String,
        var firstName: String,
        var lastName: String,
        var email: String,
        @Column(name = "userPassword")
        var password: String,
        var phone: String,
        var userStatus: Long
)