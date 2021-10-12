package dev.feryadi.bayu.model

import java.math.BigDecimal
import java.time.LocalDateTime

data class Transaction(
    var id: String,
    var name: String,
    var description: String,
    var date: LocalDateTime,
    var amount: BigDecimal
)
