import FournisseurInvoiceItem from '#models/fournisseur_invoice_item'
import type { HttpContext } from '@adonisjs/core/http'

export default class FournisseurInvoiceItemsController {

  async index({ request, response }: HttpContext) {
    const params = request.params()
    await FournisseurInvoiceItem.query()
      .select('*')
      .where('fkFournisseurInvoiceId', params.invoiceId)
      .then((dets) => {
        if (dets.length > 0) {
          response.send(dets)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async store({ request, response }: HttpContext) {
    const body = request.body()
    await FournisseurInvoiceItem.create({
      fkFournisseurInvoiceId: body.fkFournisseurInvoiceId,
      fkProductId: body.fkProductId,
      itemNo: body.itemNo,
      quantity: body.quantity,
      total: body.total,
      unitary: body.unitary,
    }).then((det) => {
      if (det) {
        response.created({ id: det.id })
      }
    })
      .catch((e) => response.badRequest({ error: e }))
  }

  async destroy({ request, response }: HttpContext) {
    const params = request.params()
    await FournisseurInvoiceItem.query()
      .select('*')
      .where('fkFournisseurInvoiceId', params.invoiceId)
      .andWhere('itemNo', params.itemNo)
      .first()
      .then((item) => {
        if (item) item.delete()
        else response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }
}