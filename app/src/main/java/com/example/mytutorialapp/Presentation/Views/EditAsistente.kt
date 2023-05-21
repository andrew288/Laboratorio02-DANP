package com.example.mytutorialapp.Presentation.Views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mytutorialapp.Navigation.Destinations
import com.example.mytutorialapp.Presentation.Custom.DatePickerCustom
import com.example.mytutorialapp.Presentation.Model.Asistente
import com.example.mytutorialapp.Presentation.RoundedButtonCustom
import com.example.mytutorialapp.Presentation.TextFieldCustom

@Composable
fun EditAsistente(navController: NavHostController, listaAsistentes: MutableList<Asistente>, index:Int){
    val asistente = listaAsistentes[index]

    // VALORES INICIALES
    val nombreValue = remember { mutableStateOf(asistente.nombre) }
    val apellidoValue = remember { mutableStateOf(asistente.apellido) }
    val fechaInscripcionValue = remember { mutableStateOf(asistente.fechaInscripcion) }
    val tipoSangreValue = remember { mutableStateOf(asistente.tipoSangre) }
    val telefonoValue = remember { mutableStateOf(asistente.telefono) }
    val correoValue = remember { mutableStateOf(asistente.correo) }
    val montoPagadoValue = remember { mutableStateOf(asistente.montoPagado.toString()) }
    val focusManager = LocalFocusManager.current

    // INTERFAZ DE USUARIO
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // image

        //Box
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp),
                color = Color.White,
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Editar asistente",
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // TEXT FIELD NOMBRE
                        TextFieldCustom(
                            textFieldValue = nombreValue,
                            textLabel = "Nombres",
                            keyboardType = KeyboardType.Text,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        // TEXT FIELD APELIIDO
                        TextFieldCustom(
                            textFieldValue = apellidoValue,
                            textLabel = "Apellido",
                            keyboardType = KeyboardType.Text,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        // TEXT FIELD FECHA INSCRIPCION
                        DatePickerCustom(fecha = fechaInscripcionValue)
                        // TEXT FIELD TIPO SANGRE
                        TextFieldCustom(
                            textFieldValue = tipoSangreValue,
                            textLabel = "Tipo de sangre",
                            keyboardType = KeyboardType.Text,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        // TEXT FIELD TELEFONO
                        TextFieldCustom(
                            textFieldValue = telefonoValue,
                            textLabel = "Teléfono",
                            keyboardType = KeyboardType.Number,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )
                        // TEXT FIELD CORREO
                        TextFieldCustom(
                            textFieldValue = correoValue,
                            textLabel = "Correo electronico",
                            keyboardType = KeyboardType.Email,
                            keyboardActions = KeyboardActions(
                                onNext = {
                                    focusManager.moveFocus(FocusDirection.Down)
                                }
                            ),
                            imeAction = ImeAction.Next
                        )

                        // TEXT FIELD MONTO PAGADO
                        TextFieldCustom(
                            textFieldValue = montoPagadoValue,
                            textLabel = "Monto Pagado",
                            keyboardType = KeyboardType.Decimal,
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    focusManager.clearFocus()
                                }
                            ),
                            imeAction = ImeAction.Done
                        )

                    }
                    Row() {
                        RoundedButtonCustom(
                            text = "Cancelar",
                            onClick = {
                                navController.navigate(Destinations.ListScreen.route)
                            },
                            color = Color.LightGray
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        RoundedButtonCustom(
                            text = "Guardar",
                            onClick = {
                                val asistente = Asistente(
                                    nombreValue.value,
                                    apellidoValue.value,
                                    fechaInscripcionValue.value,
                                    tipoSangreValue.value,
                                    telefonoValue.value,
                                    correoValue.value,
                                    montoPagadoValue.value.toDouble())

                                listaAsistentes[index] = asistente
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }


}