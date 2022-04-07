package com.zenza.et.ui.deni_list

import com.zenza.et.data.Deni

sealed class DeniListEvent {
    data class OnDeleteDeniClick(val deni: Deni): DeniListEvent()
    data class OnDeniClearedChange(
        val deni: Deni,
        val isCleared: Boolean
    ): DeniListEvent()
    object OnUndoDeleteDeniClick: DeniListEvent()
    data class OnDeniClick(val deni: Deni): DeniListEvent()
    object OnAddDeniClick: DeniListEvent()
}