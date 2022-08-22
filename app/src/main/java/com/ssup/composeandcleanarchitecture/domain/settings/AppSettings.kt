package com.ssup.composeandcleanarchitecture.domain.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class AppSettings(private val context: Context) {

    private val scope = CoroutineScope(Dispatchers.Main)

    fun writeAccessToken(accessToken: String) {
        scope.launch {
            context.dataStore.edit { preferences ->
                preferences[ACCESS_TOKEN] = accessToken
            }
        }
    }

    fun getAccessToken(): String? {
        return runBlocking {
            context.dataStore.data.first()[ACCESS_TOKEN]
        }
    }

    companion object {
        private val ACCESS_TOKEN = stringPreferencesKey("access_token")
    }
}