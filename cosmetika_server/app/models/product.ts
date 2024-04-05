import { DateTime } from 'luxon'
import { BaseModel, column } from '@adonisjs/lucid/orm'

export default class Product extends BaseModel {
  @column({ isPrimary: true })
  declare id: number

  @column()
  declare reference: string

  @column()
  declare name: string

  @column()
  declare nameAlias: string

  @column()
  declare status: boolean

  @column()
  declare buyPrice: number

  @column()
  declare salePrice: number

  @column()
  declare toSell: boolean

  @column()
  declare toBuy: boolean

  @column()
  declare highestCostPrice: number

  @column()
  declare lowestCostPrice: number

  @column()
  declare lastCostPrice: number

  @column()
  declare lastBuyDate: DateTime

  @column()
  declare barcode: string

  @column()
  declare moveStock: boolean

  @column()
  declare currentStock: number

  @column.dateTime({ autoCreate: true })
  declare createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  declare updatedAt: DateTime
}
