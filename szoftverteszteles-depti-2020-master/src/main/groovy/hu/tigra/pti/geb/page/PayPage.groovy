package hu.tigra.pti.geb.page

import geb.Page

class PayPage extends Page{

    static url = "/index.php?controller=order&multi-shipping="

    static at = { header.displayed }

    static content = {

        header { $('h1.page-heading') }

        check { $('a.cheque')}

    }
}
