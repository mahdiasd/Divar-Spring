package com.divar.spring.utils.provider

import com.divar.spring.core.category.entity.Category
import com.divar.spring.core.location.entity.City
import com.divar.spring.core.location.entity.Neighborhood
import com.divar.spring.core.location.entity.Province

object LocationDataProvider {


    fun getData(): Triple<List<Province>, List<City>, List<Neighborhood>> {
        // Create prov inces
        val provinces = listOf(

            Province(id = 1, name = "تهران"),
            Province(id = 2, name = "البرز"),
            Province(id = 3, name = "اصفهان"),
            Province(id = 4, name = "خراسان رضوی"),
            Province(id = 5, name = "فارس"),
            Province(id = 6, name = "آذربایجان شرقی"),
            Province(id = 7, name = "خوزستان"),
            Province(id = 8, name = "گیلان"),
            Province(id = 9, name = "مازندران"),
            Province(id = 10, name = "سیستان و بلوچستان")
        )

        // Create cities
        val cities = listOf(
            City(id = 1, name = "تهران", province = provinces[0]),
            City(id = 2, name = "اسلامشهر", province = provinces[0]),
            City(id = 3, name = "ورامین", province = provinces[0]),
            City(id = 4, name = "کرج", province = provinces[1]),
            City(id = 5, name = "نظرآباد", province = provinces[1]),
            City(id = 6, name = "ساوجبلاغ", province = provinces[1]),
            City(id = 7, name = "اصفهان", province = provinces[2]),
            City(id = 8, name = "کاشان", province = provinces[2]),
            City(id = 9, name = "نجف‌آباد", province = provinces[2]),
            City(id = 10, name = "مشهد", province = provinces[3]),
            City(id = 11, name = "نیشابور", province = provinces[3]),
            City(id = 12, name = "سبزوار", province = provinces[3]),
            City(id = 13, name = "شیراز", province = provinces[4]),
            City(id = 14, name = "مرودشت", province = provinces[4]),
            City(id = 15, name = "کازرون", province = provinces[4]),
            City(id = 16, name = "تبریز", province = provinces[5]),
            City(id = 17, name = "مراغه", province = provinces[5]),
            City(id = 18, name = "مرند", province = provinces[5]),
            City(id = 19, name = "اهواز", province = provinces[6]),
            City(id = 20, name = "آبادان", province = provinces[6]),
            City(id = 21, name = "دزفول", province = provinces[6]),
            City(id = 22, name = "رشت", province = provinces[7]),
            City(id = 23, name = "انزلی", province = provinces[7]),
            City(id = 24, name = "لاهیجان", province = provinces[7]),
            City(id = 25, name = "ساری", province = provinces[8]),
            City(id = 26, name = "بابل", province = provinces[8]),
            City(id = 27, name = "آمل", province = provinces[8]),
            City(id = 28, name = "زاهدان", province = provinces[9]),
            City(id = 29, name = "چابهار", province = provinces[9]),
            City(id = 30, name = "ایرانشهر", province = provinces[9])
        )

        // Create neighborhoods
        val neighborhoods = listOf(
            // Tehran neighborhoods
            Neighborhood(id = 1, name = "ولیعصر", city = cities[0]),
            Neighborhood(id = 2, name = "تجریش", city = cities[0]),
            Neighborhood(id = 3, name = "نیاوران", city = cities[0]),
            Neighborhood(id = 4, name = "شهرک گلستان", city = cities[1]),
            Neighborhood(id = 5, name = "شهرک آزادی", city = cities[1]),
            Neighborhood(id = 6, name = "میدان نماز", city = cities[1]),
            Neighborhood(id = 7, name = "قاسم‌آباد", city = cities[2]),
            Neighborhood(id = 8, name = "پاکدشت", city = cities[2]),
            Neighborhood(id = 9, name = "جوادیه", city = cities[2]),
            // Karaj neighborhoods
            Neighborhood(id = 10, name = "گلشهر", city = cities[3]),
            Neighborhood(id = 11, name = "عظیمیه", city = cities[3]),
            Neighborhood(id = 12, name = "گوهردشت", city = cities[3]),
            Neighborhood(id = 13, name = "نظرآباد قدیم", city = cities[4]),
            Neighborhood(id = 14, name = "شهرک صنعتی", city = cities[4]),
            Neighborhood(id = 15, name = "ولیعصر", city = cities[4]),
            Neighborhood(id = 16, name = "شهرک ساوجبلاغ", city = cities[5]),
            Neighborhood(id = 17, name = "اشتهارد", city = cities[5]),
            Neighborhood(id = 18, name = "هشتگرد", city = cities[5]),
            // Isfahan neighborhoods
            Neighborhood(id = 19, name = "جلفا", city = cities[6]),
            Neighborhood(id = 20, name = "ملک‌شهر", city = cities[6]),
            Neighborhood(id = 21, name = "سپاهان‌شهر", city = cities[6]),
            Neighborhood(id = 22, name = "فین", city = cities[7]),
            Neighborhood(id = 23, name = "قمصر", city = cities[7]),
            Neighborhood(id = 24, name = "نیاسر", city = cities[7]),
            Neighborhood(id = 25, name = "ویلاشهر", city = cities[8]),
            Neighborhood(id = 26, name = "کهریزسنگ", city = cities[8]),
            Neighborhood(id = 27, name = "گلپایگان", city = cities[8]),
            // Mashhad neighborhoods
            Neighborhood(id = 28, name = "کوهسنگی", city = cities[9]),
            Neighborhood(id = 29, name = "احمدآباد", city = cities[9]),
            Neighborhood(id = 30, name = "طرقبه", city = cities[9]),
            Neighborhood(id = 31, name = "کوهسنگی", city = cities[10]),
            Neighborhood(id = 32, name = "عطار", city = cities[10]),
            Neighborhood(id = 33, name = "شهرک فرهنگیان", city = cities[10]),
            Neighborhood(id = 34, name = "طوس", city = cities[11]),
            Neighborhood(id = 35, name = "خیام", city = cities[11]),
            Neighborhood(id = 36, name = "اسدی", city = cities[11]),
            // Shiraz neighborhoods
            Neighborhood(id = 37, name = "قصرالدشت", city = cities[12]),
            Neighborhood(id = 38, name = "ستارخان", city = cities[12]),
            Neighborhood(id = 39, name = "عفیف‌آباد", city = cities[12]),
            Neighborhood(id = 40, name = "مرودشت قدیم", city = cities[13]),
            Neighborhood(id = 41, name = "شهرک صدرا", city = cities[13]),
            Neighborhood(id = 42, name = "ولیعصر", city = cities[13]),
            Neighborhood(id = 43, name = "قائمیه", city = cities[14]),
            Neighborhood(id = 44, name = "کازرون جدید", city = cities[14]),
            Neighborhood(id = 45, name = "بخش مرکزی", city = cities[14]),
            // Tabriz neighborhoods
            Neighborhood(id = 46, name = "ولیعصر", city = cities[15]),
            Neighborhood(id = 47, name = "شهناز", city = cities[15]),
            Neighborhood(id = 48, name = "چایکنار", city = cities[15]),
            Neighborhood(id = 49, name = "قپان", city = cities[16]),
            Neighborhood(id = 50, name = "قدیمی", city = cities[16]),
            Neighborhood(id = 51, name = "شهرک صنعتی", city = cities[16]),
            Neighborhood(id = 52, name = "شهرک مرند", city = cities[17]),
            Neighborhood(id = 53, name = "مرند قدیم", city = cities[17]),
            Neighborhood(id = 54, name = "مرند جدید", city = cities[17]),
            // Ahvaz neighborhoods
            Neighborhood(id = 55, name = "کوی انقلاب", city = cities[18]),
            Neighborhood(id = 56, name = "کوی ملت", city = cities[18]),
            Neighborhood(id = 57, name = "گلستان", city = cities[18]),
            Neighborhood(id = 58, name = "بریم", city = cities[19]),
            Neighborhood(id = 59, name = "ذوالفقاری", city = cities[19]),
            Neighborhood(id = 60, name = "ولیعصر", city = cities[19]),
            Neighborhood(id = 61, name = "شهرک دزفول", city = cities[20]),
            Neighborhood(id = 62, name = "شهرک قدیم", city = cities[20]),
            Neighborhood(id = 63, name = "شهرک جدید", city = cities[20]),
            // Rasht neighborhoods
            Neighborhood(id = 64, name = "معلم", city = cities[21]),
            Neighborhood(id = 65, name = "پیربازار", city = cities[21]),
            Neighborhood(id = 66, name = "گلسار", city = cities[21]),
            Neighborhood(id = 67, name = "آبکنار", city = cities[22]),
            Neighborhood(id = 68, name = "کوهی", city = cities[22]),
            Neighborhood(id = 69, name = "شهرک صنعتی", city = cities[22]),
            Neighborhood(id = 70, name = "سیمبر", city = cities[23]),
            Neighborhood(id = 71, name = "سیمبر قدیم", city = cities[23]),
            Neighborhood(id = 72, name = "سیمبر جدید", city = cities[23]),
            // Sari neighborhoods
            Neighborhood(id = 73, name = "بلوار کشاورز", city = cities[24]),
            Neighborhood(id = 74, name = "هولا", city = cities[24]),
            Neighborhood(id = 75, name = "معلم", city = cities[24]),
            Neighborhood(id = 76, name = "زرگرمحله", city = cities[25]),
            Neighborhood(id = 77, name = "بهنمیر", city = cities[25]),
            Neighborhood(id = 78, name = "شهرک صنعتی", city = cities[25]),
            Neighborhood(id = 79, name = "پل سفید", city = cities[26]),
            Neighborhood(id = 80, name = "شیرگاه", city = cities[26]),
            Neighborhood(id = 81, name = "زاغمرز", city = cities[26]),
            // Zahedan neighborhoods
            Neighborhood(id = 82, name = "بلوار امیرکبیر", city = cities[27]),
            Neighborhood(id = 83, name = "شهرک امام", city = cities[27]),
            Neighborhood(id = 84, name = "حافظ", city = cities[27]),
            Neighborhood(id = 85, name = "شهرک صنعت", city = cities[28]),
            Neighborhood(id = 86, name = "بندر کنارک", city = cities[28]),
            Neighborhood(id = 87, name = "خیابان ساحلی", city = cities[28]),
            Neighborhood(id = 88, name = "محمدان", city = cities[29]),
            Neighborhood(id = 89, name = "بزمان", city = cities[29]),
            Neighborhood(id = 90, name = "شهرک صنعتی", city = cities[29])
        )

        return Triple(provinces, cities, neighborhoods)
    }


}