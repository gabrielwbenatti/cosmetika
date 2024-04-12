import Thirdy from '#models/thirdy'
import { BaseSeeder } from '@adonisjs/lucid/seeders'

export default class extends BaseSeeder {
  async run() {
    Thirdy.create({
      name: 'GAJA COMERCIAL LTDA',
      fournisseur: true,
    })
  }
}
