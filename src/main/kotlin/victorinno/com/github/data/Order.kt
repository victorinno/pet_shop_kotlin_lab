package victorinno.com.github.data


import java.time.LocalDate
import javax.persistence.*

enum class OrderStatus {
    PLACED, APPROVED, DELIVERED
}

@Entity
@Table(name = "pet_order")
data class Order(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long,
        var petId: Long,
        var quantity: Long,
        var shipDate: LocalDate,
        var status: OrderStatus,
        var complete: Boolean
)