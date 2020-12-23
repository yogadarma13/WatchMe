package com.yogadarma.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTVShowResponse(

	@field:SerializedName("results")
	val results: List<TVShowResponse>? = null

)
