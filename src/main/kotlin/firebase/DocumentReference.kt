package firebase

import kotlin.js.Promise
import kotlin.js.json

external interface DocumentReference {

    val id: String

    fun get(): Promise<DocumentSnapshot>
    fun collection(collectionPath: String): CollectionReference

    fun create(data: dynamic): Promise<WriteResult>
    fun set(data: Any, options: Any? = definedExternally): Promise<WriteResult>

    fun delete(precondition: Precondition = definedExternally): Promise<WriteResult>

    fun update(data: dynamic): Promise<Any?>
    fun update(field: dynamic, precondition: dynamic = definedExternally): Promise<dynamic>

}

fun DocumentReference.setValues(vararg pairs: Pair<String, Any?>): Promise<WriteResult> {
    return set(json(*pairs))
}

fun DocumentReference.updateValues(vararg pairs: Pair<String, Any?>): Promise<Any?> {
    return update(json(*pairs))
}
