package com.example.binhistory.presentaion.cardInfo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binhistory.domain.usecase.GetCardInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardInfoViewModel @Inject constructor(
    private val getCardInfoUseCase: GetCardInfoUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CardInfoState())
    val state: State<CardInfoState> = _state

    fun onBinEntered(bin: String) {
        viewModelScope.launch {
            _state.value = CardInfoState(isLoading = true)
            val result = getCardInfoUseCase(bin)
            _state.value = when {
                result.isSuccess -> CardInfoState(cardInfo = result.getOrNull())
                else -> CardInfoState(error = result.exceptionOrNull()?.message)
            }
        }
    }
}
