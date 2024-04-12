import { DateTime } from 'luxon'
import { BaseModel, column, hasOne } from '@adonisjs/lucid/orm'
import Product from './product.js'
import type { HasOne } from '@adonisjs/lucid/types/relations'

export default class FournisseurInvoiceItem extends BaseModel {
  @column({ isPrimary: true })
  declare id: number

  @column()
  declare fkFournisseurInvoiceId: number

  @column()
  declare fkProductId: number

  @column()
  declare itemNo: number

  @column()
  declare quantity: number

  @column()
  declare total: number

  @column()
  declare unitary: number

  @column.dateTime({ autoCreate: true })
  declare createdAt: DateTime

  @column.dateTime({ autoUpdate: true })
  declare updatedAt: DateTime

  @hasOne(() => Product, { localKey: 'fkProductId', foreignKey: 'id' })
  declare product: HasOne<typeof Product>
}
