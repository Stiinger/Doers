/*
package edu.ucne.doers.data.repository

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import edu.ucne.doers.data.remote.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error desconocido"))
        }
    }

    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>> = flow {
        try {
            emit(Resource.Loading())
            val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Error desconocido"))
        }
    }

    fun getUser(): String? {
       return firebaseAuth.currentUser?.email
    }

    fun logout(){
        firebaseAuth.signOut()
    }
}*/

package edu.ucne.doers.data.repository

import edu.ucne.doers.presentation.sign_in.GoogleAuthUiClient
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val googleAuthUiClient: GoogleAuthUiClient
) {
    suspend fun getUser() = googleAuthUiClient.getSignedInUser()

    suspend fun logout() = googleAuthUiClient.signOut()
}