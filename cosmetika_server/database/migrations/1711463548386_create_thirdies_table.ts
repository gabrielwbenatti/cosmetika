import { BaseSchema } from '@adonisjs/lucid/schema'

export default class extends BaseSchema {
  protected tableName = 'thirdies'

  async up() {
    this.schema.createTable(this.tableName, (table) => {
      table.increments('id')
      table.string('name').notNullable()
      table.string('name_alias')
      table.boolean('status').defaultTo(true)
      table.string('address')
      table.string('zip_code', 31)
      table.string('town', 63)
      table.string('neighbourhood', 63)
      table.string('email')
      table.string('website')
      table.string('phone', 63)
      table.boolean('fournisseur').defaultTo(false)
      table.date('birth_date')
      table.string('professional_id', 127)

      table.timestamp('created_at')
      table.timestamp('updated_at')
    })
  }

  async down() {
    this.schema.dropTable(this.tableName)
  }
}