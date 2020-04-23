package hu.tigra.pti.geb

import hu.tigra.pti.geb.page.LoginPage
import hu.tigra.pti.geb.page.RegisterPage
import hu.tigra.pti.geb.page.MyAccountPage

class RegisterSpec extends BaseSpec {

    def 'Regisztráció'() {
        given: 'Bejelentkező felületre navigálok'
        def loginPage = to LoginPage

        when: 'Kitöltöm a "CREATE AN ACCOUNT" blokkban az "Email address" mezőt egy még nem regisztrált email címmel és a "Create an account" funkciógombra kattintok.'
        loginPage.registerEmailAddress = 'teszt234@email.hu'
        loginPage.registerButton.click()

        then: 'Megjelenik a "Create an account" űrlap.'
        def registerPage = waitFor { at RegisterPage }

        when: 'Kitöltöm a "Your personal information" blokkban az összes mezőt és a "Register" funkciógombra kattintok.'
        registerPage.gender.checked = 'Mr.'
        registerPage.firstName = 'Elek'
        registerPage.lastName = 'Teszt'
        registerPage.password = 'teszt123'
        registerPage.dateOfBirth.value('1990', 'May', '12')
        registerPage.newsletter.check()
        registerPage.offers.check()
        registerPage.registerButton.click()

        then: '5 hibaüzenet jelenik meg'
        registerPage.errorMessages.values.size() == 5

        //your address-t befejezni mindent kitölteni
        when: '’Kitöltöm a „Your address” blokkban az összes mezőt és „Register” funkciógombra kattintok'
        registerPage.password = 'teszt123'
        registerPage.addressFirstName = 'Elek'
        registerPage.addressLastName = 'Teszt'
        registerPage.addressCompany = 'debrői'
        registerPage.addressAddress = 'kassai 26'
        registerPage.addressCity = 'Debrecen'
        registerPage.addressState = 'Arkansas'
        registerPage.addressZip = '12345'
        registerPage.addressCountry = 'United States'
        registerPage.addressOther = 'sssssssss'
        registerPage.addressPhone = '1234556666'
        registerPage.addressMobile = '21421412'
        registerPage.addressAlias = 'aaaaaaaa'
        registerPage.registerButton.click()

        then: 'Megjelenik a felhasználó adatai felület: “My account”.'
        def myAccountPage = waitFor { at MyAccountPage }
        myAccountPage.header.text() == "MY ACCOUNT"
    }
}
