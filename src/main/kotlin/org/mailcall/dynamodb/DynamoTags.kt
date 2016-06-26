package org.mailcall.dynamodb

import org.kale.api.Tags

/**
 * @author Odysseus Levy (odysseus@cosmosgame.org)
 */
class DynamoTags : Tags {
    override fun addTag(tag: String, value: Any) {
        throw UnsupportedOperationException()
    }

    override fun hasTag(tag: String): Boolean {
        throw UnsupportedOperationException()
    }

    override fun removeTag(tag: String) {
        throw UnsupportedOperationException()
    }

    override fun getValue(key: String): Any {
        throw UnsupportedOperationException()
    }

    override fun setValue(key: String, value: Any) {
        throw UnsupportedOperationException()
    }

    override fun getTags(): Set<String> {
        throw UnsupportedOperationException()
    }

    override fun isValid(): Boolean {
        throw UnsupportedOperationException()
    }

    override fun addTag(tag: String) {
        throw UnsupportedOperationException()
    }


}