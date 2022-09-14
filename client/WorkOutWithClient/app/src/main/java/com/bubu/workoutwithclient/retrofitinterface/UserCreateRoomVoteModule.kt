package com.bubu.workoutwithclient.retrofitinterface

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.io.EOFException
import java.net.SocketTimeoutException

/**
 * UserCreateRoomVoteModule
 * create a Vote in Match Room
 *
 * Parameter : UserCreateRoomVoteData
 * shown below
 *
 *
 * Return Value : UserError / Http Response Code
 * If communication is successful Response Code
 * else UserError
 *
 * Exception :
 * SocketTimeOutException : if Server is closed
 * EOFException : Response Type Mismatch
 * Exception :
 * Exceptions we don't know yet
 * */

data class UserCreateRoomVoteData(
    val voteTitle: String, val matchId: String, val startTime: String,
    val endTime: String, val date: String, val content: String
)

data class UserCreateRoomVoteResponseData(
    @SerializedName("voteId") val voteId: String
)

class UserCreateRoomVoteModule(override val userData: UserCreateRoomVoteData) : UserApiInterface {

    interface UserCreateRoomVoteInterface {
        @Headers("Content-Type: application/json")
        @POST("/v1/matching/vote")
        fun get(
            @Body body: JsonObject
        ): Call<Any>
        //보내는 데이터 형식
    }

    override suspend fun getApiData(): Any? {
        try {
            var auth = UserAuthModule()
            val result = auth.getApiData()
            if (result == true) {
                val retrofit = ApiTokenHeaderClient.getApiClient()
                val retrofitObject = retrofit.create(UserCreateRoomVoteInterface::class.java)
                try {
                    val requestData = JsonObject()
                    requestData.addProperty("voteTitle", userData.voteTitle)
                    requestData.addProperty("matchId", userData.matchId)
                    requestData.addProperty("startTime", userData.startTime)
                    requestData.addProperty("endTime", userData.endTime)
                    requestData.addProperty("date", userData.date)
                    requestData.addProperty("content", userData.content)
                    var resp = retrofitObject.get(requestData).execute()
                    if (resp.code() in 100..199) {
                        return super.handle100(resp)
                    } else if (resp.code() in 200..299) {
                        val responseBody = super.handle200(resp)
                        val jsonString: String = Gson().toJsonTree(responseBody).asJsonObject.toString()
                        Log.d("jsonString", jsonString)
                        Log.d("After jsonString",jsonString.replace("\"",""))
                        return convertToClass(jsonString, UserCreateRoomVoteResponseData::class.java)
                    } else if (resp.code() in 300..399) {
                        return super.handle300(resp)
                    } else if (resp.code() in 400..499) {
                        return super.handle400(resp)
                    } else {
                        return super.handle500(resp)
                    }
                } catch (e: SocketTimeoutException) {
                    Log.d("TimeOutException", e.toString())
                    return e
                } catch (e: Exception) {
                    Log.d("Exception", e.toString())
                    return e
                } catch (e: EOFException) {
                    Log.d("EOFException Maybe Response Data Type Mismatch", e.toString())
                    return e
                }
            } else if (result is UserError) {
                //Auth Error Handling
                Log.d("error", "AuthError")
                return result
            } else if (result is UninitializedPropertyAccessException) {
                //Auth Error Handling
                Log.d("Exception", "AuthError")
                return result
            } else if (result is SocketTimeoutException) {
                //Auth Error Handling
                Log.d("Exception", "AuthError")
                return result
            } else if (result is EOFException) {
                //Auth Error Handling
                Log.d("Exception", "AuthError")
                return result
            } else if (result is Exception) {
                //Auth Error Handling
                Log.d("Exception", "AuthError")
                return result
            } else {
                //What is This ?
                Log.d("Exception", "What is this? ${result.toString()}")
                return result
            }
        } catch (e: SocketTimeoutException) {
            Log.d("TimeOutException Maybe Server Closed", e.toString())
            return e
        } catch (e: EOFException) {
            Log.d("EOFException Maybe Response Data Type Mismatch", e.toString())
            return e
        } catch (e: Exception) {
            Log.d("Exception", e.toString())
            return e
        }
    }
}