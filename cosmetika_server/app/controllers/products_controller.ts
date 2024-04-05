import type { HttpContext } from '@adonisjs/core/http'

import Product from '#models/product'

export default class ProductsController {
  async index({ response }: HttpContext) {
    await Product.query()
      .select('id', 'name', 'name_alias', 'sale_price')
      .then((products) => {
        if (products.length > 0) {
          response.send(products)
          return
        } else response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async store({ request, response }: HttpContext) {
    const body = request.body()
    await Product.create({
      name: body.name,
      nameAlias: body.nameAlias ?? body.name,
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
        if (product) {
          product.delete()
        }
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

  async edit({ request, response }: HttpContext) {
    const params = request.params()
  }
}
