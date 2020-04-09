package hu.tigra.pti.geb.page

import geb.Page
import hu.tigra.pti.geb.module.ProductCard

class MainPage extends Page {

    static url = "/index.php"

    static at = { title == 'My Store' }

    static content = {
        loginButton { $('a[class="login"]') }
        products { $('ul[id="homefeatured"]').find('li').collect { li -> li.module ProductCard } }
        popUpHeader { $('div[class="layer_cart_product col-xs-12 col-md-6"]').$('h2:nth-child(2)') }
        checkoutButton { $('div[class="button-container"]').$('a["class="btn btn-default button button-medium"]')}
    }
}
