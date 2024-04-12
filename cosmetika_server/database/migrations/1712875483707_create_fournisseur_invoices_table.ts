import { BaseSchema } from '@adonisjs/lucid/schema'

export default class extends BaseSchema {
  protected tableName = 'fournisseur_invoices'

  async up() {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')
      table.string('reference').notNullable()
      table.string('variation', 5).notNullable()
      table.integer('fk_fournisseur_id').references('id').inTable('thirdies')
      table.date('issuance_at')
      table.date('delivery_at')
      table.decimal('delivery_cost', 15, 4).defaultTo(0)
      table.decimal('total_product', 15, 4).defaultTo(0)
      table.decimal('others_cost', 15, 4).defaultTo(0)
      table.decimal('total_amount', 15, 4).defaultTo(0)

      table.timestamp('created_at')
      table.timestamp('updated_at')
    })
  }

  async down() {
    this.schema.dropTable(this.tableName)
  }
}
