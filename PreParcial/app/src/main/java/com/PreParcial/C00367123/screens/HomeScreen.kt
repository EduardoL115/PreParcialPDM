package com.PreParcial.C00367123.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.PreParcial.C00367123.data.model.Pet
import com.PreParcial.C00367123.ui.components.PetCard
import com.PreParcial.C00367123.viewmodel.PetViewModel

@Composable
fun HomeScreen(
    viewModel: PetViewModel = viewModel(),
    onPetClick: (Pet) -> Unit
) {
    val search = viewModel.searchQuery
    val petList = viewModel.filteredPets

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        OutlinedTextField(
            value = search,
            onValueChange = { viewModel.onSearchQueryChanged(it) },
            label = { Text("Buscar mascota") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(petList) { pet ->
                PetCard(pet = pet, onClick = { onPetClick(pet) })
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
