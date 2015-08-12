package tests

import groovy.util.logging.Log4j
import org.junit.Test
import pages.RegistrationPage
import pages.lottery.AbstractLotteryPage
import pages.lottery.BonoLotoPage
import pages.lottery.ElGordoPage
import pages.lottery.EuroJackpotPage
import pages.lottery.EuroMillionsPage
import pages.lottery.LaPrimitivaPage
import pages.lottery.Lotto649Page
import pages.lottery.MegaMillionsPage
import pages.lottery.NewYorkLottoPage
import pages.lottery.PowerBallPage
import pages.lottery.SuperEnalottoPage
import pages.lottery.UkLottoPage

@Log4j
class OneTimePriceTests extends BaseTest {

  @Test
  void verifyPrice_LaPrimitive() {
    def laPrimitiva = to LaPrimitivaPage
    verifyPrice(laPrimitiva)
  }

  @Test
  void verifyPrice_PowerBall() {
    def powerBall = to PowerBallPage
    verifyPrice(powerBall)
  }

  @Test
  void verifyPrice_EuroMillions() {
    def euroMillions = to EuroMillionsPage
    verifyPrice(euroMillions)
  }

  @Test
  void verifyPrice_NewYorkLotto() {
    def newyYorkLotto = to NewYorkLottoPage
    verifyPrice(newyYorkLotto)
  }

  @Test
  void verifyPrice_MegaMillions() {
    def megaMillions = to MegaMillionsPage
    verifyPrice(megaMillions)
  }

  @Test
  void verifyPrice_EuroJackpot() {
    def euroJackpot = to EuroJackpotPage
    verifyPrice(euroJackpot)
  }

  @Test
  void verifyPrice_SuperEnalotto() {
    def superEnalotto = to SuperEnalottoPage
    verifyPrice(superEnalotto)
  }

  @Test
  void verifyPrice_Lotto649() {
    def lotto649 = to Lotto649Page
    verifyPrice(lotto649)
  }

  @Test
  void verifyPrice_ElGordo() {
    def elGordo = to ElGordoPage
    verifyPrice(elGordo)
  }

  @Test
  void verifyPrice_UkLotto() {
    def ukLotto = to UkLottoPage
    verifyPrice(ukLotto)
  }

  @Test
  void verifyPrice_BonoLoto() {
    def bonoLoto = to BonoLotoPage
    verifyPrice(bonoLoto)
  }

  void verifyPrice(AbstractLotteryPage page) {

    page.quickPickAll.click()
    sleep(2000)
    def price1 = Double.parseDouble(page.totalPrice.text().replaceAll("\\€", ''))
    def priceWithoutDisc = Double.parseDouble(page.priceWithoutDisc.text().replaceAll("\\€", ''))
    def bonusPrice = Double.parseDouble(page.summaryBonusPrice.text())

    assert price1 == priceWithoutDisc
    assert price1 == bonusPrice

    page.moveToElement('ContentPlaceHolder1_lblPageInfoTitle')

    page.continueButton().click()
    def registrationPage = at RegistrationPage
    def price2 = Double.parseDouble(registrationPage.orderPrice.text().replaceAll('\\€', ''))
    def totalPrice = Double.parseDouble(registrationPage.totalPaymnet.text().replaceAll('\\€', ''))

    assert price1 == price2
    assert price1 == totalPrice

    log.info("Ticket Price at ${page.class.name} is   ${priceWithoutDisc}")
    log.info("Bonus Price at ${page.class.name} is    ${bonusPrice}")
    log.info("Total Price at ${page.class.name} is    ${price1}")

    log.info("Ticket price at ${registrationPage.class.name} is          ${price2}")
    log.info("Total Price at ${registrationPage.class.name} is           ${totalPrice}")
    log.info('')
  }

}
