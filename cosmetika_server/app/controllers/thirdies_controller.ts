import Thirdy from '#models/thirdy'
import type { HttpContext } from '@adonisjs/core/http'

export default class ThirdiesController {

  async index({ response }: HttpContext) {
    await Thirdy.query()
      .select('id', 'name', 'name_alias')
      .then((thirdies) => {
        if (thirdies.length > 0) {
          response.send(thirdies)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  async store({ request, response }: HttpContext) {
    const body = request.body()
    await Thirdy.create({
      name: body.name,
      nameAlias: body.nameAlias ?? body.name
    })
      .then((thirdy) => {
        if (thirdy) {
          response.created({ id: thirdy.id })
        }
      })
      .catch((e) => response.badRequest({ error: e }))
  }

  //destroy

  async show({ request, response }: HttpContext) {
    const params = request.params()
    await Thirdy.findBy('id', params.id)
      .then((thirdy) => {
        if (thirdy) {
          response.ok(thirdy)
          return
        }
        response.noContent()
      })
      .catch((e) => response.badRequest({ error: e }))
  }
}