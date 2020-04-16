package hu.tigra.pti.geb.page

import geb.Page

class AdressesPage extends Page{

    static url = "/index.php?controller=order&step=1"

    static at = { header.displayed }

    static content = {

        header { $('h1.page-heading') }
        checkButton { $('button[name="processAddress"]') }

    }
}
