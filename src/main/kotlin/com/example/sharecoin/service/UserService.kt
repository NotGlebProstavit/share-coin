package com.example.sharecoin.service

import com.example.sharecoin.entity.Role
import com.example.sharecoin.entity.UserSerialize
import com.example.sharecoin.exception.UserAlreadyExistException
import com.example.sharecoin.repository.RoleRepository
import com.example.sharecoin.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.util.*

@Component
@Service
class UserService: UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository
    @Autowired
    lateinit var roleRepository: RoleRepository
    @Autowired
    lateinit var bCryptPasswordEncoder: BCryptPasswordEncoder

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username)
            ?: throw UsernameNotFoundException("This user don't exist")
        val authorities = listOf(roleRepository.findByName("ROLE_USER"))
        return User(user.username, user.password, authorities)
    }

    fun checkIfUserExist(username: String?): Boolean =
        userRepository.findByUsername(username) != null

    fun checkIfRoleExist(name: String?): Boolean =
        roleRepository.findByName(name) != null

    fun register(user: UserSerialize){
        if(checkIfUserExist(user.username)){
            throw UserAlreadyExistException("User already exist")
        }
        val userDB = com.example.sharecoin.entity.User()
        userDB.username = user.username
        userDB.password = bCryptPasswordEncoder.encode(user.password)
        var roleDB: Role? = null
        if(!checkIfRoleExist("ROLE_USER")){
            roleDB = Role()
            roleDB.name = "ROLE_USER"
            roleDB.users = Collections.singleton(userDB)
            roleRepository.save(roleDB)
        } else {
            roleDB = roleRepository.findByName("ROLE_USER")
        }
        userDB.roles = Collections.singleton(roleDB)
        userRepository.save(userDB)
    }
}