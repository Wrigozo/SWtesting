package hu.tigra.pti.geb.page

import geb.Page

class OrderSummaryPage extends Page{

    static url ="/index.php?fc=module&module=cheque&controller=payment"

    static at = { header.displayed }

    static content={

        header { $('h1[class="page-heading"]') }

        confirm { $('button[class="button btn btn-default button-medium"]') }

        successMessage { $('p[class="alert alert-success"]')}



    }
}
