package dev.lizarraga.ejemplo2

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.notkamui.keval.Keval

class MyViewModel : ViewModel() {

    var input: String by mutableStateOf("")
    var result: String by mutableStateOf("")

    fun onInputChange(newValue: String) {
        if (newValue == "") {
            input = ""
            result = ""
        } else {
            input += newValue
        }
    }

    fun getResultt() {
        try {
            val kk :String= (Keval.eval(input)).toString()
            result = kk
        } catch (e: Exception) {
            result = "¡Error matemático!"
            input = ""
        }
    }
}