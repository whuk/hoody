package me.ryan.black.hoody.api.permission

object RoleHeader {

    sealed interface Role

    object XAdmin : Role {
        const val NAME = "admin ID"
        const val KEY = "x-admin-id"
        const val DATA_TYPE = "long"
        const val PARAM_TYPE = "header"
    }

    object XPartner : Role {
        const val NAME = "partner ID"
        const val KEY = "x-partner-id"
        const val DATA_TYPE = "long"
        const val PARAM_TYPE = "header"
    }

    object XUser : Role {
        const val NAME = "user ID"
        const val KEY = "x-user-id"
        const val DATA_TYPE = "long"
        const val PARAM_TYPE = "header"
    }

    object XSystem : Role {
        const val NAME = "system ID"
        const val KEY = "x-system-id"
        const val DATA_TYPE = "String"
        const val PARAM_TYPE = "header"
    }
}
