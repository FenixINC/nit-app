package com.inquisitor.nit.ui.base

import androidx.lifecycle.ViewModel
import com.inquisitor.nit.navigation.Navigator
import javax.inject.Inject

class ToolbarViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel(), Navigator by navigator {

    fun openMenu() {

    }
}