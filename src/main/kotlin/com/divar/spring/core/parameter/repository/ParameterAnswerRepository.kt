package com.divar.spring.core.parameter.repository

import com.divar.spring.core.parameter.entity.ParameterAnswer
import org.springframework.data.jpa.repository.JpaRepository

interface ParameterAnswerRepository : JpaRepository<ParameterAnswer, Long> {
}