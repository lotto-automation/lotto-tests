package pages

class HomePage extends AbstractPage {

  public static final String TITLE = 'Lottery Online – Prince Lotto, Buy Lottery Tickets Online!'

  static url = 'login'

  static at = {
    title.contains(TITLE)
    payLottery.displayed
  }

  static content = {
    payLottery { $("#play_lottery") }
  }

}
