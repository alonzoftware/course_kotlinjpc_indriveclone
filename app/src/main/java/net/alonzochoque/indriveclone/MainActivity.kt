package net.alonzochoque.indriveclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import net.alonzochoque.indriveclone.presentation.navigation.graph.root.RootNavGraph
import net.alonzochoque.indriveclone.presentation.screens.auth.login.LoginScreen
import net.alonzochoque.indriveclone.ui.theme.InDriveCloneTheme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InDriveCloneTheme {
                Surface {
                    navController = rememberNavController()
                    RootNavGraph(navHostController = navController)
                }
//                LoginScreen()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Alonzo Choque",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
            }
        }
    }
}
