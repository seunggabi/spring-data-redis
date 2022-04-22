package com.seunggabi.springdataredis.controller

import com.seunggabi.springdataredis.member.Member
import com.seunggabi.springdataredis.repository.MemberRepositoryRedis
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.* // ktlint-disable no-wildcard-imports

@RestController
@Service
@RequestMapping("/redis-test")
class RedisTestController(
    val memberRepositoryRedis: MemberRepositoryRedis
) {
    @GetMapping("/members")
    fun getMemberList(): ResponseEntity<Any> {
        val users = memberRepositoryRedis.findAll()

        val data = HashMap<String, Any>()
        data["userList"] = users
        return ResponseEntity.ok(data)
    }

    @PostMapping("/member")
    fun setMember(@RequestBody member: Member): ResponseEntity<Any> {
        memberRepositoryRedis.save(member)

        val data = HashMap<String, Any>()
        data["stats"] = "success"
        return ResponseEntity.ok(data)
    }
}
