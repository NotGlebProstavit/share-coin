package com.example.sharecoin.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

@Entity
@Table(name = "role")
class Role(): GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "name", nullable = false)
    var name: String? = null

    @ManyToMany(mappedBy = "roles")
    lateinit var users: MutableCollection<User>

    override fun getAuthority(): String = name!!
}