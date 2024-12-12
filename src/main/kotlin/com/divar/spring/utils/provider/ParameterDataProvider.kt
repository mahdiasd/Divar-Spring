package com.divar.spring.utils.provider

import com.divar.spring.core.category.entity.Category
import com.divar.spring.core.parameter.entity.DataType
import com.divar.spring.core.parameter.entity.Parameter

object ParameterDataProvider {

    private fun List<String>.toAcceptedString(): String {
        return this.joinToString(", ")
    }

    fun getParameters(categories: List<Category>): List<Parameter> {
        val list: MutableList<Parameter> = mutableListOf()

        categories.find { it.name == "املاک" }?.let {
            list.add(
                Parameter(
                    name = "متراژ", dataType = DataType.NumberInput, category = it,
                )
            )
            list.add(
                Parameter(
                    name = "تعداد اتاق",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("بدون اتاق", "یک", "دو", "سه", "چهار", "پنج و بیشتر").toAcceptedString(),
                    category = it
                )
            )
            list.add(
                Parameter(
                    name = "سال ساخت",
                    dataType = DataType.FixedOption,
                    acceptedOptions = mutableListOf<String>().apply {
                        for (i in 1403 downTo 1370) {
                            this.add("$i")
                        }
                        this.add("قبل از 1370")
                    }.toAcceptedString(),
                    category = it
                )
            )
            list.add(
                Parameter(
                    name = "طبقه",
                    dataType = DataType.FixedOption,
                    acceptedOptions = mutableListOf<String>().apply {
                        this.add("زیر همکف")
                        this.add("همکف")
                        for (i in 1..30) {
                            this.add("$i")
                        }
                        this.add("بالاتر از 30")
                    }.toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "آسانسور",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("دارد", "ندارد").toAcceptedString(),
                    category = it
                )
            )
            list.add(
                Parameter(
                    name = "پارکینگ",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("دارد", "ندارد").toAcceptedString(),
                    category = it
                )
            )
        }

        categories.find { it.name == "موبایل و تبلت" }?.let {
            list.add(Parameter(name = "برند و مدل", dataType = DataType.StringInput, category = it))
            list.add(
                Parameter(
                    name = "وضعیت",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("نو", "در حد نو", "کارکرده", "نیاز به تعمیر").toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "تعداد سیم کارت",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("3 و بیشتر", "1", "1", "").toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "اصالت برند",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("اصل", "غیراصل").toAcceptedString(),
                    category = it
                )
            )

        }

        categories.find { it.name == "وسایل نقلیه" }?.let {
            list.add(Parameter(name = "برند و تیپ", dataType = DataType.StringInput, category = it))
            list.add(
                Parameter(
                    name = "مدل سال",
                    dataType = DataType.FixedOption,
                    acceptedOptions = mutableListOf<String>().apply {
                        for (i in 1403 downTo 1370) {
                            this.add("$i")
                        }
                        this.add("قبل از 1370")
                    }.toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "رنگ",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf(
                        "آبی",
                        "آلبالویی",
                        "اطلسی",
                        "بژ",
                        "بنفش",
                        "پوست پیازی",
                        "تیتانیوم",
                        "خاکستری",
                        "مشکی",
                        "سفید"
                    ).toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "وضعیت موتور",
                    dataType = DataType.FixedOption,
                    acceptedOptions = listOf("سالم", "نیاز به تعمیر", "تعویض شده").toAcceptedString(),
                    category = it
                )
            )

            list.add(
                Parameter(
                    name = "مایلم معاوضه کنم",
                    dataType = DataType.CheckBoxInput,
                    category = it
                )
            )


        }

        return list
    }


}