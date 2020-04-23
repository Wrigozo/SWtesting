package hu.tigra.pti.geb.page

import geb.Page
import geb.module.RadioButtons
import geb.module.Checkbox
import hu.tigra.pti.geb.module.ErrorMessages
import hu.tigra.pti.geb.module.Date

class RegisterPage extends Page {

    static url = 'index.php?controller=authentication&back=my-account#account-creation'

    static at = { header.text() == 'CREATE AN ACCOUNT' }

    static content = {
        header { $('h1[class="page-heading"]') }
        gender { $('input[type="radio"][name="id_gender"]').module(RadioButtons) }
        firstName { $('input[id="customer_firstname"]') }
        lastName { $('input[id="customer_lastname"]') }
        password { $('input[id="passwd"]') }
        dateOfBirth { module(Date) }
        newsletter { $('input[id="newsletter"]').module(Checkbox) }
        offers { $('input[id="optin"]').module(Checkbox) }
        registerButton { $('button[id="submitAccount"]') }
        errorMessages(required: false) { $('div[class="alert alert-danger"]:first-of-type').module ErrorMessages }
        addressFirstName { $('input[id="firstname"]') }
        addressLastName { $('input[id="lastname"]') }
        addressCompany { $('input[id="company"]') }
        addressAddress { $('input[id="address1"]') }
        addressAddress2 { $('input[id="address2"]') }
        addressCity { $('input[id="city"]') }
        addressState { $('select[id="id_state"]') }
        addressZip { $('input[id="postcode"]') }
        addressCountry { $('select[id="id_country"]') }
        addressOther { $('textarea[id="other"]') }
        addressPhone { $('input[id="phone"]') }
        addressMobile { $('input[id="phone_mobile"]') }
        addressAlias { $('input[id="alias"]') }
    }
}
