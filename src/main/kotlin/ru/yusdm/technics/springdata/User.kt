package ru.yusdm.technics.springdata

import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import java.util.*
import javax.persistence.*

@Entity
class User: Persistable<UUID> {

    @Id
    val uuid: UUID

    @Column
    val name: String

    @Transient
    private var _isNew: Boolean

    constructor(name: String) {
        this.uuid = UUID.randomUUID()
        this.name = name
        this._isNew = true
    }

    override fun getId() = this.uuid

    override fun isNew() = this._isNew

    @PostPersist
    @PostLoad
    private fun setPersisted() {
        this._isNew = false
    }

}