package com.zenza.et.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Deni(
    val amount: BigDecimal,
    val debtor: String,
    val status: Int,
    val disburseDate: LocalDateTime,
    @PrimaryKey val id: Int? = null
)
