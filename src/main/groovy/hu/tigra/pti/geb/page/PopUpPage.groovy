package hu.tigra.pti.geb.page
import geb.Page

class PopUpPage extends Page{

    static url = "/index.php"

    static at = {  popup.displayed }

    static content = {
        popup { $('div[id="layer_cart"]') }
        popUpHeader { $('div[class="layer_cart_product col-xs-12 col-md-6"]>h2') }
        checkoutButton  { $('a[class="btn btn-default button button-medium"]')}
    }

}
