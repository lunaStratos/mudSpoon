package com.lunastratos.mudspoon.Util.Example

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class SingleTonSample {

    @Autowired
    private val proto: Proto? = null

    fun getProto(): Proto? {
        return proto
    }

}