package pages.lottery

import geb.navigator.Navigator
import pages.AbstractPage

class AbstractLotteryPage extends AbstractPage {

  static at = { rootElement() }

  static content = {

    rootElement(wait: 'pageAtElements') { $('#ContentPlaceHolder1_line1') }
    quickPickAll { $('#ContentPlaceHolder1_Label257') }
    continueButton { $('#ContentPlaceHolder1_continue_single') }
    bonusMoney { $('#ContentPlaceHolder1_Label236') }
    pageInfo { $('#ContentPlaceHolder1_lblPageInfoTitle') }

    // Prices
    totalPrice { $('#totalcosttextsingle') }
    summaryBonusPrice { $('#summaryofbonusmoney') } // totalPrice should be the same as summaryBonusPrice
    priceWithoutDisc { $('#personalResultWithoutDisc') }
    discount { $('#personalDisc') }

    // Draws
    multiDrawCheckbox { $('#rb_multi_draw_single') }
    drawDropDown { $('#selectedlotterydrawnum') }
    twoDraws { $('#Label236c_2') }
    fourDraws { $('#Label236c_4') }
    eightDraws { $('#Label236_8') }
    twentySixDraws { $('#Label236_26') }
    fiftyTwoDraws { $('#Label236_52') }

  }

  List<Navigator> getAllDraws() {
    [ twoDraws, fourDraws, eightDraws, twentySixDraws, fiftyTwoDraws ]
  }

}
