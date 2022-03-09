package com.example.sharecoin.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "role")
class Role: GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    final var id: Long? = null

    @Lob
    @Column(name = "name", nullable = false)
    final var name: String? = null

    @ManyToMany(mappedBy = "roles")
    lateinit var users: MutableCollection<User>

    override fun getAuthority(): String = name!!

    constructor(id: Long){
        this.id = id
    }

    constructor(id: Long, name: String){
        this.id = id
        this.name = name
    }
}