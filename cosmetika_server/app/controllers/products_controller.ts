import type { HttpContext } from '@adonisjs/core/http';

import Product from "#models/product";

export default class ProductsController {
    async index({ response }: HttpContext) {
        const products = await Product.all();
        response.send(products);
    }

    async store({ request, response }: HttpContext) {
        const body = request.body();

        await Product.create({
            name: body.name,
            nameAlias: body.nameAlias ?? body.name
        }).then((product) => {
            if (product != null) {
                response.send({ createdAt: product.createdAt })
            }
        }).catch((e) => {
            response.send({ error: e })
        })
    }
}
