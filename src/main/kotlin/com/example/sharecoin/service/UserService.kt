package com.example.sharecoin.service

import com.example.sharecoin.entity.Role
import com.example.sharecoin.entity.User
import com.example.sharecoin.repository.RoleRepository
import com.example.sharecoin.repository.UserRepository
import com.example.sharecoin.utils.Utils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService: UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var roleRepository: RoleRepository

    @Autowired
    lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    override fun loadUserByUsername(username: String?): UserDetails =
        userRepository.findByUsername(username) ?: throw UsernameNotFoundException("User not found")

    fun findUserById(userId: Long): User {
        val userFromDb: Optional<User> = userRepository.findById(userId)
        return userFromDb.orElse(User())
    }

    fun allUsers(): MutableCollection<User> = userRepository.findAll()

    fun saveUser(user: User): Boolean {
        userRepository.findByUsername(user.username) ?: return false
        if(roleRepository.findById(1L).isEmpty){
            roleRepository.save(Role(1L, "ROLE_USER"))
        }
        user.roles = Collections.singleton(roleRepository.getById(1L))
        user.setPassword(bCryptPasswordEncoder.encode(user.password));
        userRepository.save(user)
        return true
    }

    fun deleteUser(userId: Long?): Boolean {
        if (userRepository.findById(userId!!).isPresent) {
            userRepository.deleteById(userId)
            return true
        }
        return false
    }
}