import type { HttpContext } from '@adonisjs/core/http'

import Product from '#models/product'

export default class ProductsController {
  async index({ request, response }: HttpContext) {
    const qs = request.qs()

    await Product.query()
      .select('id', 'name', 'name_alias', 'sale_price')
      .then((products) => {
        if (products.length > 0) {
          response.ok(products)
          return
        } else response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async store({ request, response }: HttpContext) {
    const body = request.body()
    await Product.create({
      reference: body.reference,
      name: body.name,
      nameAlias: body.nameAlias,
      status: body.status,
      buyPrice: body.buyPrice,
      salePrice: body.salePrice,
      toSell: body.toSell,
      toBuy: body.toBuy,
      highestCostPrice: body.highestCostPrice,
      lowestCostPrice: body.lowestCostPrice,
      lastCostPrice: body.lastCostPrice,
      lastBuyDate: body.lastBuyDate,
      barcode: body.barcode,
      moveStock: body.moveStock,
      currentStock: body.currentStock,
    })
      .then((product) => {
        if (product) {
          response.created({ id: product.id })
        }
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async destroy({ request, response }: HttpContext) {
    const params = request.params()
    await Product.findBy('id', params.id)
      .then((product) => {
        if (product) product.delete()
        else response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async show({ request, response }: HttpContext) {
    const params = request.params()
    await Product.findBy('id', params.id)
      .then((product) => {
        if (product) {
          response.ok(product)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }
}
