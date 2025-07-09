package com.example.binhistory.presentaion.cardHistory

import com.example.binhistory.domain.usecase.GetCardHistoryUseCase
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CardHistoryViewModel @Inject constructor(
    private val getCardHistoryUseCase: GetCardHistoryUseCase
) : ViewModel() {
    private val _state = mutableStateOf(CardHistoryState())
    val state: State<CardHistoryState> = _state

    init {
        viewModelScope.launch {
            _state.value = CardHistoryState(cards = getCardHistoryUseCase())
        }
    }
}