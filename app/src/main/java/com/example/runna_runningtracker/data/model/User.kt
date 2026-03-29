package com.example.runna_runningtracker.data.model

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val age: String = "",
    val gender: String = "",
    val height: String = "",
    val weight: String = ""
) {
    // Chuyen model thanh map de ghi len Firestore
    fun toMap(): Map<String, String> {
        return mapOf(
            KEY_NAME to name,
            KEY_EMAIL to email,
            KEY_AGE to age,
            KEY_GENDER to gender,
            KEY_HEIGHT to height,
            KEY_WEIGHT to weight
        )
    }

    companion object {
        // Constant dung chung de tranh viet tay ten collection/field o nhieu noi.
        const val COLLECTION_USERS = "users"
        const val KEY_NAME = "name"
        const val KEY_EMAIL = "email"
        const val KEY_AGE = "age"
        const val KEY_GENDER = "gender"
        const val KEY_HEIGHT = "height"
        const val KEY_WEIGHT = "weight"

        fun fromMap(uid: String, data: Map<String, Any>?): User {
            // Doc tu Firestore: neu field nao thieu thi cho ve chuoi rong.
            return User(
                uid = uid,
                name = data?.get(KEY_NAME) as? String ?: "",
                email = data?.get(KEY_EMAIL) as? String ?: "",
                age = data?.get(KEY_AGE) as? String ?: "",
                gender = data?.get(KEY_GENDER) as? String ?: "",
                height = data?.get(KEY_HEIGHT) as? String ?: "",
                weight = data?.get(KEY_WEIGHT) as? String ?: ""
            )
        }
    }
}
