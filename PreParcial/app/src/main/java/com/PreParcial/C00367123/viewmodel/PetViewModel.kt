package com.PreParcial.C00367123.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.PreParcial.C00367123.data.model.Pet
import com.PreParcial.C00367123.data.model.petList

class PetViewModel : ViewModel() {

    // Estado de búsqueda
    var searchQuery by mutableStateOf("")
        private set

    // Función para actualizar el texto de búsqueda
    fun onSearchQueryChanged(query: String) {
        searchQuery = query
    }

    // Lista filtrada de mascotas
    val filteredPets: List<Pet>
        @Composable
        get() = remember(searchQuery) {
            if (searchQuery.isBlank()) {
                petList
            } else {
                petList.filter {
                    it.name.contains(searchQuery, ignoreCase = true) ||
                            it.type.contains(searchQuery, ignoreCase = true)
                }
            }
        }
}
