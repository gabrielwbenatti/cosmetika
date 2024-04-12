import FournisseurInvoiceDet from '#models/fournisseur_invoice_det'
import type { HttpContext } from '@adonisjs/core/http'

export default class FactureInvoiceDetsController {
  async index({ request, response }: HttpContext) {
    const params = request.params()
    await FournisseurInvoiceDet.query()
      .select('id', 'fkFournisseurInvoiceId', 'fkProductId', 'quantity', 'total', 'unitary')
      .where('fkFournisseurInvoiceId', params.fkFournisseurInvoiceId)
      .preload('product', (productQry) => {
        productQry.select('id', 'name', 'nameAlias')
      })
      .then((det) => {
        if (det) {
          response.send(det)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }
}
