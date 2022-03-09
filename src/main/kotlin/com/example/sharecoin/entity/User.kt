package com.example.sharecoin.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "\"user\"")
class User: UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long? = null

    @Column(name = "username", nullable = false)
    private var username: String? = null

    @Column(name = "password", nullable = false)
    private var password: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    lateinit var roles: MutableCollection<Role>

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return roles
    }

    override fun getPassword(): String = password!!
    fun setPassword(password: String?){
        this.password = password
    }

    override fun getUsername(): String = username!!

    override fun isAccountNonExpired(): Boolean = true

    override fun isAccountNonLocked(): Boolean = true

    override fun isCredentialsNonExpired(): Boolean = true

    override fun isEnabled(): Boolean = true


}