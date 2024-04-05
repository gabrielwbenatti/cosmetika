/*
|--------------------------------------------------------------------------
| Routes file
|--------------------------------------------------------------------------
|
| The routes file is used for defining the HTTP routes.
|
*/

import router from '@adonisjs/core/services/router'

import ProductsController from '#controllers/products_controller'

router.get('/', async () => {
  return {
    hello: 'world',
  }
})

router.get('/products', [ProductsController, 'index'])
router.post('/products', [ProductsController, 'store'])
router.get('/products/:id', [ProductsController, 'show'])
router.delete('/products/:id', [ProductsController, 'destroy'])
