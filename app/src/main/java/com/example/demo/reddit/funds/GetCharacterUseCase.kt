package com.example.demo.reddit.funds

import com.example.demo.reddit.data.DataRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(private val dataRepository: DataRepository) :
    UseCase<String, Observable<Char>>() {
    override fun execute(parameters: String): Observable<Char> {
        val arr = parameters.toCharArray()
        return Observable.range(0, arr.size).map {
            if (it % 10 == 0 && it != 0) {
                arr[it]
            } else ' '
        }
    }
}