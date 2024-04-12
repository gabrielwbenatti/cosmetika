import { DateTime } from 'luxon'
import { BaseModel, column } from '@adonisjs/lucid/orm'

export default class Thirdy extends BaseModel {
  @column({ isPrimary: true })
  declare id: number

  @column()
  declare name: string

  @column()
  declare nameAlias: string

  @column()
  declare status: boolean

  @column()
  declare address: string

  @column()
  declare zipCode: string

  @column()
  declare town: string

  @column()
  declare neighbourhood: string

  @column()
  declare email: string

  @column()
  declare website: string

  @column()
  declare phone: string

  @column()
  declare fournisseur: boolean

  @column()
  declare birthDate: Date

  @column()
  declare cpfCnpj: string

  @column()
  declare stateRegistration: string

  @column.dateTime({ autoCreate: true })
  declare createdAt: DateTime

  @column.dateTime({ autoCreate: true, autoUpdate: true })
  declare updatedAt: DateTime
}
