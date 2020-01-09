package com.example.demo.reddit.domain

import com.example.demo.reddit.data.DataRepository
import com.example.demo.reddit.data.remote.models.Child
import com.example.demo.reddit.funds.UseCase
import com.example.demo.reddit.models.VoteUi
import io.reactivex.Single
import javax.inject.Inject

class VotePostUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<Pair<Int, Child>, Single<Unit>>() {
    override fun execute(parameters: Pair<Int, Child>): Single<Unit> {
        try {
            val position = parameters.first
            val child = parameters.second
            val postData = dataRepository.getPostData()
            val childList = dataRepository.getPostData().children?.toMutableList()
            child.data?.userHasFavorited = !child.data?.userHasFavorited!!
            childList?.set(position, child)
            postData.children = childList
            dataRepository.setPost(postData)
            val id = child.data?.id ?: ""
            val direction = if (child.data?.userHasFavorited!!) {
                1
            } else {
                0
            }
            val voteUi = VoteUi(id = id, dir = direction)
            dataRepository.setVote(voteUi)
            return Single.just(Unit)
        } catch (e: Exception) {
            return Single.error(e)
        }
    }
}