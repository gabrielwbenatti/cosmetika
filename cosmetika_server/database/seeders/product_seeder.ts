import Product from '#models/product'
import { BaseSeeder } from '@adonisjs/lucid/seeders'

export default class extends BaseSeeder {
  async run() {
    Product.create({
      reference: '73287',
      name: 'QUASAR DES COL BRAVE 100ml',
      nameAlias: 'Quasar Brave Desodorante Colônia 100ml',
    })
  }
}
