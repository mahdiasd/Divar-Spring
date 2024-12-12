package com.divar.spring.core.image.service

import com.divar.spring.core.ads.entity.Ads
import com.divar.spring.core.image.entity.Image
import com.divar.spring.core.image.repository.ImageRepository
import com.divar.spring.core.location.entity.City
import com.divar.spring.core.location.entity.Province
import com.divar.spring.core.location.repository.CityRepository
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import kotlin.io.path.pathString

@Service
class ImageService(
    val repository: ImageRepository
) {
    private val uploadDir = "uploads/"

    init {
        val dir = File(uploadDir)
        if (!dir.exists())
            dir.mkdirs() // create folder id not exist.
    }

    fun save(file: MultipartFile, ads: Ads): Image {
        val filePath = Paths.get("$uploadDir${System.currentTimeMillis()}_${file.originalFilename}")
        Files.copy(file.inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
        val image = Image(path = filePath.pathString, ads = ads)

        return repository.save(image)
    }

    fun saveAll(files: List<MultipartFile>, ads: Ads): List<Image> {
        val images: MutableList<Image> = mutableListOf()
        files.forEach { file ->
            val filePath = Paths.get("$uploadDir${System.currentTimeMillis()}_${file.originalFilename}")
            Files.copy(file.inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
            images.add(Image(path = filePath.pathString, ads = ads))
        }
        return repository.saveAll(images)
    }
}