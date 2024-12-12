package com.divar.spring.utils.provider

import com.divar.spring.core.category.entity.Category

object CategoryDataProvider {

    private const val IconFolder = "category_icons"

    fun getData(): List<Category> {
        val list: MutableList<Category> = mutableListOf()
        val c1 = Category(id = 1, name = "املاک", icon = "${IconFolder}/ic_real_state.svg").apply { list.add(this) }
        val c2 = Category(id = 2, name = "وسایل نقلیه", icon = "${IconFolder}/ic_vehicles.svg").apply { list.add(this) }
        val c3 = Category(id = 3, name = "کالای دیجیتال", icon = "${IconFolder}/ic_digital_goods.svg").apply { list.add(this) }
        val c4 = Category(id = 4, name = "خدمات", icon = "${IconFolder}/ic_services.svg").apply { list.add(this) }
        val c5 = Category(id = 5, name = "وسایل شخصی", icon = "${IconFolder}/ic_personal_items.svg").apply { list.add(this) }

        Category(id = 6, name = "فروش مسکونی", parent = c1).apply {
            list.add(this)
            Category(id = 7, name = "آپارتمان", parent = this).apply { list.add(this) }
            Category(id = 8, name = "خانه و ویلا", parent = this).apply { list.add(this) }
            Category(id = 9, name = "زمین کلنگی", parent = this).apply { list.add(this) }
        }

        Category(id = 10, name = "اجاره مسکونی", parent = c1).apply {
            list.add(this)
            Category(id = 11, name = "آپارتمان", parent = this).apply { list.add(this) }
            Category(id = 12, name = "خانه و ویلا", parent = this).apply { list.add(this) }
        }

        Category(id = 13, name = "اجاره اداری و تجاری", parent = c1).apply {
            list.add(this)
            Category(id = 14, name = "دفتر کار، اتاق اداری و مطب", parent = this).apply { list.add(this) }
            Category(id = 15, name = "مغازه و غرفه", parent = this).apply { list.add(this) }
            Category(id = 16, name = "صنعتی، کشاورزی و تجاری", parent = this).apply { list.add(this) }
        }

        Category(id = 17, name = "اجاره کوتاه مدت", parent = c1).apply {
            list.add(this)
            Category(id = 18, name = "آپارتمان و سوئیت", parent = this).apply { list.add(this) }
            Category(id = 19, name = "ویلا و باغ", parent = this).apply { list.add(this) }
            Category(id = 20, name = "دفتر کار و فضای آموزشی", parent = this).apply { list.add(this) }
        }

        Category(id = 21, name = "پروژه‌های ساخت و ساز", parent = c1).apply {
            list.add(this)
            Category(id = 22, name = "مشارکت در ساخت", parent = this).apply { list.add(this) }
            Category(id = 23, name = "پیش‌فروش", parent = this).apply { list.add(this) }
        }

        Category(id = 24, name = "فروش اداری و تجاری", parent = c1).apply {
            list.add(this)
            Category(id = 25, name = "دفتر کار، اتاق اداری و مطب", parent = this).apply { list.add(this) }
            Category(id = 26, name = "مغازه و غرفه", parent = this).apply { list.add(this) }
            Category(id = 27, name = "صنعتی، کشاورزی و تجاری", parent = this).apply { list.add(this) }
        }

        // New categories based on the second image
        Category(id = 28, name = "موبایل و تبلت", parent = c3).apply {
            list.add(this)
            Category(id = 29, name = "گوشی موبایل", parent = this).apply { list.add(this) }
            Category(id = 30, name = "تبلت", parent = this).apply { list.add(this) }
            Category(id = 31, name = "لوازم جانبی موبایل و تبلت", parent = this).apply { list.add(this) }
            Category(id = 32, name = "سیم کارت", parent = this).apply { list.add(this) }
        }

        Category(id = 33, name = "رایانه", parent = c3).apply {
            list.add(this)
            Category(id = 34, name = "رایانه همراه", parent = this).apply { list.add(this) }
            Category(id = 35, name = "رایانه رومیزی", parent = this).apply { list.add(this) }
            Category(id = 36, name = "قطعات و لوازم جانبی", parent = this).apply { list.add(this) }
            Category(id = 37, name = "مودم و تجهیزات شبکه", parent = this).apply { list.add(this) }
            Category(id = 38, name = "پرینتر، اسکنر، کپی، فکس", parent = this).apply { list.add(this) }
        }

        Category(id = 39, name = "صوتی و تصویری", parent = c3).apply {
            list.add(this)
            Category(id = 40, name = "فیلم و موسیقی", parent = this).apply { list.add(this) }
            Category(id = 41, name = "دوربین عکاسی و فیلمبرداری", parent = this).apply { list.add(this) }
            Category(id = 42, name = "پخش کننده همراه", parent = this).apply { list.add(this) }
            Category(id = 43, name = "سیستم صوتی خانگی", parent = this).apply { list.add(this) }
            Category(id = 44, name = "ویدئو و پخش کننده DVD", parent = this).apply { list.add(this) }
            Category(id = 45, name = "تلویزیون و پروژکتور", parent = this).apply { list.add(this) }
            Category(id = 46, name = "دوربین مداربسته", parent = this).apply { list.add(this) }
        }

        Category(id = 47, name = "تلفن رومیزی", parent = c3).apply { list.add(this) }
        Category(id = 48, name = "کنسول، بازی ویدیویی و آنلاین", parent = c3).apply { list.add(this) }

        return list
    }


}