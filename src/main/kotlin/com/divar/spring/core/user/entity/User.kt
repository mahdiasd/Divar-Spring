    package com.divar.spring.core.user.entity

    import jakarta.persistence.Entity
    import jakarta.persistence.GeneratedValue
    import jakarta.persistence.GenerationType
    import jakarta.persistence.Id
    import org.hibernate.annotations.CreationTimestamp
    import org.hibernate.annotations.UpdateTimestamp
    import java.time.Instant

    @Entity(name = "user")
    data class User(

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        val name: String,

        val family: String,

        val email: String,

        val password: String,

        val mobile: String,

        @CreationTimestamp
        val createAt: Instant? = null,

        @UpdateTimestamp
        val updatedAt: Instant? = null
    )
