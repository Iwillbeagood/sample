package jun.sample.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Splash : Route

}

sealed interface MainTabRoute : Route {


}

