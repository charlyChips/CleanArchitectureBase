package com.charlychips.domain.usecase

import com.charlychips.domain.executors.JobExecutionThread
import com.charlychips.domain.executors.PostExecutionThread
import com.charlychips.domain.models.User
import com.charlychips.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Single

class GetUsersUseCase(
    private val usersRepository: UsersRepository,
    jobThread:JobExecutionThread,
    postThread:PostExecutionThread
):SingleUseCase<List<User>, Void>(jobThread, postThread){

    override fun build(params: Void?): Single<List<User>> {
        return usersRepository.getUsers()
    }

}