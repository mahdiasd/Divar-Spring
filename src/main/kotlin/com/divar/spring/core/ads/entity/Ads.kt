package com.divar.spring.core.ads.entity

import com.divar.spring.core.category.entity.Category
import com.divar.spring.core.image.entity.Image
import com.divar.spring.core.location.entity.Neighborhood
import com.divar.spring.core.parameter.entity.ParameterAnswer
import com.divar.spring.core.user.entity.User
import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity(name = "ads")
data class Ads(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    val title: String,

    val description: String,

    val price: String,

    @ManyToOne
    @JoinColumn(name = "neighborhood_id")
    val neighborhood: Neighborhood,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @ManyToOne
    @JoinColumn(name = "category_id")
    val category: Category,

    @OneToMany(mappedBy = "ads")
    val images: List<Image> = listOf(),

    @OneToMany(mappedBy = "ads")
    val answers: List<ParameterAnswer> = listOf(),

    @CreationTimestamp
    val createAt: Instant? = null,

    @UpdateTimestamp
    val updatedAt: Instant? = null,
)
