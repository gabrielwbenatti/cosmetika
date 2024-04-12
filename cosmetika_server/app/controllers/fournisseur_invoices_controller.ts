import FournisseurInvoice from '#models/fournisseur_invoice'
import type { HttpContext } from '@adonisjs/core/http'

export default class FournisseurInvoicesController {
  async index({ response }: HttpContext) {
    await FournisseurInvoice.query()
      .select(
        'id',
        'fkFournisseurId',
        'reference',
        'variation',
        'issuanceAt',
        'deliveryAt',
        'totalAmount'
      )
      .preload('fournisseur', (fournisseurQry) => {
        fournisseurQry.select('id', 'name', 'nameAlias')
      })
      .then((factures) => {
        if (factures.length > 0) {
          response.send(factures)
          return
        }
        response.noContent()
      })
  }

  async store({ request, response }: HttpContext) {
    const body = request.body()
    await FournisseurInvoice.create({
      reference: body.reference,
      variation: body.variation,
      fkFournisseurId: body.fkFournisseurId,
      issuanceAt: body.issuanceAt,
      deliveryAt: body.deliveryAt,
      deliveryCost: body.deliveryCost,
      totalProduct: body.totalProduct,
      othersCost: body.othersCost,
      totalAmount: body.totalAmount,
    })
      .then((invoice) => {
        if (invoice) {
          response.created({ id: invoice.id })
        }
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async show({ request, response }: HttpContext) {
    const params = request.params()
    await FournisseurInvoice.query()
      .select('*')
      .where('id', params.id)
      .preload('fournisseur', (fournisseurQry) => {
        fournisseurQry.select('id', 'name', 'nameAlias')
      })
      .first()
      .then((invoice) => {
        if (invoice) {
          response.send(invoice)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async destroy({ request, response }: HttpContext) {
    const params = request.params()
    await FournisseurInvoice.findBy('id', params.id)
      .then((invoice) => {
        if (invoice) invoice.delete()
        else response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }
}
