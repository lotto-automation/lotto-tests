package pages

class RegistrationPage extends AbstractPage {

  static at = { orderPrice() }

  static content = {

    orderPrice(wait: 15) { $('#ContentPlaceHolder1_totalresultareatext1') }
    totalPaymnet { $('#ContentPlaceHolder1_TotalPayment') }
    dicount { $('#ContentPlaceHolder1_totalresultareatext3') }

  }

}
