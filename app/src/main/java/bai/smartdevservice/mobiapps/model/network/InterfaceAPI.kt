/*
 * @author B.A.Ismail
 * 
 */
package bai.smartdevservice.mobiapps.model.network

import bai.smartdevservice.mobiapps.model.data.AllPlayerResponse
import bai.smartdevservice.mobiapps.model.data.AllTeamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface for Test API.
 *
 */
interface InterfaceAPI {

    @GET("search_all_teams.php")
    fun searchAllTeams(@Query("l") league: String): Call<AllTeamResponse>

    @GET("lookup_all_teams.php")
    fun getAllTeamInLeagueById(@Query("id") idTeam: String): Call<AllTeamResponse>

    @GET("lookup_all_players.php")
    fun getAllPlayersInTeamById(@Query("id") idTeam: String): Call<AllPlayerResponse>


}
