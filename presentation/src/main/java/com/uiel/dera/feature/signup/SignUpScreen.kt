package com.uiel.dera.feature.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SignUpScreen(
    navController: NavController,
    signUpScreenViewModel: SignUpScreenViewModel = viewModel()
) {
    val uiState by signUpScreenViewModel.signUpState.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SignUpInputs(
            name = { uiState?.name ?: "" },
            id = { uiState?.id ?: "" },
            password = { uiState?.password ?: "" },
            onNameChanged = { signUpScreenViewModel.updateName(name = it)},
            onIdChanged = {signUpScreenViewModel.updateId(id = it)},
            onPwChanged = {signUpScreenViewModel.updatePassword(password = it)}
        )
        SignUpBtn(navController)
    }

}

@Composable
private fun SignUpInputs(
    name: () -> String,
    id: () -> String,
    password: () -> String,
    onNameChanged: (String) -> Unit,
    onIdChanged: (String) -> Unit,
    onPwChanged : (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 100.dp
            )
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        BasicTextField(
            value = name(),
            onValueChange = onNameChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .align(Alignment.CenterStart)
        )
        if (name().isBlank()) {
            Text(
                text = "이름",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
    Box(
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 40.dp
            )
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        BasicTextField(
            value = id(),
            onValueChange = onIdChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .align(Alignment.CenterStart)
        )
        if (id().isBlank()) {
            Text(
                text = "아이디",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
    Box(
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 40.dp
            )
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(8.dp)
            )
    ) {
        BasicTextField(
            value = password(),
            onValueChange = onPwChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
                .align(Alignment.CenterStart)
        )
        if (password().isBlank()) {
            Text(
                text = "비밀번호",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterStart)
            )
        }
    }
}

@Composable
private fun SignUpBtn(navController: NavController) {

}