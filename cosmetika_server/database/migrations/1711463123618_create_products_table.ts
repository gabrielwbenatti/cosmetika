import { BaseSchema } from '@adonisjs/lucid/schema'

export default class extends BaseSchema {
  protected tableName = 'products'

  async up() {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')
      table.string('reference', 31)
      table.string('name').notNullable()
      table.string('name_alias')
      table.boolean('status').defaultTo(true)
      table.decimal('buy_price', 15, 4).defaultTo(0)
      table.decimal('sale_price', 15, 4).defaultTo(0)
      table.boolean('to_sell').defaultTo(true)
      table.boolean('to_buy').defaultTo(true)
      table.decimal('highest_cost_price', 10, 4).defaultTo(0)
      table.decimal('lowest_cost_price', 15, 4).defaultTo(0)
      table.decimal('last_cost_price', 15, 4).defaultTo(0)
      table.date('last_buy_date')
      table.string('barcode', 127)
      table.boolean('move_stock').defaultTo(true)
      table.decimal('current_stock', 15, 4).defaultTo(0)


      table.timestamp('created_at')
      table.timestamp('updated_at')
    })
  }

  async down() {
    this.schema.dropTable(this.tableName)
  }
}