package com.zenza.et.ui.deni_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zenza.et.data.DeniRepository
import com.zenza.et.util.Routes
import com.zenza.et.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeniListViewModel @Inject constructor(
    private val deniRepository: DeniRepository
): ViewModel() {

    val deni = deniRepository.getDeni()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: DeniListEvent) {
        when (event) {
            is DeniListEvent.OnDeniClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_DENI + "?deniId=${event.deni.id}"))
            }
            is DeniListEvent.OnAddDeniClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_DENI))
            }
            is DeniListEvent.OnUndoDeleteDeniClick -> {

            }
            is DeniListEvent.OnDeleteDeniClick -> {

            }
            is DeniListEvent.OnDeniClearedChange -> {

            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}