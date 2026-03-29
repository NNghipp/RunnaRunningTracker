package com.example.runna_runningtracker.data.repository

import com.google.firebase.auth.FirebaseAuth

class AuthRepository(
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {
    // Tra ve uid hien tai de MainActivity biet user da login hay chua.
    fun getCurrentUserId(): String? = auth.currentUser?.uid

    // Dung khi muon check session cu luc app mo lai.
    fun hasActiveSession(): Boolean = auth.currentUser != null

    // Logout chi xoa session Auth, UI se duoc MainActivity reset sau.
    fun signOut() = auth.signOut()

    fun login(
        email: String,
        password: String,
        onSuccess: (String?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        // Repo hold pack Firebase, Activity chi xu ly UI va flow.
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { result -> onSuccess(result.user?.uid) }
            .addOnFailureListener { error -> onFailure(error.message ?: "Unknown login error") }
    }

    fun register(
        email: String,
        password: String,
        onSuccess: (String?) -> Unit,
        onFailure: (String) -> Unit
    ) {
        // Register o day moi tao tk Auth, chua ghi vao profile Firestore.
        auth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener { result -> onSuccess(result.user?.uid) }
            .addOnFailureListener { error -> onFailure(error.message ?: "Unknown register error") }
    }

    fun sendPasswordReset(
        email: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        // Gui email reset password toi dia chi user da nhap.
        auth.sendPasswordResetEmail(email)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { error -> onFailure(error.message ?: "Unknown reset error") }
    }
}
