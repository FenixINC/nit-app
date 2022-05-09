package com.example.feature_home

import androidx.compose.ui.graphics.Color
import java.util.*

fun getFakeHomeData(): HomeModel {
    return HomeModel(
        balanceModel = BalanceModel(balance = "$ 7,896"),
        cardList = mutableListOf(
            CardModel(
                id = UUID.randomUUID().toString(),
                type = "VISA",
                moneyType = "Salary",
                moneyAmount = "$ 2,230",
                number = "4263 9826 4026 9299",
                holderName = "Margo Lepski",
                date = "12/22",
                cvvCode = "123",
                backgroundColor = Color(color = 0xFFFCFFDF)
            ),
            CardModel(
                id = UUID.randomUUID().toString(),
                type = "VISA",
                moneyType = "Salary",
                moneyAmount = "$ 2,230",
                number = "4263 9826 4026 9299",
                holderName = "Margo Lepski",
                date = "12/22",
                cvvCode = "123",
                backgroundColor = Color(color = 0xFFB2D0CE)
            ),
            CardModel(
                id = UUID.randomUUID().toString(),
                type = "VISA",
                moneyType = "Salary",
                moneyAmount = "$ 2,230",
                number = "4263 9826 4026 9299",
                holderName = "Margo Lepski",
                date = "12/22",
                cvvCode = "123",
                backgroundColor = Color(color = 0xFFFCFFDF)
            ),
            CardModel(
                id = UUID.randomUUID().toString(),
                type = "VISA",
                moneyType = "Salary",
                moneyAmount = "$ 2,230",
                number = "4263 9826 4026 9299",
                holderName = "Margo Lepski",
                date = "12/22",
                cvvCode = "123",
                backgroundColor = Color(color = 0xFFB2D0CE)
            )
        ),
        expandableList = mutableListOf(
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.CARD,
                expandType = ExpandType.LOANS,
                title = "Account № 3874825",
                description = "Expires 12/22/2023",
                image = R.drawable.image_account_loans,
                moneyAmount = "$ 78,92",
                rate = "Rate 3.5%"
            ),
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.CARD,
                expandType = ExpandType.LOANS,
                title = "Account № 3874825",
                description = "Expires 12/22/2023",
                image = R.drawable.image_account_loans,
                moneyAmount = "$ 78,92",
                rate = "Rate 3.5%"
            ),
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.CARD,
                expandType = ExpandType.LOANS,
                title = "Account № 3874825",
                description = "Expires 12/22/2023",
                image = R.drawable.image_account_loans,
                moneyAmount = "$ 78,92",
                rate = "Rate 3.5%"
            ),
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.INFO,
                expandType = ExpandType.LOANS,
                title = "Start investing now!",
                description = "Protected savings and investment plans",
                image = R.drawable.image_start_investing
            ),
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.CARD,
                expandType = ExpandType.LOANS,
                title = "Account № 3874825",
                description = "Expires 12/22/2023",
                image = R.drawable.image_account_loans,
                moneyAmount = "$ 78,92",
                rate = "Rate 3.5%"
            ),
            LoanModel(
                id = UUID.randomUUID().toString(),
                loanType = LoanType.INFO,
                expandType = ExpandType.LOANS,
                title = "Start investing now!",
                description = "Protected savings and investment plans",
                image = R.drawable.image_start_investing
            ),
            CurrenciesModel(
                id = UUID.randomUUID().toString(),
                expandType = ExpandType.CURRENCY,
                currency = "USD",
                icon = R.drawable.ic_dollar,
                buy = "$ 78,92",
                sell = "$ 78,92"
            ),
            CurrenciesModel(
                id = UUID.randomUUID().toString(),
                expandType = ExpandType.CURRENCY,
                currency = "EUR",
                icon = R.drawable.ic_euro,
                buy = "$ 78,92",
                sell = "$ 78,92"
            )
        ),
        metalList = mutableListOf(
            MetalModel(
                id = UUID.randomUUID().toString(),
                metal = "Gold",
                icon = R.drawable.ic_metal,
                buy = "$ 78,92",
                sell = "$ 78,92"
            ),
            MetalModel(
                id = UUID.randomUUID().toString(),
                metal = "Gold",
                icon = R.drawable.ic_metal,
                buy = "$ 78,92",
                sell = "$ 78,92"
            )
        )
    )
}

data class HomeModel(
    val balanceModel: BalanceModel = BalanceModel(),
    val cardList: List<CardModel> = mutableListOf(),
    val expandableList: List<Expandable> = mutableListOf(),
    val metalList: List<MetalModel> = mutableListOf()
)

data class BalanceModel(
    val balance: String = ""
)

data class CardModel(
    val id: String = "",
    val type: String = "",
    val moneyType: String = "",
    val moneyAmount: String = "",
    val number: String = "",
    val holderName: String = "",
    val date: String = "",
    val cvvCode: String = "",
    val backgroundImage: Int = -1,
    val backgroundColor: Color = Color(color = 0xFFFFFFFF)
)

data class LoanModel(
    override val id: String = "",
    override val expandType: ExpandType,
    val loanType: LoanType,
    val image: Int = -1,
    val title: String = "",
    val description: String = "",
    val moneyAmount: String = "",
    val rate: String = ""
) : Expandable

enum class LoanType {
    CARD,
    INFO
}

data class CurrenciesModel(
    override val id: String = "",
    override val expandType: ExpandType,
    val currency: String = "",
    val icon: Int = -1,
    val buy: String = "",
    val sell: String = ""
) : Expandable

data class MetalModel(
    val id: String = "",
    val metal: String = "",
    val icon: Int = -1,
    val buy: String = "",
    val sell: String = ""
)