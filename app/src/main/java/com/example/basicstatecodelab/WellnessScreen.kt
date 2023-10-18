package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.ui.theme.StatefulCounter
import com.example.basicstatecodelab.ui.theme.WellnessTask
import com.example.basicstatecodelab.ui.theme.WellnessTasksList
import com.example.basicstatecodelab.ui.theme.WellnessViewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = modifier) {
        StatefulCounter()
       // val list = remember { getWellnessTask().toMutableStateList() }
      /*
      we can write this:
             val list = remember {
            mutableStateListOf<WellnessTask>().apply {
                addAll(getWellnessTask())
            }
        }

        we can not write this

            val list = remember {
            mutableStateListOf<WellnessTask>()
        }
        list.addAll(getWellnessTask())
        */

        WellnessTasksList(list = wellnessViewModel.tasks,
            onCloseTask = {task -> wellnessViewModel.remove(task)})
    }
}
