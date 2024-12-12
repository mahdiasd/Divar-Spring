package com.divar.spring.core.ads.repository

import com.divar.spring.core.ads.entity.Ads
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AdsRepository : JpaRepository<Ads, Long> {
    fun findAllByCategoryId(id: Long, pageable: Pageable): Page<Ads>


    @Query(
        """
           SELECT c.name, c.id, COUNT(a.id),
            SUBSTRING(
                MIN(a.title),
                LOCATE(:searchText, MIN(a.title)),
                CASE WHEN LOCATE(' ', MIN(a.title), LOCATE(:searchText, MIN(a.title))) > 0
                    THEN LOCATE(' ', MIN(a.title), LOCATE(:searchText, MIN(a.title)))
                    ELSE LENGTH(MIN(a.title)) - LOCATE(:searchText, MIN(a.title)) + 1
                END
            )
        FROM ads a
        JOIN a.category c
        JOIN a.neighborhood n
        JOIN n.city ci
        WHERE a.title LIKE %:searchText% AND ci.id = :cityId
        GROUP BY c.name
        """
    )
    fun findCategoriesWithAdsCount(
        @Param("searchText") searchText: String,
        @Param("cityId") cityId: Long
    ): List<Array<Any>>

    @Query(
        """
            SELECT DISTINCT a
            FROM ads a
            LEFT JOIN a.neighborhood n
            LEFT JOIN n.city c
            LEFT JOIN a.category cat
            LEFT JOIN a.answers ans
            LEFT JOIN ans.parameter param
            WHERE (:cityId IS NULL OR c.id = :cityId)
            AND (:categoryId IS NULL OR cat.id = :categoryId)
            AND (:title IS NULL OR LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%')))
            AND (:neighborhoodId IS NULL OR n.id = :neighborhoodId)
            AND (:minPrice IS NULL OR CAST(a.price as double)  >= :minPrice)
            AND (:maxPrice IS NULL OR CAST(a.price as double)  <= :maxPrice)
            AND (:answers IS NULL OR (ans.answer IN :answers And param.id IN :parametersIds))
        """
    )
    fun findAdsByFilter(
        @Param("title") title: String?,
        @Param("cityId") cityId: Long?,
        @Param("categoryId") categoryId: Long?,
        @Param("neighborhoodId") neighborhoodId: Long?,
        @Param("minPrice") minPrice: Double?,
        @Param("maxPrice") maxPrice: Double?,
        @Param("answers") answers: List<String>?,
        @Param("parametersIds") parametersIds: List<Long>?,
        pageable: Pageable
    ): Page<Ads>
}
