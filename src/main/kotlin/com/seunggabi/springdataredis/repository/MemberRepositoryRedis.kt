package com.seunggabi.springdataredis.repository

import com.seunggabi.springdataredis.member.Member
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepositoryRedis : CrudRepository<Member, String>
