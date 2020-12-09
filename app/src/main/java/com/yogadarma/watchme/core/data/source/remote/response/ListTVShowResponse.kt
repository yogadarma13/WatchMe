package com.yogadarma.watchme.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTVShowResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TVShowResponse>,

	@field:SerializedName("total_results")
	val totalResults: Int
)
