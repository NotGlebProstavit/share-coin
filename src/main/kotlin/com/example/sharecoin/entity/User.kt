package com.example.sharecoin.entity

import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "username", nullable = false)
    var username: String? = null

    @Column(name = "password", nullable = false)
    var password: String? = null

    @ManyToMany(mappedBy = "users")
    var rooms: MutableSet<Room> = mutableSetOf()

    @OneToMany(mappedBy = "user")
    var userProducts: MutableSet<UserProduct> = mutableSetOf()

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    var roles: MutableSet<Role> = mutableSetOf()
}