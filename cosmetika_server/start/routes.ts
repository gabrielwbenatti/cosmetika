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
import ThirdiesController from '#controllers/thirdies_controller'
import FournisseurInvoicesController from '#controllers/fournisseur_invoices_controller'

router.get('/', async () => {
  return {
    hello: 'world',
  }
})

router.get('/products', [ProductsController, 'index'])
router.post('/products', [ProductsController, 'store'])
router.get('/products/:id', [ProductsController, 'show'])
router.delete('/products/:id', [ProductsController, 'destroy'])

router.get('/thirdies', [ThirdiesController, 'index'])
router.post('/thirdies', [ThirdiesController, 'store'])
router.get('/thirdies/:id', [ThirdiesController, 'show'])
router.delete('/thirdies/:id', [ThirdiesController, 'destroy'])

router.get('/fournisseur-invoices', [FournisseurInvoicesController, 'index'])
router.post('/fournisseur-invoices', [FournisseurInvoicesController, 'store'])
router.get('/fournisseur-invoices/:id', [FournisseurInvoicesController, 'show'])
router.delete('/fournisseur-invoices/:id', [FournisseurInvoicesController, 'destroy'])
