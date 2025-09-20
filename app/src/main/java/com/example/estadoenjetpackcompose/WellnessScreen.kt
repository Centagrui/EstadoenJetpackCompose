package com.example.estadoenjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

// Es posible que necesites agregar las importaciones para los otros
// composables que estás usando aquí, por ejemplo:
// import com.example.estadoenjetpackcompose.ui.StatefulCounter
// import com.example.estadoenjetpackcompose.ui.WellnessTasksList

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    // Se mantiene solo el Column que es más completo.
    Column(modifier = modifier) {
        StatefulCounter()

        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { task, checked ->
                wellnessViewModel.changeTaskChecked(task, checked)
            },
            onCloseTask = { task ->
                wellnessViewModel.remove(task)
            }
        )
    }
}