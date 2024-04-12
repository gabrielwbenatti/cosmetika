import { BaseSchema } from '@adonisjs/lucid/schema'

export default class extends BaseSchema {
  protected tableName = 'fournisseur_invoice_items'

  async up() {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')
      table
        .integer('fk_fournisseur_invoice_id')
        .notNullable()
        .unsigned()
        .references('id')
        .inTable('fournisseur_invoices')
        .onDelete('CASCADE')
        .onUpdate('CASCADE')
      table.integer('fk_product_id')
        .notNullable()
        .unsigned()
        .references('id')
        .inTable('products')
        .onUpdate('CASCADE')
      table.integer('item_no').notNullable()
      table.decimal('quantity', 15, 4).defaultTo(0)
      table.decimal('total', 15, 4).defaultTo(0)
      table.decimal('unitary', 15, 4).defaultTo(0)

      table.timestamp('created_at')
      table.timestamp('updated_at')
    })
  }

  async down() {
    this.schema.dropTable(this.tableName)
  }
}
