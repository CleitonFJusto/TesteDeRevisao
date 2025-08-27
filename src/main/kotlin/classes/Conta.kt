package classes

import java.math.BigDecimal

class Conta(
    val pessoa: Pessoa,//opcional
    var saldo : BigDecimal,
    val id : Long //numeroDaConta
)