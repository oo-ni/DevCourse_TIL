package com.grepp.todo.controller

import com.grepp.todo.model.dto.UserDTO
import com.grepp.todo.model.entity.UserEntity
import com.grepp.todo.model.service.UserService
import com.grepp.todo.util.MyJwtTokenProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class UserController(val service: UserService) {
    // autowired는 객체 생성 이후 주입이기 때문에 반드시 lateinit var 해줘야 함.
    @Autowired
    lateinit var myTokenProvider: MyJwtTokenProvider

    // 회원가입
    @PostMapping("/signup")
    fun register(@RequestBody userDTO: UserDTO): ResponseEntity<UserEntity> {
        val result = service.join(userDTO.toEntity())
        println("join result : ${result}")
        result.role = "ADMIN"   // 지금 권한이나 소셜 정보 하나도 구현 안했기 때문에..
        result.authProvider = "kakao"
        return ResponseEntity.ok().body(result)
    }

    // 로그인
    @PostMapping("/login")
    fun login(@RequestBody userDTO: UserDTO): ResponseEntity<Any> {
        val user = service.login(userDTO.username, userDTO.password)

        println("login result : ${user}")
        if (user != null) {     // 로그인 성공했어? 그럼 토큰줘야지~
            val token = myTokenProvider.createMyToken(user, 1000*60*2)
            userDTO.token = token
            return ResponseEntity.ok().body(user)
        }

        return ResponseEntity.badRequest().body("login failed!!")
    }
}