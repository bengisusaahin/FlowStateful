package com.bengisusahin.flowstateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bengisusahin.flowstateful.ui.theme.FlowStatefulTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlowStatefulTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "firsScreen" ){
                        composable("firsScreen"){
                            val viewModel = viewModel<FirstScreenViewModel>()
                            val time by viewModel.counter.collectAsState()

                            FirstScreen(time = time, onButtonClicked = {
                                navController.navigate("secondScreen")
                            })
                        }
                        composable("secondScreen"){
                            SecondScreen()
                        }
                    }
                }
            }
        }
    }
}

