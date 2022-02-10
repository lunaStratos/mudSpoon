package com.lunastratos.mudspoon.Entity.Domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "")
data class LatLngDomain (

    @ApiModelProperty(required = true, value="127.3892328", example = "127.3892328")
    val lng: Double,
    @ApiModelProperty(required = true, value="37.3892328", example = "37.3892328")
    val lat: Double

    )