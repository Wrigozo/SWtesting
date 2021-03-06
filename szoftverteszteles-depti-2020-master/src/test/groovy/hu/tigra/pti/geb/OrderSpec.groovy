package hu.tigra.pti.geb

import hu.tigra.pti.geb.page.AdressesPage
import hu.tigra.pti.geb.page.MainPage
import hu.tigra.pti.geb.page.MyAccountPage
import hu.tigra.pti.geb.page.OrderSummaryPage
import hu.tigra.pti.geb.page.PayPage
import hu.tigra.pti.geb.page.PopUpPage
import hu.tigra.pti.geb.page.OrderPage
import hu.tigra.pti.geb.page.ShippingPage

class OrderSpec extends BaseSpec {

    def 'Legolcsóbb termék megrendelése'() {
        given: 'Bejelentkezek az oldalra'
        login(Constant.USERS.HELYES_FELHASZNALO)
        waitFor { at MyAccountPage }

        when: 'Átnavigálok a főoldalra'
        def mainPage = to MainPage

        then: 'Megjelennek a termékek'
        mainPage.products.size() != 0

        when: 'A kurzort a legolcsóbb fölé viszem és rákattintok az "Add to cart" gombra'
        def cheapestProduct = mainPage.products.min { product -> product.price }
        interact {
            moveToElement(cheapestProduct.navigator)
        }
        cheapestProduct.addToCart.click()

        // Órai feladat
        then: 'Megjelenik a kosár popup és a "Product successfully added to your shopping cart" üzenet'
        def popUpPage = waitFor { at PopUpPage }
        popUpPage.popUpHeader.text() == "Product successfully added to your shopping cart"

        when: 'Rákattintok a "Proceed to checkout" gombra'
        popUpPage.checkoutButton.click()

        then: 'Megjelenik a "SHOPPING-CART SUMMARY" fejlécű oldal'
        def orderPage = waitFor { at OrderPage }
        orderPage.header.text().startsWith("SHOPPING-CART SUMMARY")

        // 3. Házi feladat
        when: 'Rákattintok a plusz gombra az első sorban'
        orderPage.summaryFirstRow.plusButton.click()

        then: 'A mennyiség 2-re változik'
        waitFor { orderPage.summaryFirstRow.quantity == 2 }

        when: 'Rákattintok a "Proceed to checkout" gombra'
        orderPage.paymentCheckButton.click()

        then: 'Megjelenik az "ADDRESSES" fejlécű oldal'
        def addressesPage = waitFor { at AdressesPage }
        addressesPage.header.text() == "ADDRESSES"

        when: 'Rákattintok a "Proceed to checkout" gombra'
        addressesPage.checkButton.click()

        then: 'Megjelenik a "SHIPPING" fejlécű oldal'
        def shippingPage = waitFor {at ShippingPage}
        shippingPage.header.text()=="SHIPPING"

        when: 'Bepipálom a checkboxot és rákattintok a "Proceed to checkout" gombra'
        shippingPage.checkBox.check()
        shippingPage.checkButton.click()

        then: 'Megjelenik a "PLEASE CHOOSE YOUR PAYMENT METHOD" fejlécű oldal'
        def payPage = waitFor { at PayPage }
        payPage.header.text() == "PLEASE CHOOSE YOUR PAYMENT METHOD"

        when: 'Kiválasztom a csekk fizetési módot'
        payPage.check.click()

        then: 'Megjelenik az "ORDER SUMMARY" fejlécű oldal'
        def orderSummaryPage = waitFor{ at OrderSummaryPage}
        orderSummaryPage.header.text()== "ORDER SUMMARY"

        when: 'Rákattintok az "I confirm my order" gombra'

        orderSummaryPage.confirm.click()

        then: 'Megjelenik a sikeres rendelés üzenete: "Your order on My Store is complete."'
        orderSummaryPage.successMessage.text()== "Your order on My Store is complete."
    }
}
