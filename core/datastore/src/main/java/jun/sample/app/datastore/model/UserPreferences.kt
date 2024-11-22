package jun.sample.app.datastore.model

import kotlinx.serialization.Serializable

@Serializable
data class UserPreferences(
    val a: String = ""
)
