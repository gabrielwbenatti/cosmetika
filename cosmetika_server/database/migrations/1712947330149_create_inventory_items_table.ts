import { BaseSchema } from '@adonisjs/lucid/schema'

export default class extends BaseSchema {
  protected tableName = 'inventory_items'

  async up() {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')
      table.integer('fkInventoryId').notNullable().unsigned().references('id').inTable('inventories')
      table.integer('fkProductId').notNullable().unsigned().references('id').inTable('products')
      table.decimal('old_quantity', 15, 4).defaultTo(0)
      table.decimal('new_quantity', 15, 4).defaultTo(0)

      table.timestamp('created_at')
      table.timestamp('updated_at')
    })
  }

  async down() {
    this.schema.dropTable(this.tableName)
  }
}