package jun.sample.app.model.etc

sealed interface ConnectionState {
    data object Available : ConnectionState
    data object Unavailable : ConnectionState
}