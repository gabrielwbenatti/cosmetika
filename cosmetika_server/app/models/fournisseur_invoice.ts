import { DateTime } from 'luxon'
import { BaseModel, column, hasMany, hasOne } from '@adonisjs/lucid/orm'
import Thirdy from './thirdy.js'
import type { HasMany, HasOne } from '@adonisjs/lucid/types/relations'
import FournisseurInvoiceItem from './fournisseur_invoice_item.js'

export default class FournisseurInvoice extends BaseModel {
  @column({ isPrimary: true })
  declare id: number

  @column()
  declare reference: string

  @column()
  declare variation: string

  @column()
  declare fkFournisseurId: number

  @column()
  declare issuanceAt: Date

  @column()
  declare deliveryAt: Date

  @column()
  declare deliveryCost: number

  @column()
  declare totalProduct: number

  @column()
  declare othersCost: number

  @column()
  declare totalAmount: number

  @column.dateTime({ autoCreate: true })
  declare createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  declare updatedAt: DateTime

  @hasOne(() => Thirdy, { localKey: 'fkFournisseurId', foreignKey: 'id' })
  declare fournisseur: HasOne<typeof Thirdy>

  @hasMany(() => FournisseurInvoiceItem, { localKey: 'id', foreignKey: 'fkFournisseurInvoiceId' })
  declare items: HasMany<typeof FournisseurInvoiceItem>
}
