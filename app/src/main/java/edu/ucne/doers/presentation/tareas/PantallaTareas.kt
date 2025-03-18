package edu.ucne.doers.presentation.tareas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import edu.ucne.doers.data.local.entity.TareaEntity
import edu.ucne.doers.presentation.navigation.Screen
import edu.ucne.doers.presentation.tareas.components.TaskOverview
import edu.ucne.doers.ui.theme.DoersTheme

@Composable
fun PantallaTareas(
    viewModel: TareaViewModel = hiltViewModel(),
    goBackToHome: () -> Unit,
    goToAgregarTarea: () -> Unit,
    navController: NavHostController
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    PantallaBodyTareas(
        uiState,
        goBackToHome,
        goToAgregarTarea,
        onEdit = { tareaId ->
            navController.navigate(Screen.CrearTarea(tareaId))
        },
        onDelete = { tarea ->
            viewModel.delete(tarea)
        },
        navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaBodyTareas(
    uiState: TareaUiState,
    goBackToHome: () -> Unit,
    goToAgregarTarea: () -> Unit,
    onEdit: (Int) -> Unit,
    onDelete: (TareaEntity) -> Unit,
    navController: NavHostController
){
    val azulMar = Color(0xFF1976D2)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Doers",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = Color.White
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = goBackToHome) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Volver",
                            tint = Color.White
                        )
                    }
                },
                actions = {
                    IconButton(onClick = goToAgregarTarea) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Agregar tarea",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = azulMar
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                currentScreen = Screen.PantallaTareas
            )
        },
        content = { paddingValues ->
            TaskOverview(
                modifier = Modifier.padding(paddingValues),
                tareas = uiState.listaTareas,
                onEdit = onEdit,
                onDelete = onDelete
            )
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavController, currentScreen: Screen) {
    NavigationBar(
        containerColor = Color(0xFFE0E6EB),
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Checklist, contentDescription = "Tarea") },
            label = { Text("Tarea") },
            selected = currentScreen == Screen.PantallaTareas,
            onClick = { }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Star, contentDescription = "Recompensas") },
            label = { Text("Recompensas") },
            selected = currentScreen == Screen.RecompensaList,
            onClick = { navController.navigate(Screen.RecompensaList) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            selected = currentScreen == Screen.Padre,
            onClick = { navController.navigate(Screen.Padre) }
        )
    }
}