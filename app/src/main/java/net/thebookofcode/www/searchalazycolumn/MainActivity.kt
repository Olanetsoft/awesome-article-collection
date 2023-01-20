package net.thebookofcode.www.searchalazycolumn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import net.thebookofcode.www.searchalazycolumn.ui.theme.SearchALazyColumnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchALazyColumnTheme {
                val repository = PersonRepository()
                val allData = repository.getAllData()
                val textState = remember { mutableStateOf(TextFieldValue("")) }
                Column {
                    TopBar()
                    SearchBar(state = textState)
                    PersonList(people = allData, state = textState)
                }
            }
        }
    }
}

