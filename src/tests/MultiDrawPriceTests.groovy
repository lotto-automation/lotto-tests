package tests

import geb.navigator.Navigator
import groovy.util.logging.Log4j
import org.junit.Test
import pages.RegistrationPage
import pages.lottery.AbstractLotteryPage
import pages.lottery.LaPrimitivaPage

@Log4j
class MultiDrawPriceTests extends BaseTest {

  @Test
  void verifyPriceAndDiscount_MultiDraw_LaPrimitive() {
    def laPrimitiva = to LaPrimitivaPage
    verifyPriceAndDiscount(laPrimitiva, laPrimitiva.twoDraws)
    verifyPriceAndDiscount(laPrimitiva, laPrimitiva.fourDraws)
    verifyPriceAndDiscount(laPrimitiva, laPrimitiva.eightDraws)
    verifyPriceAndDiscount(laPrimitiva, laPrimitiva.twentySixDraws)
    verifyPriceAndDiscount(laPrimitiva, laPrimitiva.fiftyTwoDraws)
  }

  void verifyPriceAndDiscount(AbstractLotteryPage page, Navigator element) {

    page.quickPickAll.click()
    sleep(2000)
    page.multiDrawCheckbox.click()
    page.moveToElement('selectedlotterydrawnum')
    element.click()
    sleep(1000)
    def totalPriceWithDiscount1 = Double.parseDouble(page.totalPrice.text().replaceAll("\\€", ''))
    def priceWithoutDisc1 = Double.parseDouble(page.priceWithoutDisc.text().replaceAll("\\€", ''))
    def bonusPriceWithDiscount = Double.parseDouble(page.summaryBonusPrice.text())
    def dicount1 = Double.parseDouble(page.discount.text().replaceAll("\\€", ''))

    assert totalPriceWithDiscount1 == priceWithoutDisc1 - dicount1
    assert totalPriceWithDiscount1 == bonusPriceWithDiscount

    page.moveToElement('ContentPlaceHolder1_lblPageInfoTitle')

    page.continueButton().click()
    def registrationPage = at RegistrationPage
    def priceWithouDisc2 = Double.parseDouble(registrationPage.orderPrice.text().replaceAll('\\€', ''))
    def totalPriceWithDiscount2 = Double.parseDouble(registrationPage.totalPaymnet.text().replaceAll('\\€', ''))
    def dicount2 = Double.parseDouble(registrationPage.dicount.text().replaceAll('- \\€', ''))

    assert totalPriceWithDiscount1 == totalPriceWithDiscount2
    assert priceWithoutDisc1 == priceWithouDisc2
    assert dicount1 == dicount2

    log.info("Ticket Price at ${page.class.name} is    ${priceWithoutDisc1}")
    log.info("Bonus Price at ${page.class.name} is     ${bonusPriceWithDiscount}")
    log.info("Total Price at ${page.class.name} is     ${totalPriceWithDiscount1}")
    log.info("Discount at ${page.class.name} is:       ${dicount1}")

    log.info("Ticket price at ${registrationPage.class.name} is          ${priceWithouDisc2}")
    log.info("Total Price at ${registrationPage.class.name} is           ${totalPriceWithDiscount2}")
    log.info("Discount at ${registrationPage.class.name} is              ${dicount2}")
    log.info('')

    to page.class
  }

}
